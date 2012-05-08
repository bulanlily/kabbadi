package kabbadi.migration;

import java.util.*;
import java.util.zip.DataFormatException;

public class ColumnMapper {
    final static private String[] validInvoiceHeaders = new String[]{
            "invoice_id",
            "invoiceNumber",
            "dateOfInvoice",
            "STPIApprovalNumberAndDate",
            "descriptionOfGoods",
            "currency",
            "foreignValue",
            "amountSTPIApproval",
            "CIFValueInINR",
            "bondNumber",
            "bondDate",
            "billOfEntryNumber",
            "billOfEntryDate",
            "assessableValueInINR",
            "dutyExempt",
            "twentyFivePercentDF",
            "importType",
            "cgApprovedInINR",
            "dutyForgone",
            "dateOfInvoice",
            "dateOfCommissioning",
            "supplierNameAndAddress",
            "groupOfAssets",
            "quantity",
            "location",
            "identificationNumber",
            "deletionsDuringTheYear",
            "costCentre",
            "runningBalance",
            "additionsDuringTheYear"
    };

    final private String[] headers;
    final private Collection<String[]> entries;

    public ColumnMapper(String[] headers, Collection<String[]> entries) {
        this.headers = headers;
        this.entries = entries;
    }


    public List<Map<String, String>> mappedList() throws Exception {
        ArrayList<Map<String, String>> mappedList = new ArrayList<Map<String, String>>();
        for (String[] entry : entries) {
            if (headers.length != entry.length)
                throw new DataFormatException("Headers and entries are of different length");
            HashMap<String, String> mappedEntry = new HashMap<String, String>();
            for (int index = 0; index < entry.length; index++)
                if (Arrays.asList(validInvoiceHeaders).contains(headers[index]))
                    mappedEntry.put(headers[index], entry[index]);
            mappedList.add(mappedEntry);
        }
        return mappedList;
    }
}
