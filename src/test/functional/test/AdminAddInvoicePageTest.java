package test;


import org.junit.Test;

public class AdminAddInvoicePageTest extends BaseTest{
    @Test
    public void should_stay_on_admin_add_invoice() {
        launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .invalidBlankInvoiceNumber();
    }

    @Test
	public void should_redirect_to_admin_add_invoice() {
		launchKabbadi()
        .loginWithValidCredentials()
        .goToAdminAddInvoicePage();
	}








}
