package kabbadi.domain;

import org.joda.time.DateTimeComparator;
import org.springframework.util.ObjectUtils;
import org.springframework.util.comparator.NullSafeComparator;

import java.util.Collections;
import java.util.Comparator;

public enum InvoiceComparator implements Comparator<Invoice> {
    ByInvoiceDate {
        @Override
        public int compare(Invoice invoice, Invoice invoice1) {
            return DateTimeComparator.getInstance().compare(invoice.getDateOfInvoice(), invoice1.getDateOfInvoice());
        }
    },
    ByBondNumber {
        @Override
        public int compare(Invoice invoice, Invoice invoice1) {
               return invoice.getBondNumber().compareTo(invoice1.getBondNumber());
        }
    };

    @Override
    public abstract int compare(Invoice invoice, Invoice invoice1);

    public Comparator<Invoice> ascending() {
        return this;
    }

    public Comparator<Invoice> descending() {
        return Collections.reverseOrder(this);
    }
}
