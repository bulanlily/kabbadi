package pages;

import forms.InvoiceForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

public class ViewSingleInvoiceDetailPage extends BasePage {
    public ViewSingleInvoiceDetailPage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("View an Invoice | Kabbadi"));
    }

    public void confirmFinanceInvoiceData(InvoiceForm invoiceForm) {
        driver.findElement(By.linkText("Finance")).click();

        WebElement table = driver.findElement(By.cssSelector("#finance table"));
        Map<String, String> fields = invoiceForm.getFields();

        for (String value : fields.values()) {
            assertThat(table.getText(), containsString(value));
        }
    }
}
