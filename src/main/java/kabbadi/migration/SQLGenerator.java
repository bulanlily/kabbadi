package kabbadi.migration;

import org.apache.commons.lang.StringUtils;

import java.util.*;

public class SQLGenerator {

    private Collection<Map<String,String>> entries;

    public SQLGenerator(Collection<Map<String, String>> entries) {
        this.entries = entries;
    }


    public List<String> createInsertStatements(){
        List<String> insertQueries = new ArrayList<String>();
        for(Map<String, String>entry: entries){
            String[] keys = new String[entry.size()];
            entry.keySet().toArray(keys);
            String[] values = new String[keys.length];
            for(int index = 0; index < keys.length; index++)
                values[index] = entry.get(keys[index]);
           
        insertQueries.add(createSingleInsertStatement(keys, values));    
        }
        return insertQueries;
    }

    private String createSingleInsertStatement(String[] columns, String[] values) {
        for (int i=0; i<values.length;i++) 
            if (!values[i].matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))
                values[i] = "'"+values[i]+"'";
        return String.format("INSERT INTO invoice (%s) VALUES (%s);",
                StringUtils.join(columns, ", "),
                StringUtils.join(values, ", "));
    }
}
