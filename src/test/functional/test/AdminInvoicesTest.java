package test;

import forms.AdminInvoiceForm;
import forms.InvoiceForm;
import org.junit.Test;

public class AdminInvoicesTest extends BaseTest {

    @Test
    public void should_be_able_to_edit_existing_invoice() {
        String newPurchaseOrder = "PO#" + System.currentTimeMillis();
        String newInvoiceNumber = "IN#" + System.currentTimeMillis();

        InvoiceForm newInvoice = validInvoice("1234");
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .submit(newInvoice)
                .confirmInvoiceHasBeenAddedToAdminList(newInvoice)
                .editFirstInvoice()
                .changePurchaseOrderNumberTo(newPurchaseOrder)
                .changeInvoiceNumberTo(newInvoiceNumber)
                .submitInvoice()
                .confirmFirstPONumberIs(newPurchaseOrder)
                .confirmFirstInvoiceNumberIs(newInvoiceNumber);
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
        InvoiceForm invoice = validInvoice(invoiceNumber);
        invoice.fillBondNumber("");
        return invoice;
    }

    private AdminInvoiceForm validInvoice(String invoiceNumber) {
        AdminInvoiceForm invoice = new AdminInvoiceForm();
        invoice.fillInvoiceNumberWith(invoiceNumber);
        invoice.fillPurchaseOrderNumberWith("po123");
        invoice.fillStpiApprovalNumberAndDateWith("stpi123");
        invoice.fillBondNumberWith("bond123");
        invoice.fillBondDateWith("01/02/2012");
        invoice.fillAmountAsPerStpiApprovalWith("33.33");
        invoice.fillLocationWith("IND");
        return invoice;
    }

    private InvoiceForm validInvoiceWithSpecifMoneyValue(String invoiceNumber, String moneyValue) {
        AdminInvoiceForm invoiceForm = validInvoice(invoiceNumber);
        invoiceForm.fillCIFValueInINR(moneyValue);
        return invoiceForm;
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
    public void should_open_expected_invoice_details_page() {
        String invoiceNumber = "101010Invoice";
        InvoiceForm invoice = validInvoiceWithSpecifMoneyValue(invoiceNumber, "100.10");

        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .submit(invoice)
                .selectViewDetailsPageForInvoice(invoiceNumber)
                .confirmAdminInvoiceData(invoice);
    }
}
