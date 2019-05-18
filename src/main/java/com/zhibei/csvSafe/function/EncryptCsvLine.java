package com.zhibei.csvSafe.function;

import com.zhibei.otldb.api.EncryptApi;
import org.apache.commons.lang3.ArrayUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EncryptCsvLine {

    private static int[] safeNum;

    /**
     * 要加密的列的 序号
     *
     * @param header      表头
     * @param columnNames 加密的列名
     */
    public static void safeColumn(String[] header, List<String> columnNames) {
        //加密的列的序号数组
        safeNum = new int[columnNames.size()];

        System.out.println(safeNum.length);


        System.out.println(Arrays.toString(header));

        System.out.println(columnNames.size());


        int i = 0;
        for (String columnName : columnNames) {

            System.out.println(columnName);
            int safeIdx = ArrayUtils.indexOf(header, columnName);
            System.out.println(safeIdx);
            //为序号数组赋值
            //这里的数量 一直是相同的
            safeNum[i++] = safeIdx;
        }
        System.out.println("加密的列名为" + Arrays.toString(safeNum));


    }

    public static String[] encryptCsvreadLine(String[] csvReadLine) throws UnsupportedEncodingException {

        String[] encryptCsvLine = csvReadLine;

            for (int encryIdx : safeNum) {
                String[] removeLine = ArrayUtils.remove(encryptCsvLine, encryIdx);

/*                byte[] gb2312s = csvReadLine[encryIdx].getBytes("GB2312");
                String test = new String(gb2312s, "GB2312");*/

                encryptCsvLine = ArrayUtils.insert(encryIdx, removeLine, EncryptApi.encrypt2(csvReadLine[encryIdx]));

                System.out.println(Arrays.toString(encryptCsvLine));
            }

        return encryptCsvLine;

    }


}
