package com.brady.csvutil.util;

import com.brady.libcsv.csvparser.CsvParser;
import com.brady.libcsv.csvparser.CsvWriter;

import static java.util.Arrays.*;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

public class CsvDemoUtil {


    /**
     *
     * @return
     * @throws Exception
     */
    public static Iterator<List<String>> buildData()  {
        StringWriter out = new StringWriter();
        CsvWriter writer = new CsvWriter(out);

        try {
            writer.write(asList("1", "2\"3", "4,5", "6\r7", "8\n9", "0\r\n1", "2"));
            writer.write(asList("1", "2\"3", "4,5", "6\r7", "8\n9", "0\r\n1", "2"));
            writer.write(asList("1", "2\"3", "4,5", "6\r7", "8\n9", "0\r\n1", "2"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        CsvParser parser = new CsvParser();
        Iterator<List<String>> iter = parser.parseAsLists(new StringReader(out.toString()));
        return iter;
    }
}
