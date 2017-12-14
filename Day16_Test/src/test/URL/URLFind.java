package test.URL;


import net.sf.json.JSONObject;
import org.junit.Test;
import test.constant.Website;

import java.io.IOException;
import java.io.InputStream;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class URLFind {
    @Test


    public static void find(String id, int i) throws IOException {
        URL url = null;
        if(i==1) {
            url = new URL(("http://www.sojson.com/open/api/weather/json.shtml?city=" + id));
        }
        if(i==2){
            url= new URL(("http://api.k780.com/?app=phone.get&phone="+id+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json"));
        }if(i == 3){
            url = new URL(Website.START);
        }
        java.net.URLConnection uc = url.openConnection();
        InputStream is = uc.getInputStream();
        byte[] buff = new byte[1024*1024];
        StringBuffer sb = new StringBuffer();
        int len = 0;
        while ((len = is.read(buff)) != -1){
            sb.append(new String(buff,0,len));

        }
        System.out.println(sb);

    }










}
