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

    public void confirmFinanceInvoiceData(InvoiceForm invoiceForm){
        verifyInvoiceDataIsOnTable(invoiceForm, "Finance");
    }

    public ViewSingleInvoiceDetailPage confirmInvoiceDisplayedMatches(String invoiceNumber) {
        assertThat(driver.findElement(By.cssSelector("h1")).getText(), containsString(invoiceNumber));
        return this;
    }

    public void confirmAdminInvoiceData(InvoiceForm invoice) {
        verifyInvoiceDataIsOnTable(invoice, "Admin");
    }

    private void verifyInvoiceDataIsOnTable(InvoiceForm invoice, String role) {
        driver.findElement(By.linkText(role)).click();

        WebElement table = driver.findElement(By.cssSelector("#"+ role.toLowerCase() + " table"));
        Map<String, String> fields = invoice.getFields();
        String tableText = table.getText();

        for (String value : fields.values()) {
            assertThat(tableText, containsString(value));
        }
    }
}
