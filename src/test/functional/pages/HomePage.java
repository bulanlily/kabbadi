package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("List Invoices | Kabbadi"));
    }

    public AdminAddInvoicePage goToAdminAddInvoicePage() {
        driver.findElement(By.id("admin_add_invoice")).click();
        assertThat(driver.getTitle(), containsString("Add a new invoice"));
        return new AdminAddInvoicePage(driver);
    }


   
}
