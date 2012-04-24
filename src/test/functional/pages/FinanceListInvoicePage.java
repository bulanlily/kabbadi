package pages;

import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FinanceListInvoicePage extends BasePage{

    protected FinanceListInvoicePage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("List Invoices | Kabbadi"));
    }
}
