package kabbadi.domain.json;

import com.mysql.jdbc.StringUtils;
import kabbadi.domain.Invoice;

public class InvoiceNumberExistent {

    private final boolean exists;

    public InvoiceNumberExistent(Invoice invoice) {
        exists = invoice != null && !StringUtils.isEmptyOrWhitespaceOnly(invoice.getInvoiceNumber());
    }

    public boolean getExists() {
        return exists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceNumberExistent)) return false;

        InvoiceNumberExistent that = (InvoiceNumberExistent) o;

        return exists == that.exists;
    }

    @Override
    public int hashCode() {
        return (exists ? 1 : 0);
    }
}
