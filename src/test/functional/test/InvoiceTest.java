package test;

import forms.InvoiceForm;
import org.junit.Test;

public class InvoiceTest extends BaseTest {

    @Test
    public void should_be_able_to_edit_existing_invoice() {
        String newPurchaseOrder = "PO#"+System.currentTimeMillis();
        String newInvoiceNumber = "IN#"+System.currentTimeMillis();

        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .submit(validInvoice())
                .confirmInvoiceHasBeenAddedToAdminList(validInvoice())
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
    public void should_open_expected_invoice_details_page() {
        String invoiceNumber = "1234";
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .validFillAdminAddInvoicePage(invoiceNumber)
                .selectViewDetailsPageForInvoice(invoiceNumber)
                .confirmInvoiceDisplayedMatches(invoiceNumber);
    }

    private InvoiceForm validInvoice() {
        InvoiceForm invoice = new InvoiceForm();
        invoice.fillInvoiceNumberWith("invoice123");
        invoice.fillPurchaseOrderNumberWith("po123");
        invoice.fillStpiApprovalNumberAndDateWith("stpi123");
        invoice.fillBondNumberWith("bond123");
        invoice.fillBondDateWith("01/02/2012");
        invoice.fillAmountAsPerStpiApprovalWith("33.33");
        invoice.fillLocationWith("IND");
        return invoice;
    }
}
