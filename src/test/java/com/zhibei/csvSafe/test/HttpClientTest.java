package com.zhibei.csvSafe.test;

import com.zhibei.csvSafe.function.HttpClientUtils;

import org.junit.Test;



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
}
