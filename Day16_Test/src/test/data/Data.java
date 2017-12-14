package test.data;


import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import test.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    static SAXReader saxReader = new SAXReader();
   static Document document=null;



   // 写入xml
    public static void set(Person person) throws DocumentException, IOException {

        Element root = null;
    try {
        document = saxReader.read(new File("src/denglu.xml"));
        root = document.getRootElement();
    }catch (DocumentException e) {
        document = DocumentHelper.createDocument();
        root = document.addElement("信息");
    }
        Element user = root.addElement("用户名");
         user.addAttribute("用户名", person.getName());
         user.addAttribute("昵称", person.getNickname());
         user.addAttribute("密码",person.getPossWork());
         user.addAttribute("分数",person.getScore()+"");


        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileWriter("src/denglu.xml"),outputFormat);
        writer.write(document);
        writer.close();


    }

    // 获取xml文件
    public static Map<String,Person> get() throws DocumentException {
        Map<String, Person> map = new HashMap<>();

        try {
            document = saxReader.read(new File("src/denglu.xml"));
            Element root = document.getRootElement();

            List<Element> elements = root.elements();
            for (Element element : elements) {
                Attribute name = element.attribute("用户名");
                String nameValue = name.getValue();
                Attribute nickName = element.attribute("昵称");
                String nickNameValue = name.getValue();
                Attribute possWord = element.attribute("密码");
                String possWordValue = possWord.getValue();
                Attribute score = element.attribute("分数");
                String scoreValue = possWord.getValue();



                Person person = new Person(nameValue, possWordValue,nickNameValue,scoreValue);
                map.put(nameValue, person);

            }
        }catch (DocumentException e){

        }
        return map;
    }




}
