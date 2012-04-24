package kabbadi.migration;

import java.util.ArrayList;
import java.util.List;

public class AdminMigrator {

    static private final int ID_OFFSET = 100;

    final private Attribute[] attributes = new Attribute[]{
            new Attribute(1, "STPIApprovalNumberAndDate", true),
            new Attribute(2, "descriptionOfGoods", true),
            new Attribute(3, "currency", true),
            new Attribute(4, "foreignCurrency", false),
            new Attribute(5, "amountSTPIApproval", false),
            new Attribute(6, "CIFValueInINR", false),
            new Attribute(7, "bondNumber", true),
            new Attribute(8, "bondDate", true),
    };

    public List<String> createInserts(List<String> lines) {
        List<String> inserts = new ArrayList<String>();
        for (int id = 0; id < lines.size(); id++) {
            inserts.add(constructInsertStatement(lines.get(id), id + ID_OFFSET));
        }
        return inserts;
    }

    private String constructInsertStatement(String line, int id) {
        String[] tokens = line.split(",");
        return constructColumnsFragment() + " " + constructValuesFragment(id, tokens);
    }

    private String constructColumnsFragment() {
        StringBuilder insertFragment = new StringBuilder("INSERT INTO invoice (id, invoiceNumber");
        for (Attribute attribute : attributes) {
            insertFragment.append(", ").append(attribute.fieldName);
        }
        insertFragment.append(")");
        return insertFragment.toString();
    }

    private String constructValuesFragment(int id, String[] tokens) {
        StringBuilder valuesFragment = new StringBuilder("VALUES (").append(id).append(", 'unknown'");
        for (Attribute attribute : attributes) {
            valuesFragment.append(", ").append(attribute.extractField(tokens));
        }
        valuesFragment.append(")");
        return valuesFragment.toString();
    }

    private class Attribute {

        final int columnIndex;
        final String fieldName;
        final boolean needsQuotes;

        private Attribute(int columnIndex, String fieldName, boolean needsQuotes) {
            this.columnIndex = columnIndex;
            this.fieldName = fieldName;
            this.needsQuotes = needsQuotes;
        }

        String extractField(String[] tokens) {
            String value = tokens[columnIndex];
            return needsQuotes ? "'" + value + "'" : value;
        }
    }

}
