package com.fifthgen.prahranvet.vetwarebridge.utility;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVUtils {


    public static void readCSVFile(String fileName) {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(fileName));
                CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT)
        ) {
            for (CSVRecord record : parser) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
