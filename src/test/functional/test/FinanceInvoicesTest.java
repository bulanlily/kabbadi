package test;

import forms.FinanceInvoiceForm;
import forms.InvoiceForm;
import org.junit.Test;

public class FinanceInvoicesTest extends BaseTest {

    @Test
    public void should_able_to_view_list_of_invoice_in_finance_page(){
        launchKabbadi()
        .loginWithValidCredentials()
        .goToFinanceInvoiceListPage();
    }

    @Test
    public void should_be_able_to_view_details_of_a_invoice() {

        launchKabbadi()
                .loginWithValidCredentials()
                .goToFinanceAddInvoicePage()
                .submit(validInvoice())
                .viewFirstInvoiceDetails()
                .confirmFinanceInvoiceData(validInvoice());

    }

    private InvoiceForm validInvoice() {
        FinanceInvoiceForm invoice = new FinanceInvoiceForm();
        invoice.fillInvoiceNumberWith("invoice123");
        invoice.fillPurchaseOrderNumberWith("po123");
        invoice.fillLocationWith("IND");
        invoice.fillTypeWith("type1");
        return invoice;
    }
}
