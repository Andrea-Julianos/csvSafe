package com.zhibei.csvSafe.test;

import com.common.ajax.EncodingDetect;

import com.zhibei.csvSafe.utils.CharacterCodingUtil;
import com.zhibei.otldb.api.EncryptApi;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class FileTest {

    /**
     *
     *  判断文件编码格式
     */
    @Test
    public void test5() {
        String javaEncode = EncodingDetect.getJavaEncode("G:/CSV/CESHI.csv");
        System.out.println(javaEncode);

    }

    @Test
    public void test6() throws UnsupportedEncodingException {
    }

}
