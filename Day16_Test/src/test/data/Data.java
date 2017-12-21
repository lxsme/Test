package test.data;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import test.instance.Person;
import test.tool.ExecuteInter;
import test.tool.JDBCtool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    static SAXReader saxReader = new SAXReader();
    static Document document = null;


    // 写入xml
    public static void set(Person person) throws DocumentException, IOException {

        Element root = null;
        try {
            document = saxReader.read(new File("src/denglu.xml"));
            root = document.getRootElement();
        } catch (DocumentException e) {
            document = DocumentHelper.createDocument();
            root = document.addElement("信息");
        }
        Element user = root.addElement("用户名");
        user.addAttribute("用户名", person.getName());
        user.addAttribute("昵称", person.getNickname());
        user.addAttribute("密码", person.getPossWork());
        user.addAttribute("成绩", person.getScore());

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileWriter("src/denglu.xml"), outputFormat);
        writer.write(document);
        writer.close();


    }

    // 获取xml文件
    public static Map<String, Person> get() throws DocumentException {
        Map<String, Person> map = new HashMap<>();

        try {
            document = saxReader.read(new File("src/denglu.xml"));
            Element root = document.getRootElement();

            List<Element> elements = root.elements();
            for (Element element : elements) {
                Attribute name = element.attribute("用户名");
                String nameValue = name.getValue();
                Attribute nickName = element.attribute("昵称");
                String nickNameValue = nickName.getValue();
                Attribute possWord = element.attribute("密码");
                String possWordValue = possWord.getValue();
                Attribute score = element.attribute("成绩");
                String scoreValue = score.getValue();


                Person person = new Person(nameValue, nickNameValue, possWordValue, scoreValue);
                map.put(nameValue, person);

            }
        } catch (DocumentException e) {

        }
        return map;
    }


    // 修改xml已有文件中的内容
//    public static void amend(Person person, long score) throws DocumentException, IOException {
//        String so = score + "";
//        document = saxReader.read(new File("src/denglu.xml"));
//        Element root = document.getRootElement();
//        List<Element> elements = root.elements();
//        for (Element element : elements) {
//            if ((element.attribute("用户名").getValue()).equals(person.getName())) {
//
//                String sc = element.attribute("成绩").getValue();
//                int scc = Integer.valueOf(sc);
//                int soo = Integer.valueOf(so);
//                if (scc > soo) {
//                    element.attribute("成绩").setValue(so);
//                }
//            }
//        }
//        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
//        outputFormat.setEncoding("UTF-8");
//        XMLWriter writer = new XMLWriter(new FileWriter("src/denglu.xml"), outputFormat);
//        writer.write(document);
//        writer.close();
//
//    }


    // 操作数据库
    // 添加
    public static void setInDatabase(Person person) throws ClassNotFoundException, SQLException {

        JDBCtool.execute1(new ExecuteInter() {
            @Override
            public Statement execute(Connection conn) throws SQLException {
                String sql = "INSERT  INTO uers VALUES (" + person.getName() + "," + person.getNickname() + "," + person.getPossWork() + "," + person.getScore() + ");";
                PreparedStatement pstate = conn.prepareStatement(sql);
                pstate.execute();

                return null;
            }
        });

    }


    // 取得数据
    public static Map<String, Person> getInDatabase() throws SQLException {


        QueryRunner qr = new QueryRunner();

        String sql = "select * from uers";



        Map<String,Person> query = qr.query(JDBCtool.getConnection(), sql, new ResultSetHandler<Map<String,Person>>() {
            @Override
            public Map<String,Person> handle(ResultSet resultSet) throws SQLException {


                Map<String,Person> users = new HashMap<>();

                while (resultSet.next()) {
                  Person person = new Person();
                    person.setName(resultSet.getString(1));
                    person.setNickname(resultSet.getString(2));
                    person.setPossWork(resultSet.getString(3));
                    person.setScore(resultSet.getString(4));
                    users.put(resultSet.getString(1),person);
                }



                return users;
            }
        });





        return query;
    }



// 修改
public static void amendInDatabase(Person person, long score) throws SQLException {
    JDBCtool.execute1(new ExecuteInter() {
        @Override
        public Statement execute(Connection conn) throws SQLException {
            PreparedStatement ptate = conn.prepareStatement("UPDATE uers SET sorce=" + score + "  WHERE name =" + person.getName());
            ptate.execute();


            return null;
        }
    });



}




    


}
