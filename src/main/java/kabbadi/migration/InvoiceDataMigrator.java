package kabbadi.migration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceDataMigrator {

    static private final int ID_OFFSET = 100;
    public static final boolean QUOTES_NEEDED = true;
    public static final boolean QUOTES_NOT_NEEDED = false;


    final private String[] adminHeaders = new String[] {
            "invoiceNumber",
            "STPIApprovalNumberAndDate",
            "descriptionOfGoods",
            "currency",
            "foreignCurrency",
            "amountSTPIApproval",
            "CIFValueInINR",
            "bondNumber",
            "bondDate",
            "billOfEntryNumber",
            "billOfEntryDate",
            "assessableValueInINR",
            "dutyExempt",
            "twentyFivePercentDF",
            "outrightPurchase",
            "loanBasis",
            "freeOfCharge",
            "cgApprovedInINR",
            "dutyForgone",
            "runningBalance"
    };

    final private String[] financeHeaders = new String[] {
            "",
            "dateOfInvoice",
            "invoiceNo.",
            "dateOfCommissioning",
            "supplierNameAndAddress",
            "groupOfAssets",
            "assetWiseBreakup",
            "quantity",
            "location",
            "identificationNumber",
            "type",
            "grossBlock",
            "deletion(2001-12)",
            "totalPurchaseValueOn31-Mar-11",
            "rateOfDepreciation",
            "april-11",
            "may-11",
            "june-11",
            "july-11",
            "august-11",
            "september-11",
            "october-11",
            "november-11",
            "december-11",
            "january-12",
            "february-12",
            "march-12",
            "deletionsDuringTheYear",
            "totalDepreciation31-Mar-2012",
            "netBlock",
            "costCentre"
    };

    final private String[] combinedHeaders = new String[] {
            "invoiceNumber",
            "STPIApprovalNumberAndDate",
            "descriptionOfGoods",
            "currency",
            "foreignCurrency",
            "amountSTPIApproval",
            "CIFValueInINR",
            "bondNumber",
            "bondDate",
            "billOfEntryNumber",
            "billOfEntryDate",
            "assessableValueInINR",
            "dutyExempt",
            "twentyFivePercentDF",
            "outrightPurchase",
            "loanBasis",
            "freeOfCharge",
            "cgApprovedInINR",
            "dutyForgone",
            "runningBalance",
            "dateOfInvoice",
            "dateOfCommissioning",
            "supplierNameAndAddress",
            "groupOfAssets",
            "quantity",
            "location",
            "identificationNumber",
            "type",
            "deletionsDuringTheYear",
            "costCentre"
    };
    
    final private Attribute[] attributes = new Attribute[] {
        new Attribute(0, "invoiceNumber", QUOTES_NEEDED),
        new Attribute(1, "STPIApprovalNumberAndDate", QUOTES_NEEDED),
        new Attribute(2, "descriptionOfGoods", QUOTES_NEEDED),
        new Attribute(3, "currency", QUOTES_NEEDED),
        new Attribute(4, "foreignCurrency", QUOTES_NOT_NEEDED),
        new Attribute(5, "amountSTPIApproval", QUOTES_NOT_NEEDED),
        new Attribute(6, "CIFValueInINR", QUOTES_NOT_NEEDED),
        new Attribute(7, "bondNumber", QUOTES_NEEDED),
        new Attribute(8, "bondDate", QUOTES_NEEDED),
        new Attribute(9, "billOfEntryNumber", QUOTES_NOT_NEEDED),
        new Attribute(10, "billOfEntryDate", QUOTES_NEEDED),
        new Attribute(11, "assessableValueInINR",QUOTES_NOT_NEEDED),
        new Attribute(12, "dutyExempt",QUOTES_NOT_NEEDED),
        new Attribute(13, "twentyFivePercentDF",QUOTES_NOT_NEEDED),
        new Attribute(14,"outrightPurchase", QUOTES_NOT_NEEDED),
        new Attribute(15,"loanBasis", QUOTES_NEEDED),
        new Attribute(16,"freeOfCharge", QUOTES_NOT_NEEDED),
        new Attribute(17,"cgApprovedInINR", QUOTES_NOT_NEEDED),
        new Attribute(18,"dutyForgone", QUOTES_NOT_NEEDED),
        new Attribute(19,"runningBalance", QUOTES_NOT_NEEDED),

        new Attribute(20,"dateOfInvoice", QUOTES_NEEDED),
        new Attribute(21,"dateOfCommissioning", QUOTES_NEEDED),
        new Attribute(22,"supplierNameAndAddress", QUOTES_NEEDED),
        new Attribute(23,"groupOfAssets", QUOTES_NEEDED),
        new Attribute(24,"quantity", QUOTES_NOT_NEEDED),
        new Attribute(25,"location", QUOTES_NEEDED),
        new Attribute(26,"identificationNumber", QUOTES_NEEDED),
        new Attribute(27,"type", QUOTES_NEEDED),
        new Attribute(28,"deletionsDuringTheYear", QUOTES_NOT_NEEDED),
        new Attribute(29,"costCentre", QUOTES_NEEDED)
    };

   

    public List<String> createInserts(List<String[]> lines) {
        List<String> inserts = new ArrayList<String>();
        for (int id = 0; id < lines.size(); id++) {
            inserts.add(constructColumnsFragment(lines.get(id))+" "+constructValuesFragment( id + ID_OFFSET,lines.get(id)));
        }
        return inserts;
    }


    private String constructColumnsFragment(String[] tokens) {
        StringBuilder insertFragment = new StringBuilder("INSERT INTO invoice (id");
        for(int i=0; i<tokens.length; i++){
            insertFragment.append(", ").append(attributes[i].fieldName);
        }
        insertFragment.append(")");
        return insertFragment.toString();
    }

    private String constructValuesFragment(int id, String[] tokens) {
        StringBuilder valuesFragment = new StringBuilder("VALUES (").append(id);
        for(int i=0; i<tokens.length; i++){
            valuesFragment.append(", ").append(attributes[i].extractField(tokens));
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
            if(value == null ||value.equals("")) return null;
            return needsQuotes ? "'" + value + "'" : value;
        }
    }

}
