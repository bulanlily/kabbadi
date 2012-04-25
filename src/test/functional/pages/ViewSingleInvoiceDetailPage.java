package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class ViewSingleInvoiceDetailPage extends BasePage{
    public ViewSingleInvoiceDetailPage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("View an Invoice | Kabbadi"));
    }

    public ViewSingleInvoiceDetailPage confirmInvoiceDisplayedMatches(String invoiceNumber) {
        assertThat(driver.findElement(By.cssSelector("h1")).getText(), containsString(invoiceNumber));
        return this;
    }
}
