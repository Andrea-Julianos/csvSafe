package com.zhibei.csvSafe;

import com.zhibei.csvSafe.function.EncryptCsvLine;
import com.zhibei.csvSafe.function.OpenCSVReader;
import com.zhibei.csvSafe.function.OpenCSVWriter;

public class OpenCsvSmall {


    public static void main(String[] args) {





        long startTime = System.currentTimeMillis();

        OpenCSVWriter openCSVWriter = new OpenCSVWriter();
        OpenCSVReader openCSVReader = new OpenCSVReader();

        //读取表头
        String[] header = openCSVReader.getHeader();
        //写入表头
        openCSVWriter.writeHeader(header);

        /*可接接口*/
        //计入要加密的列
        EncryptCsvLine.safeColumn(header, new String[]{"name1"});

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
