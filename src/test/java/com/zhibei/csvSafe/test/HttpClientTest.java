package com.zhibei.csvSafe.test;

import com.zhibei.csvSafe.function.HttpClientUtils;

import com.zhibei.otldb.api.EncryptApi;
import org.junit.Test;

import java.io.UnsupportedEncodingException;


public class HttpClientTest {




    /**
     * JSON Test
     */
    @Test
    public void test2() {
        String json = HttpClientUtils.getJson();
        System.out.println(json);
        String s = json;
        System.out.println(s.length());

    }

    @Test
    public void test1() throws UnsupportedEncodingException {

        /*
        [6, 黀鋜戯, 20190501]
[6, 黀鋜戯, ,29697694]
[7, 淕愈屣, 20190302]
[7, 淕愈屣, +27423067]
[8, 譒男蘘, 20190101]
[8, 譒男蘘, (16148535]
[9, 斾鮦委, 2019/1/1]
[9, 斾鮦委, 怺4353/5/8]
[10, 脥餀沦, 2019/1/1]
[10, 脥餀沦, 怺4353/5/8]
         */


        String s2 = "榛€閶滄埊";
//        String s2 = EncryptApi.encrypt2("白色");
        byte[] bytes = s2.getBytes("GB2312");
        String s1 = new String(bytes, "GB2312");







        String s = EncryptApi.decrypt2(s1);



        System.out.println(s);




    }
}
