package test;

import builder.InvoiceTestBuilder;
import forms.InvoiceForm;
import org.junit.Test;

public class ISInvoicesTest extends BaseTest {

    @Test
    public void should_able_to_add_finance_invoice_and_view_its_details(){
        InvoiceForm invoiceForm = new InvoiceTestBuilder().buildFinance();
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAddFinancePage()
                .submit(invoiceForm)
                .viewInvoiceInListPage(invoiceForm)
                .goToListISInvoicesPage()
                .viewInList(invoiceForm);

    }

}
