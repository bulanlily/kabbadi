package test;

import org.junit.Test;

public class InvoiceTest extends BaseTest{

    @Test
    public void should_be_able_to_edit_existing_invoice() {
        launchKabbadi()
        .loginWithValidCredentials()
        .editFirstInvoice()
        .changePurchaseOrderNumberTo("PO#343")
        .clickSubmit()
        .findPurchaseOrderNumber("PO#343");
    }
}
