package test.uRL;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import test.instance.Person;

import java.io.IOException;
import java.io.InputStream;

import java.net.*;

import static test.constant.Website.TOP_TEN;


public class URLFind {
    @Test


    public static StringBuffer find(String id, int i) throws IOException {
        URL url = null;
        if(i==1) {
            url = new URL(("http://www.sojson.com/open/api/weather/json.shtml?city=" + id));
        }
        if(i==2){
            url= new URL(("http://api.k780.com/?app=phone.get&phone="+id+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json"));
        }if(i == 3){
            url = new URL(id);
        }
        java.net.URLConnection uc = url.openConnection();
        InputStream is = uc.getInputStream();
        byte[] buff = new byte[1024*1024];
        StringBuffer sb = new StringBuffer();
        int len = 0;
        while ((len = is.read(buff)) != -1){
            sb.append(new String(buff,0,len));

        }


        return sb;
    }



    public static void send(String string) throws IOException {

        DatagramSocket ds = new DatagramSocket(8082);
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("192.168.20.159");

        byte[] bytes = string.getBytes();
        DatagramPacket dp  = new DatagramPacket(bytes,bytes.length,address,8180);

        ds.send(dp);


    }


    public static void person() throws IOException {
        StringBuffer str = find(TOP_TEN, 3);

        JSONArray jsonArray = JSONArray.fromObject(str);
        for (int i=0;i<jsonArray.size();i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Person person = (Person) JSONObject.toBean(jsonObject, Person.class);
            System.out.println("第" + (i+1) + "名: " + person.toString());
        }
    }











}
