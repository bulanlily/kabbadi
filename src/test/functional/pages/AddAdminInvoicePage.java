package pages;

import forms.InvoiceForm;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class AddAdminInvoicePage extends BasePage {

    public AddAdminInvoicePage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), containsString("Add/Edit invoice"));
    }

    public ListAdminInvoicesPage submit(InvoiceForm invoiceForm) {
        fillFormWith(invoiceForm);
        return new ListAdminInvoicesPage(driver);
    }

    public AddAdminInvoicePage submitInvalid(InvoiceForm invoiceForm) {
        fillFormWith(invoiceForm);
        return this;
    }

    public AddAdminInvoicePage confirmAddInvoicePage() {
        assertThat(getTitle(), containsString("Add/Edit invoice"));
        return this;
    }
}

