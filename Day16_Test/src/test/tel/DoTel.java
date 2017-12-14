package test.tel;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DoTel {
    @Test
    public void find(String string) throws IOException {

        URL url= new URL(("http://api.k780.com/?app=phone.get&phone="+string+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json"));

        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();
        byte[] buff = new byte[1024*1024];
        StringBuffer sb =new StringBuffer();
        int len =0;
        while (((len= is.read(buff)) !=-1)) {
           sb.append(new String(buff, 0, len)) ;

        }

        System.out.println(sb);





    }

}
