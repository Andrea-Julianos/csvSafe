package com.zhibei.csvSafe.test;

import com.zhibei.csvSafe.function.HttpClientUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class HttpClientTest {


    /**
     *  用HttpClient访问网络, 并读取json
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        //模拟打开浏览器
        CloseableHttpClient client = HttpClients.createDefault();
        //设置请求对象HttpGet
        HttpGet httpGet = new HttpGet("http://192.168.11.160:8090/db/metadata/show?tdsourcetag=s_pctim_aiomsg");

        //发起请求
        CloseableHttpResponse response = client.execute(httpGet);

        //基于状态码判断, 如果请求充公, 返回请求结果 EntityUtils
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
        }


    }


    /**
     * JSON Test
     */
    @Test
    public void test2() {
        String json = HttpClientUtils.getJson();
        System.out.println(json);

    }
}
