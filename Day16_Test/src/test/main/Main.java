package test.main;

import org.dom4j.DocumentException;
import test.instance.Person;
import test.data.Data;
import test.tool.Input;
import test.tool.Threads;
import test.URL.URLFind;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, DocumentException, InterruptedException {
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
                            urlFind.find(id,1);
                            break;
                        case 2:
                            System.out.println("请输入电话号码");
                            String number = scanner.next();
                            urlFind.find(number,2);
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
                            Data.amend(person,sorce);
                            


                            break;
                        case 4:
                            break;
                            default:
                                break;
                    }









                    break;
                default:
                    break;
            }


        }
    }
}
