package com.zhibei.csvSafe.function;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;

public class HttpClientUtils {


    private static CloseableHttpClient client;

    private static CloseableHttpResponse response;

    static {
        //模拟打开浏览器
        client = HttpClients.createDefault();
    }

    /**
     * 返回一个JSON格式的String
     *
     * @return Json
     */
    public static String getJson() {

        //设置请求对象HttpGet
        HttpGet httpGet = new HttpGet("http://192.168.11.160:8090/db/metadata/show?tdsourcetag=s_pctim_aiomsg");

        //发起请求
        try {
            response = client.execute(httpGet);

            //基于状态码判断, 如果请求成功, 返回请求结果 EntityUtils
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();

                //返回Json String
                return "da";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


