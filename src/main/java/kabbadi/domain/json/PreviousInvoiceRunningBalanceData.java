package kabbadi.domain.json;

import kabbadi.domain.Invoice;

import java.math.BigDecimal;

public class PreviousInvoiceRunningBalanceData {

    private final Invoice invoice;

    public PreviousInvoiceRunningBalanceData(Invoice invoice) {
        this.invoice = invoice == null ? new Invoice() : invoice;
    }

    public BigDecimal getRunningBalance() {
        return invoice.getRunningBalance();
    }

    public String getBondNumber() {
        return invoice.getBondNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreviousInvoiceRunningBalanceData that = (PreviousInvoiceRunningBalanceData) o;

        if (invoice != null ? !invoice.equals(that.invoice) : that.invoice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return invoice != null ? invoice.hashCode() : 0;
    }
}
