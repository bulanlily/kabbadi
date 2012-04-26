package kabbadi.domain.builder;

import kabbadi.domain.Invoice;
import kabbadi.domain.Money;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InvoiceTestBuilder {
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    private Invoice invoice;

    public InvoiceTestBuilder() {
        this.invoice = new Invoice();
    }

    public InvoiceTestBuilder withInvoiceNumber(String invoiceNumber) {
        invoice.setInvoiceNumber(invoiceNumber);
        return this;
    }

    public InvoiceTestBuilder withSTPIApprovalNumberAndDate(String numberAndDate) {
        invoice.setSTPIApprovalNumberAndDate(numberAndDate);
        return this;
    }

    public InvoiceTestBuilder withDescriptionOfGoods(String description) {
        invoice.setDescriptionOfGoods(description);
        return this;
    }

    public InvoiceTestBuilder withForeignCurrency(double amount) {
        invoice.setForeignValue(new Money("USD", new BigDecimal(amount)));
        return this;
    }

    public InvoiceTestBuilder withAmountSTPIApproval(double amount) {
        invoice.setAmountSTPIApproval(new BigDecimal(amount));
        return this;
    }

    public InvoiceTestBuilder withCIFValueInINR(double amount) {
        invoice.setCIFValueInINR(new Money(Money.DEFAULT_CURRENCY, new BigDecimal(amount)));
        return this;
    }

    public InvoiceTestBuilder withBondNumber(String bondNumber) {
        invoice.setBondNumber(bondNumber);
        return this;
    }

    public InvoiceTestBuilder withBondDate(String date) {
        try {
            invoice.setBondDate(new SimpleDateFormat(DATE_FORMAT).parse(date));
        } catch (ParseException ignored) {
        }
        return this;
    }

    public InvoiceTestBuilder withBillOfEntryNumber(String billNumber) {
        invoice.setBillOfEntryNumber(billNumber);
        return this;
    }

    public InvoiceTestBuilder withBillOfEntryDate(String date) {
        try {
            invoice.setBillOfEntryDate(new SimpleDateFormat(DATE_FORMAT).parse(date));
        } catch (ParseException ignored) {
        }
        return this;
    }

    public InvoiceTestBuilder withAssessableValueInINR(double amount) {
        invoice.setAssessableValueInINR(new BigDecimal(amount));
        return this;
    }

    public InvoiceTestBuilder withDutyExempt(double amount) {
        invoice.setDutyExempt(new BigDecimal(amount));
        return this;
    }

    public InvoiceTestBuilder withTwentyFivePercentDF(double value) {
        invoice.setTwentyFivePercentDF(new BigDecimal(value));
        return this;
    }

    public InvoiceTestBuilder withCGApprovedInINR(double amount) {
        invoice.setCgApprovedInINR(new BigDecimal(amount));
        return this;
    }

    public InvoiceTestBuilder withDutyForgone(double amount) {
        invoice.setDutyForgone(new BigDecimal(amount));
        return this;
    }

    public InvoiceTestBuilder withStatus(String status) {
        invoice.setStatus(status);
        return this;
    }

    public InvoiceTestBuilder withRemarks(String remarks) {
        invoice.setRemarks(remarks);
        return this;
    }

    public InvoiceTestBuilder withPurchaseOrderNumber(String orderNumber) {
        invoice.setPurchaseOrderNumber(orderNumber);
        return this;
    }

    public InvoiceTestBuilder withLocation(String location) {
        invoice.setLocation(location);
        return this;
    }

    public Invoice build() {
        return invoice;
    }
}
