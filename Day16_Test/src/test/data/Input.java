package test.data;


import org.dom4j.DocumentException;
import test.Person;

import java.io.IOException;

import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class Input {

    // 输入昵称
    public Person addNickName(Person person, String nickName) throws IOException, DocumentException {
        boolean isM ;
    if(!(isM = Pattern.matches("[A-Za-z].*", nickName))){
        System.out.println("昵称只能是英文名");
        return null;
    }
        person.setNickname(nickName);
        Data.set(person);

        return person;

    }



    // 注册
    public Person register(String name, String possWord) throws DocumentException, IOException {

        Map<String, Person> map = Data.get();
        if (map != null) {
            Set<String> keySet = map.keySet();
            for (String s : keySet) {
                if (s.equals(name)) {
                    System.out.println("用户已存在");
                    return null;
                }
            }
        }
        Boolean isMatched;
        if (!((isMatched = Pattern.matches("[1]\\d{10}", name)) || (isMatched = Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", name)))) {
            System.out.println("请输入手机号或邮箱号");
            return null;
        }

        if (!((isMatched = Pattern.matches(".*[a-z]+.*", possWord))&&
                (isMatched = Pattern.matches(".*[A-Z]{1,}.*", possWord))&&
                        (isMatched = Pattern.matches(".*[0-9]{1,}.*", possWord)))){

            System.out.println("密码不符合规范");
            return null;
        }
        Person person = new Person(name, possWord);
        System.out.println("注册成功");

        return person;
    }

    // 遍历
    public void show() throws DocumentException {
        Map<String, Person> map = Data.get();
        Set<String> strings = map.keySet();
        for (String string : strings) {
            String name = map.get(string).getName();
            String possWork = map.get(string).getPossWork();
            System.out.print(name+"----"+possWork);
            System.out.println();
        }

    }

    // 登录
    public Person enter(String name, String possWord) throws DocumentException {
        Map<String, Person> map = Data.get();
        if (map != null) {
            Set<String> keySet = map.keySet();
            for (String s : keySet) {
                if (s.equals(name)) {
                    if ((map.get(s).getPossWork()).equals(possWord)) {
                        System.out.println("登录成功");
                        System.out.println("用户名:"+map.get(s).getNickname());

                        return map.get(s);
                    } else {
                        System.out.println("密码不正确");
                        return null;
                    }
                }
            }

        }
        System.out.println("账户不存在");
        return null;
    }
}
