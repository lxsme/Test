package test.main;

import org.dom4j.DocumentException;
import test.constant.Website;
import test.instance.Person;
import test.data.Data;
import test.tool.Input;
import test.tool.Threads;
import test.uRL.URLFind;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, DocumentException, InterruptedException, SQLException, ClassNotFoundException {
        Input input= new Input();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1-注册  2-登录");
            int chooce = scanner.nextInt();
            switch (chooce) {
                case 1:
                    while (true) {
                        System.out.println("请输入账号");
                        String name = scanner.next();
                        System.out.println("请输入密码");
                        String possWord = scanner.next();
                        Person person = input.register(name, possWord);
                        String nickName = null;
                        Person person1=null;
                        if (person !=null) {
                            System.out.println("请输入你的昵称");
                            nickName = scanner.next();
                             person1=input.addNickName(person,nickName);
                        }

                        if (person1 != null) {
                            break;
                        }
                    }
                    break;
                case 2:
                    Person person;
                    while (true) {
                        input.show();
                        System.out.println("请输入账号");
                        String name1 = scanner.next();
                        System.out.println("请输入密码");
                        String possWord1 = scanner.next();

                        person = input.enter(name1, possWord1);
                        if (person != null) {
                            break;
                        }
                    }
                    System.out.println("1-查询天气");
                    System.out.println("2-查询手机号归属地");
                    System.out.println("3-手速游戏");
                    System.out.println("4-查询手速游戏前十用户");

                    int chooce1 = scanner.nextInt();
                    URLFind urlFind = new URLFind();
                    switch (chooce1){
                        case 1:
                            System.out.println("请选择城市");
                            String id = scanner.next();
                            StringBuffer stringBuffer1 = urlFind.find(id, 1);
                            System.out.println(stringBuffer1);
                            break;
                        case 2:
                            System.out.println("请输入电话号码");
                            String number = scanner.next();
                            StringBuffer stringBuffer = urlFind.find(number, 2);
                            System.out.println(stringBuffer);
                            break;
                        case 3:
                            System.out.println("请选择难度 1-简单 2-适中 3-困难");
                            int chose =scanner.nextInt();
                            Threads th = new Threads();
                            String string1=th.getRandomCharAndNumr(chose);
                            System.out.println(string1);
                            th.start1();
                            System.out.println("游戏开始");
                            long startTime = System.currentTimeMillis();
                            long endTime=0;
                            while (true) {
                                String string = scanner.next();
                                if (string1.equals(string)) {
                                    endTime = System.currentTimeMillis();
                                    break;
                                }
                                System.out.println("不正确");
                            }
                            long sorce = endTime-startTime;
                            System.out.println("用时:"+sorce+"毫秒");
                            Data.amendInDatabase(person,sorce);
                            String id1 = Website.BEGIN+"insert?username="+person.getNickname()+"&score="+sorce;
//                            System.out.println(id1);
                            urlFind.send(id1);



                            break;
                        case 4:
                            System.out.println("前十名有:");
                            URLFind.person();

                            break;
                            default:
                                System.out.println("没有改项目");
                                break;
                    }

                    break;
                default:
                    System.out.println("只有注册和登录");
                    break;
            }


        }
    }
}
