package test;

import org.junit.Test;
import pages.AdminAddInvoicePage;
import pages.ListInvoicePage;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

public class AdminAddInvoicePageTest extends BaseTest {

    @Test
    public void should_successfully_add_invoice_with_valid_data() {
        ListInvoicePage page = launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .validFillAdminAddInvoicePage();
        assertTrue(page.idExists("admin_invoice_123123"));
    }

    @Test
    public void should_fail_to_add_invoice_with_invalid_data() {
        AdminAddInvoicePage page = launchKabbadi()
                .loginWithValidCredentials()
                .goToAdminAddInvoicePage()
                .invalidBlankInvoiceNumber();
        assertThat(page.getTitle(), containsString("Add a new invoice"));
    }
}
