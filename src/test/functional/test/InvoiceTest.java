package test;

import org.junit.Test;

public class InvoiceTest extends BaseTest{

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
}