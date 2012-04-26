package kabbadi.domain;

import kabbadi.domain.builder.InvoiceTestBuilder;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class InvoiceTest {

    @Test
    public void is_not_valid_if_the_invoice_number_is_not_a_valid_string() {
        assertThat(invoiceWithNumber("").valid(), equalTo(false));
        assertThat(invoiceWithNumber(null).valid(), equalTo(false));
        assertThat(invoiceWithNumber("PO-1234").valid(), equalTo(true));
    }

    private Invoice invoiceWithNumber(String invoiceNumber) {
        return new InvoiceTestBuilder().withInvoiceNumber(invoiceNumber).build();
    }

    @Test
    public void should_calculate_the_total_purchase_value() {
        assertThat(invoiceWithFinanceValues(1d, 1d, 1d).gbOnDecember31(), equalTo(new BigDecimal(1)));
        assertThat(invoiceWithFinanceValues(2d, 3d, 1d).gbOnDecember31(), equalTo(new BigDecimal(4)));
        assertThat(invoiceWithFinanceValues(2d, 2d, 5d).gbOnDecember31(), equalTo(new BigDecimal(-1)));
    }

    @Test
    public void should_not_calculate_the_total_purchase_when_the_required_fields_are_empty() {
        assertThat(new Invoice().gbOnDecember31(), is(nullValue()));
        assertThat(invalidInvoiceWithFinanceValues().gbOnDecember31(), is(nullValue()));
    }

    private Invoice invalidInvoiceWithFinanceValues() {
        Invoice invoice = new Invoice();
        invoice.setAdditionsDuringTheYear(new BigDecimal(1));
        return invoice;
    }

    private Invoice invoiceWithFinanceValues(Double openingValue, Double additions, Double deletions) {
        Invoice invoice = new Invoice();
        invoice.setOpeningPurchaseValueAsOnApril01(new BigDecimal(openingValue));
        invoice.setAdditionsDuringTheYear(new BigDecimal(additions));
        invoice.setDeletionsDuringTheYear(new BigDecimal(deletions));

        return invoice;
    }

}
