package kabbadi.migration;

import java.util.*;

public class CSVParser {
    final private List<String[]> entries;
    final private String[] headers;
    
    


    public CSVParser(String[] headers, List<String[]> entries) {
        this.headers = headers;
        this.entries = entries;
    }


    public List<Map<String, String>> mapedList() {
        for(String[]entrie:entries){
            
        }
        return null;
    }
}
