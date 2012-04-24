package test;

import org.junit.Test;

public class FinanceListInvoicePageTest extends BaseTest{
    @Test
    public void should_able_to_view_list_of_invoice_in_finance_page(){
        launchKabbadi()
        .loginWithValidCredentials()
        .goToFinanceInvoiceListPage();
    }
}
