package test;

import builder.InvoiceTestBuilder;
import forms.InvoiceForm;
import kabbadi.domain.Money;
import org.junit.Test;

import java.math.BigDecimal;

public class AdminInvoicesTest extends BaseTest {

    @Test
    public void should_be_able_to_add_admin_invoice_and_view_its_details() {
        String invoiceNumber = "101010Invoice";
        InvoiceForm invoice = new InvoiceTestBuilder()
                .withCIFValueInINR(new Money("INR", new BigDecimal("101.10")))
                .withInvoiceNumber(invoiceNumber)
                .buildAdmin();

        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .submit(invoice)
                .viewInvoiceInListPage(invoice)
                .viewInvoiceDetails(invoiceNumber)
                .confirmAdminInvoiceData(invoice);
    }

    @Test
    public void should_be_able_to_edit_existing_invoice() {
        String newPurchaseOrder = "PO#" + System.currentTimeMillis();
        String newInvoiceNumber = "IN#" + System.currentTimeMillis();

        InvoiceForm newInvoice = new InvoiceTestBuilder().buildAdmin();
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .submit(newInvoice)
                .viewInvoiceInListPage(newInvoice)
                .editFirstInvoice()
                .changePurchaseOrderNumberTo(newPurchaseOrder)
                .changeInvoiceNumberTo(newInvoiceNumber)
                .submitInvoice()
                .confirmFirstPONumberIs(newPurchaseOrder)
                .confirmFirstInvoiceNumberIs(newInvoiceNumber);
    }

    @Test
    public void should_fail_to_add_invoice_with_invalid_data() {
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .invalidBlankInvoiceNumber()
                .confirmAddInvoicePage();
    }

    @Test
    public void should_not_list_non_bonded_invoices_in_the_admin_tab() {
        InvoiceForm newInvoice = validNonBondedInvoice("1111");
        launchKabbadi().loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .submit(newInvoice)
                .confirmInvoiceHasNotBeenAddedToAdminList(newInvoice);
    }

    private InvoiceForm validNonBondedInvoice(String invoiceNumber) {
        return new InvoiceTestBuilder().withBondNumber("").buildAdmin();
    }

}
