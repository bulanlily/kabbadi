package kabbadi.migration;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class ColumnMapper {
    final private String[] headers;
    final private Collection<String[]> entries;

    public ColumnMapper(String[] headers, Collection<String[]> entries) {
        this.headers = headers;
        this.entries = entries;
    }


    public List<Map<String, String>> mapedList() throws Exception {
        ArrayList<Map<String, String >> mappedList = new ArrayList<Map<String, String>>();
        for(String[] entry :entries){
            if (headers.length != entry.length)
                throw new Exception("");
            HashMap<String, String> mappedEntry = new HashMap<String, String>();
            for(int index = 0; index < entry.length; index++){
                mappedEntry.put(headers[index], entry[index]);
            }
            mappedList.add(mappedEntry);
        }
        return mappedList;
    }
}
