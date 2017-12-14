package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(8180);

        Socket s = ss.accept();
        InputStream is  = s.getInputStream();

        byte[] buf = new  byte[24];

        int len = 0;
        String c="";
        StringBuffer sb = new StringBuffer();

        while ((len = is.read(buf)) != -1){
            String contant = new String(buf,0,len);
            sb.append(contant);
        }

        System.out.println(sb);
        ss.close();




    }



}
