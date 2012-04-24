package kabbadi.migration;

import java.util.ArrayList;
import java.util.List;

public class AdminMigrator {

    static private final int ID_OFFSET = 100;
    public static final boolean NEEDS_QUOTES = true;
    public static final boolean QUOTES_NOT_NEEDED = false;

    final private Attribute[] attributes = new Attribute[] {
            new Attribute(0, "invoiceNumber", NEEDS_QUOTES),
            new Attribute(1, "STPIApprovalNumberAndDate", NEEDS_QUOTES),
            new Attribute(2, "descriptionOfGoods", NEEDS_QUOTES),
            new Attribute(3, "currency", NEEDS_QUOTES),
            new Attribute(4, "foreignCurrency", QUOTES_NOT_NEEDED),
            new Attribute(5, "amountSTPIApproval", QUOTES_NOT_NEEDED),
            new Attribute(6, "CIFValueInINR", QUOTES_NOT_NEEDED),
            new Attribute(7, "bondNumber", NEEDS_QUOTES),
            new Attribute(8, "bondDate", NEEDS_QUOTES),
            new Attribute(9, "billOfEntryNumber", QUOTES_NOT_NEEDED),
            new Attribute(10, "billOfEntryDate", NEEDS_QUOTES),
            new Attribute(11, "assessableValueInINR",QUOTES_NOT_NEEDED),
            new Attribute(12, "dutyExempt",QUOTES_NOT_NEEDED),
            new Attribute(13, "twentyFivePercentDF",QUOTES_NOT_NEEDED),
            new Attribute(14,"outrightPurchase", QUOTES_NOT_NEEDED),
            new Attribute(15,"loanBasis", NEEDS_QUOTES),
            new Attribute(16,"freeOfCharge", QUOTES_NOT_NEEDED),
            new Attribute(17,"CGApprovedInINR", QUOTES_NOT_NEEDED),
            new Attribute(18,"dutyForgone", QUOTES_NOT_NEEDED),
            new Attribute(19,"runningBalance", QUOTES_NOT_NEEDED)


    };


    public List<String> createInserts(List<String> lines) {
        List<String> inserts = new ArrayList<String>();
        for (int id = 0; id < lines.size(); id++) {
            inserts.add(constructInsertStatement(lines.get(id), id + ID_OFFSET));
        }
        return inserts;
    }

    private String constructInsertStatement(String line, int id) {
        String[] tokens = line.split(",", -1);
        return constructColumnsFragment() + " " + constructValuesFragment(id, tokens);
    }

    private String constructColumnsFragment() {
        StringBuilder insertFragment = new StringBuilder("INSERT INTO invoice (id");
        for (Attribute attribute : attributes) {
            insertFragment.append(", ").append(attribute.fieldName);
        }
        insertFragment.append(")");
        return insertFragment.toString();
    }

    private String constructValuesFragment(int id, String[] tokens) {
        StringBuilder valuesFragment = new StringBuilder("VALUES (").append(id);
        for (Attribute attribute : attributes) {
            valuesFragment.append(", ").append(attribute.extractField(tokens));
        }
        valuesFragment.append(");");
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
            if(value.equals("")) return null;
            return needsQuotes ? "'" + value + "'" : value;
        }
    }

}
