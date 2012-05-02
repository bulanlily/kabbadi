package test;

import builder.InvoiceTestBuilder;
import forms.InvoiceForm;
import org.junit.Test;

public class AdminInvoicesTest extends BaseTest {

    @Test
    public void should_be_able_to_add_and_edit_an_admin_invoice_and_view_its_details() {
        InvoiceForm invoice = new InvoiceTestBuilder().buildAdmin();
        String newPurchaseOrder = "PO#" + System.currentTimeMillis();
        String newInvoiceNumber = "IN#" + System.currentTimeMillis();

        String invoiceNumber = getDefaultInvoiceNumber(invoice);
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .submit(invoice)
                .viewInvoiceInListPage(invoice)
                .viewInvoiceDetails(invoiceNumber)
                .confirmAdminInvoiceData(invoice)
                .returnToAdminListPage()
                .editFirstInvoice()
                .changePurchaseOrderNumberTo(newPurchaseOrder)
                .changeInvoiceNumberTo(newInvoiceNumber)
                .submitInvoice()
                .confirmFirstPONumberIs(newPurchaseOrder)
                .confirmFirstInvoiceNumberIs(newInvoiceNumber);
    }

    @Test
    public void should_fail_to_add_invoice_with_invalid_data() {
        InvoiceForm invalidInvoice = new InvoiceTestBuilder()
                .withInvoiceNumber("")
                .buildAdmin();

        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .submitInvalid(invalidInvoice)
                .confirmAddInvoicePage();
    }

    @Test
    public void should_not_list_non_bonded_invoices_in_the_admin_tab() {
        InvoiceForm newInvoice = validNonBondedInvoice();
        launchKabbadi().loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .submit(newInvoice)
                .confirmInvoiceHasNotBeenAddedToAdminList(newInvoice);
    }


    private String getDefaultInvoiceNumber(InvoiceForm invoice) {
        return invoice.getFields().get("invoiceNumber").toString();
    }

    private InvoiceForm validNonBondedInvoice() {
        return new InvoiceTestBuilder().withBondNumber("").buildAdmin();
    }

}
