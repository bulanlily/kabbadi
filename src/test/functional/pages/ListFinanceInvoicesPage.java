package pages;

import forms.InvoiceForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.containsString;

public class ListFinanceInvoicesPage extends BasePage{

    protected ListFinanceInvoicesPage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("List Invoices | Kabbadi"));
    }

    public ListFinanceInvoicesPage viewInvoiceInListPage(InvoiceForm invoiceForm) {
        Map<String, Object> fields = invoiceForm.getFields();
        WebElement tableRow = driver.findElement(By.id("finance_invoice_" + fields.get("invoiceNumber")));
        assertThat(tableRow.getText(), containsString(fields.get("invoiceNumber")+""));
        return this;
    }

    public ViewInvoiceDetailsPage viewFirstInvoiceDetails() {
        driver.findElement(By.linkText("VIEW")).click();
        return new ViewInvoiceDetailsPage(driver);
    }

    public ListISInvoicesPage goToListISInvoicesPage() {
        driver.findElement(By.linkText("IS")).click();
        return new ListISInvoicesPage(driver);
    }

    public ListFinanceInvoicesPage searchForInvoiceInListPage(InvoiceForm invoice) {
        String invoiceNumber = invoice.getFields().get("invoiceNumber").toString();
        driver.findElement(By.id("finance_search")).sendKeys(invoiceNumber);
        assertTrue("search did not display expected result", driver.findElement(By.id("finance_invoice_" + invoiceNumber)).isDisplayed());
        return this;
    }
}
