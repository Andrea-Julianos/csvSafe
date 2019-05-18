package com.zhibei.csvSafe.test;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.deploy.util.ArrayUtil;
import com.zhibei.otldb.global.ColumnAttr;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author guangsheng.tang
 * JackSon树模型结构，可以通过get，JsonPointer等进行操作，适合用来获取大Json中的字段，比较灵活。缺点是如果需要获取的内容较多，
 * 会显得比较繁琐。
 */
public class JsonTest {

    @Test
    public void test4() {

        String s = "{\"CESHI\":{\"otllevel\":1,\"ALLTYPE\":{\"otllevel\":2,\"ADDRESS\":{\"otllevel\":3,\"std\":\"ADDRESS\",\"otl\":\"OTLCOL_YIITGDD\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":256,\"index\":785,\"customregular\":null,\"regulardetail\":null},\"BANKCARD\":{\"otllevel\":3,\"std\":\"BANKCARD\",\"otl\":\"OTLCOL_QYNAHYTI\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":608,\"index\":786,\"customregular\":null,\"regulardetail\":null},\"BUSINESSLICENSE\":{\"otllevel\":3,\"std\":\"BUSINESSLICENSE\",\"otl\":\"OTLCOL_QWDFNGDDSFHGNDG\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":320,\"index\":787,\"customregular\":null,\"regulardetail\":null},\"COMMPANY\":{\"otllevel\":3,\"std\":\"COMMPANY\",\"otl\":\"OTLCOL_HOPPBYNR\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":576,\"index\":788,\"customregular\":null,\"regulardetail\":null},\"DATES\":{\"otllevel\":3,\"std\":\"DATES\",\"otl\":\"OTLCOL_IYMGD\",\"datatype\":\"DATE\",\"note\":null,\"status\":64,\"index\":789,\"customregular\":null,\"regulardetail\":null},\"EMAIL\":{\"otllevel\":3,\"std\":\"EMAIL\",\"otl\":\"OTLCOL_GPYFS\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":224,\"index\":790,\"customregular\":null,\"regulardetail\":null},\"FIXEDTELEPHONE\":{\"otllevel\":3,\"std\":\"FIXEDTELEPHONE\",\"otl\":\"OTLCOL_KFEGIMGSGBVONG\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":96,\"index\":791,\"customregular\":null,\"regulardetail\":null},\"ID\":{\"otllevel\":3,\"std\":\"ID\",\"otl\":\"OTLCOL_FI\",\"datatype\":\"NUMBER\",\"note\":null,\"status\":32,\"index\":792,\"customregular\":null,\"regulardetail\":null},\"IDNUMBER\":{\"otllevel\":3,\"std\":\"IDNUMBER\",\"otl\":\"OTLCOL_FINWPQGT\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":160,\"index\":793,\"customregular\":null,\"regulardetail\":null},\"MOBILEPHONE\":{\"otllevel\":3,\"std\":\"MOBILEPHONE\",\"otl\":\"OTLCOL_POQFSGBVONG\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":128,\"index\":794,\"customregular\":null,\"regulardetail\":null},\"MONEY\":{\"otllevel\":3,\"std\":\"MONEY\",\"otl\":\"OTLCOL_PONGR\",\"datatype\":\"NUMBER\",\"note\":null,\"status\":32,\"index\":795,\"customregular\":null,\"regulardetail\":null},\"NAME\":{\"otllevel\":3,\"std\":\"NAME\",\"otl\":\"OTLCOL_NYPG\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":192,\"index\":796,\"customregular\":null,\"regulardetail\":null},\"ORGANIZATION\":{\"otllevel\":3,\"std\":\"ORGANIZATION\",\"otl\":\"OTLCOL_OTZYNFJYMFON\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":288,\"index\":797,\"customregular\":null,\"regulardetail\":null},\"PASSPORT\":{\"otllevel\":3,\"std\":\"PASSPORT\",\"otl\":\"OTLCOL_BYDDBOTM\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":416,\"index\":798,\"customregular\":null,\"regulardetail\":null},\"TAXATION\":{\"otllevel\":3,\"std\":\"TAXATION\",\"otl\":\"OTLCOL_MYEYMFON\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":352,\"index\":799,\"customregular\":null,\"regulardetail\":null},\"TIMESTAMPS\":{\"otllevel\":3,\"std\":\"TIMESTAMPS\",\"otl\":\"OTLCOL_MFPGDMYPBD\",\"datatype\":\"TIMESTAMP(6)\",\"note\":null,\"status\":64,\"index\":800,\"customregular\":null,\"regulardetail\":null},\"UNIFIEDSOCIALCREDITCODE\":{\"otllevel\":3,\"std\":\"UNIFIEDSOCIALCREDITCODE\",\"otl\":\"OTLCOL_WNFKFGIDOHFYSHTGIFMHOIG\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":384,\"index\":801,\"customregular\":null,\"regulardetail\":null},\"VARCHARS\":{\"otllevel\":3,\"std\":\"VARCHARS\",\"otl\":\"OTLCOL_UYTHVYTD\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":32,\"index\":802,\"customregular\":null,\"regulardetail\":null},\"ZIPCODE\":{\"otllevel\":3,\"std\":\"ZIPCODE\",\"otl\":\"OTLCOL_JFBHOIG\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":448,\"index\":803,\"customregular\":null,\"regulardetail\":null}}}}";


        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println("简单获取单个有效值");
        Integer integer = jsonObject.getJSONObject("CESHI").getJSONObject("ALLTYPE").getJSONObject("ADDRESS").getInteger("status");
        System.out.println(integer);
        System.out.println("---------------------------------------");

        //得到表的JSON
        JSONObject tableJson = jsonObject.getJSONObject("CESHI").getJSONObject("ALLTYPE");
        System.out.println("遍历获取 字段名");

        //得到要加密的字段的 String数组
        List<String> encryptFiled = new ArrayList<>();

        Set<String> fields = tableJson.keySet();

        //移除级别判断 "otllevel"
        fields.remove((String) "otllevel");

        System.out.println("status =====");
        for (String field : fields) {

            //分别获取 每个字段名 的status
            Integer status = tableJson.getJSONObject(field).getInteger("status");
            System.out.println(status);
            // 大于0, 表示要加密
            if (ColumnAttr.getEncrypt(status) <= 0) {
                encryptFiled.add(field);

            }

        }

        System.out.println(encryptFiled.size());
        System.out.println("---------------------------------------");


    }


