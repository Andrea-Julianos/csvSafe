package com.zhibei.csvSafe.function;

import com.common.ajax.EncodingDetect;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by rajeevkumarsingh on 25/09/17.
 */
public class OpenCSVWriter {


    private static Writer writer;

    private static CSVWriter csvWriter;


    public OpenCSVWriter(String fileEncode, String writePath) {
        try {

            //判断编码类型, 是GB2312 转为 GBK
            final String  gB = "GB2312";
            if (gB.equals(fileEncode)) {
                fileEncode = "GBK";
            }

            writer = new OutputStreamWriter(new FileOutputStream(writePath), fileEncode);
            csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHeader(String[] header) {

            csvWriter.writeNext(header);
    }

    public void writeLine(String[] encryptLine) {


//            String[] headerRecord = OpenCSVReader.getHeader();
//            csvWriter.writeNext(headerRecord);

        csvWriter.writeNext(encryptLine);
        try {
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }






















/*    private static void writeFromListOfObjects() throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {

        try (
            Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));
        ) {
            StatefulBeanToCsv<MyUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<MyUser> myUsers = new ArrayList<>();
            myUsers.add(new MyUser("Sundar Pichai ♥", "sundar.pichai@gmail.com", "+1-1111111111", "India"));
            myUsers.add(new MyUser("Satya Nadella", "satya.nadella@outlook.com", "+1-1111111112", "India"));

            beanToCsv.write(myUsers);
        }
    }*/
}
