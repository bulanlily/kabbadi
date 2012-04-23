package kabbadi.migration;

import java.util.ArrayList;
import java.util.List;

public class AdminMigrator {

    static private final int ID_OFFSET = 100;

    final private Attribute[] attributes = new Attribute[] {
            new Attribute("STPIApprovalNumberAndDate", true),
            new Attribute("descriptionOfGoods", true),
            new Attribute("currency", true),
            new Attribute("foreignCurrency", false),
            new Attribute("amountSTPIApproval", false),
            new Attribute("CIFValueInINR", false),
            new Attribute("bondNumber", true),
            new Attribute("bondDate", true),

    };

    public List<String> createInserts(List<String> lines) {
        List<String> inserts = new ArrayList<String>();
        for (int id=0; id<lines.size(); id++) {
            inserts.add (constructInsertStatement(lines.get(id), id + ID_OFFSET));
        }
        return inserts;
    }

    private String constructInsertStatement(String line, int id) {
        String[] tokens = line.split(",");
        return constructInsertFragment() + " " + valueFragment(id, tokens);

    }

    private String constructInsertFragment() {
        StringBuilder insertFragment = new StringBuilder("INSERT INTO invoice (id, invoiceNumber");
        for (Attribute attribute : attributes) {
            insertFragment.append(", ") .append(attribute.fieldName);
        }
        insertFragment.append(")");
        return insertFragment.toString();
    }

    private String valueFragment(int id, String[] tokens) {
        StringBuilder valuesFragment = new StringBuilder("VALUES (").append(id).append(", 'unknown'");
        for (int i = 0; i<attributes.length; i++){
            valuesFragment.append(", ").append(attributes[i].extractField(tokens, i));
        }
        valuesFragment.append(")");
        return valuesFragment.toString();
    }

    private class Attribute {
        
        final String fieldName;
        final boolean needsQuotes;

        private Attribute(String fieldName, boolean needsQuotes) {
            this.fieldName = fieldName;
            this.needsQuotes = needsQuotes;
        }
        
        String extractField(String[] tokens, int index) {
            String value = tokens[index+1];
            return needsQuotes ? "'" + value + "'" : value; 
        }
    }

}
