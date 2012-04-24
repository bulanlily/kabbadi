package test;

import forms.InvoiceForm;
import org.junit.Test;

public class InvoiceTest extends BaseTest {

    @Test
    public void should_be_able_to_edit_existing_invoice() {
        String purchaseOrder = "PO#343";
        launchKabbadi()
        .loginWithValidCredentials()
        .confirmFirstPONumberIsNot(purchaseOrder)
        .editFirstInvoice()
        .changePurchaseOrderNumberTo(purchaseOrder)
        .clickSubmit()
        .confirmFirstPONumberIs(purchaseOrder);
    }
    @Test
    public void should_be_able_to_view_the_invoice_details(){
        launchKabbadi()
                .loginWithValidCredentials()
                .viewFirstInvoiceDetails();
    }

    @Test
    public void should_list_invoice_after_creating_it() {
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .fillItWith(validInvoice())
                .submitInvoice()
                .confirmInvoiceHasBeenAddedToAdminList(validInvoice())
        ;
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
