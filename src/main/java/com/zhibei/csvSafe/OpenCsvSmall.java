package com.zhibei.csvSafe;

import com.common.ajax.EncodingDetect;
import com.zhibei.csvSafe.function.EncryptCsvLine;
import com.zhibei.csvSafe.function.OpenCSVReader;
import com.zhibei.csvSafe.function.OpenCSVWriter;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;

public class OpenCsvSmall {


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();


        //判断文件的类型
        String fileEncode = EncodingDetect.getJavaEncode("G:/CSV/traffic.csv");

        OpenCSVWriter openCSVWriter = new OpenCSVWriter(fileEncode);
        OpenCSVReader openCSVReader = new OpenCSVReader(fileEncode);

        //读取表头
        String[] header = openCSVReader.getHeader();
        //写入表头
        openCSVWriter.writeHeader(header);



        //---------------------------------------
        ArrayList<String> file = new ArrayList<>();
        file.add("国家");
        file.add("日期");
        //---------------------------------------

        /*可接接口*/
        //计入要加密的列
        EncryptCsvLine.safeColumn(header, file);

        /*测试用, 记录数*/
        int count = 0;

        //读取, 加密, 并写入
        String[] csvLine;
        while ((csvLine = openCSVReader.readRecordsOneByOne()) != null) {
            //加密
            String[] encryptLine = EncryptCsvLine.encryptCsvreadLine(csvLine);

            //逐行写入新的csv文件
            openCSVWriter.writeLine(encryptLine);
            count++;
        }
        System.out.println("finish....");

        long endTime = System.currentTimeMillis();

        System.out.println("总时间: " + (endTime - startTime) + "    条数: " + count);



    }


    @Test
    public void test5() {
        String javaEncode = EncodingDetect.getJavaEncode("G:/CSV/testtraffic.csv");
        System.out.println(javaEncode);

    }

}
