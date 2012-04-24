package test;

import forms.InvoiceForm;
import org.junit.Test;

public class InvoiceTest extends BaseTest {

    @Test
    public void should_be_able_to_edit_existing_invoice() {
        String purchaseOrder = "PO#"+System.currentTimeMillis();
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .submit(validInvoice())
                .confirmInvoiceHasBeenAddedToAdminList(validInvoice())
                .editFirstInvoice()
                .changePurchaseOrderNumberTo(purchaseOrder)
                .clickSubmit()
                .confirmFirstPONumberIs(purchaseOrder);
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

    @Test
    public void should_successfully_add_invoice_with_valid_data() {
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .validFillAdminAddInvoicePage()
                .confirmInvoiceIsInInvoiceList();
    }

    @Test
    public void should_fail_to_add_invoice_with_invalid_data() {
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .invalidBlankInvoiceNumber()
                .confirmAddInvoicePage();
    }
}
