package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ListInvoicePage extends BasePage {
    public ListInvoicePage(WebDriver driver) {
        super(driver);

        assertThat(driver.getTitle(), equalTo("List Invoices | Kabbadi"));
    }


    public EditInvoicePage editFirstInvoice() {
        driver.findElement(By.linkText("EDIT")).click();
        return new EditInvoicePage(driver);
    }

    public ListInvoicePage findPurchaseOrderNumber(String poNumber) {
        assertTrue(driver.getPageSource().contains(poNumber));
        return this;
    }
}
