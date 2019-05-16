package com.zhibei.csvSafe.function;

import com.opencsv.CSVReader;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by rajeevkumarsingh on 25/09/17.
 */


public class OpenCSVReader {

    private static final String SAMPLE_CSV_FILE_PATH = "G:/CSV/test.csv";


    /**
     * header 可以 给予getter和setter方法
     */
    private  String[] header;

    private static Reader reader;

    private static CSVReader csvReader;





    public OpenCSVReader() {
        try {
            // 使用BOMInputStream自动去除UTF-8中的BOM
           /* reader = new InputStreamReader(new BOMInputStream(new FileInputStream(SAMPLE_CSV_FILE_PATH)), "utf-8");*/

            //不用也行
            reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            csvReader = new CSVReader(reader);

            //设置表头
            setHeader(csvReader.readNext());



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

  /*          String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("==========================加密后的========================");
                System.out.println(EncryptApi.encrypt2(nextRecord[i]));
                System.out.println();
            }*/

    }

    /**
     * 读取所有的行
     *
     * @return
     */
 /*   private static void readAllRecordsAtOnce() throws IOException {
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
    public  String[] getHeader() {
        return header;
    }

    private  void setHeader(String[] header) {
        this.header = header;
    }
}
