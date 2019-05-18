package com.zhibei.csvSafe.function;

import com.opencsv.CSVReader;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

/**
 * Created by Andrea on 2019/5/17.
 */


public class OpenCSVReader {

    private static final String SAMPLE_CSV_FILE_PATH = "G:/CSV/traffic.csv";


    /**
     * header 可以 给予getter和setter方法
     */
    private  String[] header;

    private static Reader reader;

    private static CSVReader csvReader;





    public OpenCSVReader(String fileEncode) {
        try {
            // 使用BOMInputStream自动去除UTF-8中的BOM
           /* reader = new InputStreamReader(new BOMInputStream(new FileInputStream(SAMPLE_CSV_FILE_PATH)), "utf-8");*/

            reader = new InputStreamReader(new FileInputStream(SAMPLE_CSV_FILE_PATH), fileEncode);
            csvReader = new CSVReader(reader);

            //设置表头
            setHeader(csvReader.readNext());
            System.out.println("表头" + Arrays.toString(header));



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] readRecordsOneByOne() {

        String[] next = null;

        //设置表头
        try {

            next = csvReader.readNext();

        } catch (IOException e) {
            e.printStackTrace();
        }
            return next;

    }

    /**
     *
     * 表头的设置 是private的, 只能在类内设置
     * @param header
     */
    private  void setHeader(String[] header) {
        this.header = header;
    }


    public  String[] getHeader() {
        return header;
    }


    /*  /**
     * 读取所有的行
     *
     * @return

    private static void readAllRecordsAtOnce() throws IOException {
        try (
                // 使用BOMInputStream自动去除UTF-8中的BOM
                Reader reader = new InputStreamReader(new BOMInputStream(
                        new FileInputStream(SAMPLE_CSV_FILE_PATH)), "utf-8");
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading All Records at once into a List<String[]>
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                System.out.println("Name : " + record[0]);
                System.out.println("Email : " + record[1]);
                System.out.println("Phone : " + record[2]);
                System.out.println("Country : " + record[3]);
                System.out.println("---------------------------");
            }
        }
    }*/
}
