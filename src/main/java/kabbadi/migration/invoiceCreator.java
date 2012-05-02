package kabbadi.migration;

import java.util.*;

public class InvoiceCreator {
    final static private String[] combinedHeaders = new String[] {
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
    private Collection<Map<String,String>> adminEntries;
    private Collection<Map<String, String>> financeEntries;

    public InvoiceCreator(Collection<Map<String, String>> adminEntries, Collection<Map<String, String>> financeEntries) {
        this.adminEntries = adminEntries;
        this.financeEntries = financeEntries;
    }

    public List<Map<String, String>> createJoinEntry(){
        Map<String, Map<String,String>> combinedEntries = new HashMap<String, Map<String, String>>();
        for (Map<String, String> entry : adminEntries)
            combinedEntries.put(entry.get("invoiceNumber"), entry);
        for (Map<String,String> entry : financeEntries)
            if (combinedEntries.containsKey(entry.get("invoiceNumber")))
                combinedEntries.get(entry.get("invoiceNumber")).putAll(entry);
            else
                combinedEntries.put(entry.get("invoiceNumber"), entry);
        return new ArrayList<Map<String, String>>(combinedEntries.values());
    }
}
