package pages;

import config.Configuration;
import forms.InvoiceForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

public class ViewInvoiceDetailsPage extends BasePage {
    public ViewInvoiceDetailsPage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("View an Invoice | Kabbadi"));
    }

    public ViewInvoiceDetailsPage confirmFinanceInvoiceData(InvoiceForm invoiceForm){
        verifyInvoiceDataIsOnTable(invoiceForm, "Finance");
        return this;
    }

    public ViewInvoiceDetailsPage confirmAdminInvoiceData(InvoiceForm invoice) {
        verifyInvoiceDataIsOnTable(invoice, "Admin");
        return this;
    }

    private void verifyInvoiceDataIsOnTable(InvoiceForm invoice, String role) {
        driver.findElement(By.linkText(role)).click();

        WebElement table = driver.findElement(By.cssSelector("#"+ role.toLowerCase() + " table"));
        Map<String, Object> fields = invoice.getFields();
        String tableText = table.getText();

        for (Object value : fields.values()) {
            assertThat(tableText, containsString(value+""));
        }
    }

    public ListAdminInvoicesPage returnToAdminListPage() {
        driver.get(Configuration.KABBADI_URL);
        return new ListAdminInvoicesPage(driver);
    }
}
