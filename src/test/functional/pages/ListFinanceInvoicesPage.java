package pages;

import forms.InvoiceForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class ListFinanceInvoicesPage extends BasePage{

    protected ListFinanceInvoicesPage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("List Invoices | Kabbadi"));
    }

    public ListFinanceInvoicesPage viewInList(InvoiceForm invoiceForm) {
        Map<String, String> fields = invoiceForm.getFields();
        WebElement tableRow = driver.findElement(By.id("finance_invoice_" + fields.get("invoiceNumber")));

        for (String fieldValue : fields.values()) {
            assertThat(tableRow.getText(), containsString(fieldValue));
        }
        return this;
    }

    public ViewSingleInvoiceDetailPage viewFirstInvoiceDetails() {
        driver.findElement(By.linkText("VIEW")).click();
        return new ViewSingleInvoiceDetailPage(driver);
    }
}
