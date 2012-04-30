package test;

import forms.FinanceInvoiceForm;
import forms.InvoiceForm;
import org.junit.Test;

public class ISInvoicesTest extends BaseTest {

    @Test
    public void should_able_to_add_finance_invoice_and_view_its_details(){
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAddFinancePage()
                .submit(validInvoice())
                .viewInList(validInvoice())
                .goToListISInvoicesPage()
                .viewInList(validInvoice());

    }

    private InvoiceForm validInvoice() {
        FinanceInvoiceForm invoice = new FinanceInvoiceForm();
        invoice.fillInvoiceNumberWith("invoice123");
        invoice.fillPurchaseOrderNumberWith("po123");
        invoice.fillLocationWith("IND");
        invoice.fillQuantityWith("1");
        return invoice;
    }
}