    @Test
    public void test() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //以下是对象转化为Json
        JsonNode root = mapper.createObjectNode();
        ((ObjectNode) root).putArray("array");
        ArrayNode arrayNode = (ArrayNode) root.get("array");
        ((ArrayNode) arrayNode).add("args1");
        ((ArrayNode) arrayNode).add("args2");
        ((ObjectNode) root).put("name", "小红");
        String json = mapper.writeValueAsString(root);
        System.out.println("使用树型模型构建的json: " + json);

        //-----------------------------------------------------------------------------------------------------------------
        //以下是树模型的解析Json
        String s = "{\"id\": 1,\"name\": \"小明\",\"array\": [\"1\", \"2\"]," +
                "\"test\": \"I'm test\",\"nullNode\": null,\"base\": {\"major\": \"物联网\",\"class\": \"3\"}}";
        //读取rootNode
        JsonNode rootNode = mapper.readTree(s);

        //通过path获取
        System.out.println("通过path获取值：" + rootNode.path("name").asText());

        //通过JsonPointer可以直接按照路径获取
        JsonPointer pointer = JsonPointer.valueOf("/base/major");
        JsonNode node = rootNode.at(pointer);
        System.out.println("通过at获取值: " + node.asText());

        //通过get可以取对应的value
        JsonNode classNode = rootNode.get("base");
        System.out.println("通过get获取值：" + classNode.get("major").asText());

        //获取数组的值
        System.out.print("获取数组的值：");
        JsonNode arrayNode2 = rootNode.get("array");
        for (int i = 0; i < arrayNode2.size(); i++) {
            System.out.print(arrayNode2.get(i).asText() + " ");
        }
        System.out.println();

        //path和get方法看起来很相似，其实他们的细节不同，get方法取不存在的值的时候，会返回null。而path方法会
        //返回一个"missing node"，该"missing node"的isMissingNode方法返回值为true，如果调用该node的asText方法的话，
        // 结果是一个空字符串。
        System.out.println("get方法取不存在的节点，返回null: " + (rootNode.get("notExist") == null));
        JsonNode notExistNode = rootNode.path("notExist");
        System.out.println("notExistNode的value：" + notExistNode.asText());
        System.out.println("isMissingNode方法返回true: " + notExistNode.isMissingNode());

        //当key存在，而value为null的时候，get和path都会返回一个NullNode节点。
        System.out.println(rootNode.get("nullNode") instanceof NullNode);
        System.out.println(rootNode.path("nullNode") instanceof NullNode);
    }

    @Test
    public void test2() throws IOException {
        ObjectMapper mapper = new ObjectMapper();


        String s = "{\"CESHI\":{\"otllevel\":1,\"ALLTYPE\":{\"otllevel\":2,\"ADDRESS\":{\"otllevel\":3,\"std\":\"ADDRESS\",\"otl\":\"OTLCOL_YIITGDD\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":256,\"index\":785,\"customregular\":null,\"regulardetail\":null}}}}";

        JsonNode root = mapper.readTree(s);

        //根据 树路径 找到 元素
        JsonPointer pointer = JsonPointer.valueOf("/CESHI/ALLTYPE/ADDRESS/status");
        JsonNode node = root.at(pointer);
        System.out.println("根据 树路径 找到 元素");
        System.out.println(node.asText());

    }


   /* @Test
    public void test3() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String s = "{\"CESHI\":{\"otllevel\":1,\"ALLTYPE\":{\"otllevel\":2,\"ADDRESS\":{\"otllevel\":3,\"std\":\"ADDRESS\",\"otl\":\"OTLCOL_YIITGDD\",\"datatype\":\"VARCHAR2\",\"note\":null,\"status\":256,\"index\":785,\"customregular\":null,\"regulardetail\":null}}}}";

        JsonNode rootNode = mapper.readTree(s);

        //根据 树路径 找到 元素
        JsonNode node = rootNode.path("CESHI");
    }*/


}

