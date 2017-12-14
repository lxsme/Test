package test.wheather;


import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;


public class WheatherGain {
    @Test
    public void gainWhwather(String id) throws IOException {



        URL url = new URL(("http://api.k780.com/?app=weather.today&weaid="+"id"+"&appkey=29836&sign=4fe58a60443a900a251f8b05763d4622&format=json"));
        java.net.URLConnection uc = url.openConnection();
        InputStream is = uc.getInputStream();
        byte[] buff = new byte[1024*1024];
        StringBuffer sb = new StringBuffer();
        int len = 0;
        while ((len = is.read(buff)) != -1){
            sb.append(new String(buff,0,len));

        }
        System.out.println(sb);
//        JSONObject object = JSONObject.fromObject(sb);
//        Weather weather = (Weather) JSONObject.toBean(object, Weather.class);
//
//        Weather.ResultBean resultBean = new Weather.ResultBean();
//        Map map = new HashMap();
//
//
//        OutputStream os =uc.getOutputStream();
//        ObjectOutputStream e = new ObjectOutputStream(os);
//        e.writeObject(resultBean);
//        e.close();




    }

}
