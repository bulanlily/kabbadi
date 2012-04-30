package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.containsString;

public class ListFinanceInvoicesPage extends BasePage{

    protected ListFinanceInvoicesPage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("List Invoices | Kabbadi"));
    }

    public FinanceAddInvoicePage clickAddNew() {
        driver.findElement(By.id("finance_add_invoice")).click();

        return new FinanceAddInvoicePage(driver);
    }

    public ListFinanceInvoicesPage confirmListOfInvoices() {
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        assertTrue(rows.size() > 1);
        return this;
    }

}
