package test;

import org.junit.Test;

public class FinanceAddInvoicePageTest extends BaseTest{

    @Test
    public void should_successfully_fill_valid_data_and_submit() {
        launchKabbadi()
                .loginWithValidCredentials()
                .goToFinanceInvoiceListPage()
                .clickAddNew()
                .fillForm()
                .submit()
                .financeTabShouldBeActive();

    }
}
