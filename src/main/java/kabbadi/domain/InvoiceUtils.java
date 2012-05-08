package kabbadi.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InvoiceUtils {

    public static HashMap<String, List<Invoice>> separateOldAndNewData(List<Invoice> invoices) {
        HashMap<String, List<Invoice>> oldAndNewInvoices = new HashMap<String, List<Invoice>>();
        List<Invoice> oldInvoices = new ArrayList<Invoice>();
        List<Invoice> newInvoices = new ArrayList<Invoice>();
        String oldData = "old data";

        for(Invoice invoice: invoices){
            if(invoice.getInvoiceNumber().equals(oldData)) {
                oldInvoices.add(invoice);
            } else {
                newInvoices.add(invoice);
            }
        }

        oldAndNewInvoices.put("oldInvoices" , oldInvoices);
        oldAndNewInvoices.put("newInvoices", newInvoices);
        return  oldAndNewInvoices;
    }
}
