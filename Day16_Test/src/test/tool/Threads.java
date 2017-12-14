package test.tool;

import org.junit.Test;

import java.util.Random;

public class Threads {

    public void start1() throws InterruptedException {

        for (int i = 3; i > 0; i--) {
            System.out.println("倒计时" + i + "秒钟后开始");
            Thread.sleep(1000);
        }


    }



    // 随机字母
    @Test
        //参数length，表示生成几位随机数
    public  String getRandomCharAndNumr(int chose) {
        Random random = new Random();
        boolean a=true;
        int length = 0;

        if (chose ==1){
            a =false;
            length =10;
        }
        if(chose == 2){
            length = 20;
            a =random.nextBoolean();
        }if (chose==3){
            length=30;
        }

        String str = "";

        for (int i = 0; i < length; i++) {
            boolean b = random.nextBoolean();

            if (chose==3){
                str +=(char)(33+random.nextInt(94));
                return str;
            }

            if (b) { // 字符串
                 int choice = a ? 65 : 97; //取得65大写字母还是97小写字母
                str += (char) (choice + random.nextInt(26));// 取得大写字母
            } else { // 数字
                str += String.valueOf(random.nextInt(10));
            }
        }

        return str;
    }













}