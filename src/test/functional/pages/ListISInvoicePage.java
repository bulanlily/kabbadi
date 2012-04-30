package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ListISInvoicePage extends BasePage{

    protected ListISInvoicePage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("List Invoices | Kabbadi"));
    }

    public ListISInvoicePage confirmInvoiceExistInISList(String invoiceNumber) {
        assertNotNull(driver.findElement(By.id("is_invoice_" + invoiceNumber)));
        return new ListISInvoicePage(driver);
    }
}
