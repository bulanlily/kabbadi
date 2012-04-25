package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ListFinanceInvoicesPage extends BasePage{

    protected ListFinanceInvoicesPage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("List Invoices | Kabbadi"));
    }

    public FinanceAddInvoicePage clickAddNew() {
        driver.findElement(By.id("finance_add_invoice")).click();
        driver.findElement(By.id("finance_tab")).click();
        return new FinanceAddInvoicePage(driver);
    }
}
