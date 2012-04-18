package kabbadi.domain;

import kabbadi.domain.builder.InvoiceTestBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
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

}
