package kabbadi.domain.json;

import kabbadi.domain.Invoice;
import kabbadi.domain.builder.InvoiceTestBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class InvoiceNumberExistentTest {

    @Test
    public void should_alert_existence() {
        Invoice invoiceWithNumber = new InvoiceTestBuilder()
                .withInvoiceNumber("invoice!23")
                .build();
        assertThat(new InvoiceNumberExistent(invoiceWithNumber).getExists(), equalTo(true));

        assertThat(new InvoiceNumberExistent(new Invoice()).getExists(), equalTo(false));
        assertThat(new InvoiceNumberExistent(null).getExists(), equalTo(false));
    }


}
