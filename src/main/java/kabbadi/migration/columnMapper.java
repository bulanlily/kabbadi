package kabbadi.migration;

import java.util.*;

public class ColumnMapper {
    final static private String[] validInvoiceHeaders = new String[] {
            "invoiceNumber",
            "dateOfInvoice",
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
    final private String[] headers;
    final private Collection<String[]> entries;

    public ColumnMapper(String[] headers, Collection<String[]> entries) {
        this.headers = headers;
        this.entries = entries;
    }


    public List<Map<String, String>> mapedList(){
        ArrayList<Map<String, String >> mappedList = new ArrayList<Map<String, String>>();
        for(String[] entry :entries){
            HashMap<String, String> mappedEntry = new HashMap<String, String>();
            for(int index = 0; index < entry.length; index++){
                if(Arrays.asList(validInvoiceHeaders).contains(headers[index]))
                mappedEntry.put(headers[index], entry[index]);
            }
            mappedList.add(mappedEntry);
        }
        return mappedList;
    }
}
