package pages;

import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ViewSingleInvoiceDetailPage extends BasePage{
    public ViewSingleInvoiceDetailPage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("View an Invoice | Kabbadi"));
    }
}
