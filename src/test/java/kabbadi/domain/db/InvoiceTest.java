package kabbadi.domain.db;

import kabbadi.domain.Invoice;
import org.joda.time.LocalDate;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class InvoiceTest {

    @Test
    public void should_use_factory_to_create_invoice() {
        Invoice invoice = new Invoice.Builder()
                .withInvoiceNumber("invoice27")
                .withSTPIApprovalNumberAndDate("123445/102001")
                .withDescriptionOfGoods("These are some goods")
                .withCurrency("USD")
                .withForeignCurrency(123.45)
                .withAmountSTPIApproval(123.45)
                .withCIFValueInINR(123.45)
                .withBondNumber("bond123")
                .withBondDate("20/11/2007")
                .withBillOfEntryNumber("billNumber3")
                .withBillOfEntryDate("20/11/2007")
                .withAssessableValueInINR(123.45)
                .withDutyExempt(123.45)
                .withTwentyFivePercentDF(0)
                .withCGApprovedInINR(123.45)
                .withDutyForgone(123.45)
                .withOffice("Bangalore")
                .withLetters("f")
                .withFlags("White flag")
                .withStatus("Good")
                .withRemarks("Remarks")
                .withPurchaseOrderNumber("orderNumber123")
                .withLocation("TWU")
                .build();

        assertThat(invoice.getInvoiceNumber(), equalTo("invoice27"));
        assertThat(invoice.getBondDate(), equalTo(new LocalDate(2007, 11, 20).toDateMidnight().toDate()));
    }

    @Test
    public void should_build_invoice_with_partial_data() {
        Invoice invoice = new Invoice.Builder()
                .withInvoiceNumber("invoice27")
                .build();

        assertThat(invoice.getInvoiceNumber(), equalTo("invoice27"));
        assertThat(invoice.getBondDate(), equalTo(null));
    }


}
