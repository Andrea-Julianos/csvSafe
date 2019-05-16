package com.zhibei.csvSafe.function;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by rajeevkumarsingh on 25/09/17.
 */
public class OpenCSVWriter {
    private static final String STRING_ARRAY_SAMPLE = "G:/CSV/encryptTest.csv";
//    private static final String OBJECT_LIST_SAMPLE = "./object-list-sample.csv";




    private static Writer writer;

    private static CSVWriter csvWriter;


    public OpenCSVWriter() {
        try {

            writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));
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
