package kabbadi.domain;

import kabbadi.domain.builder.InvoiceTestBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class InvoiceTest {

    @Test
    public void is_not_valid_if_the_purchase_order_number_is_not_a_valid_string() {
        assertThat(invoiceWithPONumber("").valid(), equalTo(false));
        assertThat(invoiceWithPONumber(null).valid(), equalTo(false));
        assertThat(invoiceWithPONumber("PO-1234").valid(), equalTo(true));
    }

    private Invoice invoiceWithPONumber(String purchaseOrderNumber) {
        return new InvoiceTestBuilder().withPurchaseOrderNumber(purchaseOrderNumber).build();
    }

}
