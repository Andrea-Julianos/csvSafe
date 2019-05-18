package com.zhibei.csvSafe;

import com.common.ajax.EncodingDetect;
import com.zhibei.csvSafe.function.EncryptCsvLine;
import com.zhibei.csvSafe.function.OpenCSVReader;
import com.zhibei.csvSafe.function.OpenCSVWriter;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class OpenCsvSmall {


    public static void main(String[] args) throws UnsupportedEncodingException {

        long startTime = System.currentTimeMillis();

        //获取文件路径
        String readPath = "G:/CSV/read/traffic.csv";
        String writePath = "G:/CSV/write/traffic.csv";

        //判断文件的类型
        String fileEncode = EncodingDetect.getJavaEncode(readPath);

        System.out.println("文件类型" + fileEncode);

        OpenCSVReader openCSVReader = new OpenCSVReader(fileEncode, readPath);
        OpenCSVWriter openCSVWriter = new OpenCSVWriter(fileEncode, writePath);

        //读取表头
        String[] header = openCSVReader.getHeader();
        //写入表头
        openCSVWriter.writeHeader(header);



        //---------------------------------------
        ArrayList<String> file = new ArrayList<>();
        file.add("国家");
//        file.add("日期");
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



}
