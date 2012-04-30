package test;

import forms.FinanceInvoiceForm;
import forms.InvoiceForm;
import org.junit.Test;

public class FinanceInvoicesTest extends BaseTest {

    @Test
    public void should_able_to_add_finance_invoice_and_view_its_details(){
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAddFinancePage()
                .submit(validInvoice())
                .viewInvoiceInListPage(validInvoice())
                .viewFirstInvoiceDetails()
                .confirmFinanceInvoiceData(validInvoice());
    }

    @Test
    public void should_validate_the_fields_before_submitting_the_form() {
        InvoiceForm newInvoice = invalidInvoice("1234");
        launchKabbadi().loginWithValidCredentials()
                .goToAddFinancePage()
                .submitInvalid(newInvoice)
                .checkErrorMessage("Please enter a number");
    }

    private InvoiceForm validInvoice() {
        FinanceInvoiceForm invoice = new FinanceInvoiceForm();
        invoice.fillInvoiceNumberWith("invoice123");
        invoice.fillPurchaseOrderNumberWith("po123");
        invoice.fillLocationWith("IND");
        invoice.fillQuantityWith("1");
        return invoice;
    }

    private InvoiceForm invalidInvoice(String invoiceNumber) {
        InvoiceForm invoice = new InvoiceForm();
        invoice.fillInvoiceNumberWith(invoiceNumber);
        invoice.fillQuantity("bla");
        return invoice;
    }
}
