package com.zhibei.csvSafe.function;

import com.zhibei.otldb.api.EncryptApi;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class EncryptCsvLine {

    private static int[] safeNum;

    /**
     * 要加密的列的 序号
     *
     * @param header      表头
     * @param columnNames 加密的列名
     */
    public static void safeColumn(String[] header, String[] columnNames) {
        //加密的列的序号数组
        int[] num = new int[columnNames.length];


        for (int i = 0; i < columnNames.length; i++) {
            //要加密的列名在表头的位置
            int safeIdx = ArrayUtils.indexOf(header, columnNames[i]);
            //为序号数组赋值
                //这里的数量 一直是相同的
            num[i] = safeIdx;
        }


        System.out.println("加密的列名为" + Arrays.toString(num));
        safeNum = num;
    }

    public static String[] encryptCsvreadLine(String[] csvReadLine) {

        String[] encryptCsvLine = csvReadLine;
        for (int encryIdx : safeNum) {
            String[] removeLine = ArrayUtils.remove(csvReadLine, encryIdx);
            encryptCsvLine = ArrayUtils.insert(encryIdx, removeLine, EncryptApi.encrypt2(encryptCsvLine[encryIdx]));
            System.out.println(Arrays.toString(encryptCsvLine));
        }
        return encryptCsvLine;

    }
}
