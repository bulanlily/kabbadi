package kabbadi.domain;

import org.joda.time.DateTimeComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortableInvoiceList {
    private List<Invoice> invoices;

    public SortableInvoiceList(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Invoice> sortByInvoiceDate() {
        Collections.sort(invoices, new Comparator<Invoice>() {
            @Override
            public int compare(Invoice invoice, Invoice invoice1) {
                return DateTimeComparator.getInstance().compare(invoice.getDateOfInvoice(), invoice1.getDateOfInvoice());
            }
        });
        return invoices;
    }

    public List<Invoice> sortByBondNumber() {
        return invoices;
    }
}
