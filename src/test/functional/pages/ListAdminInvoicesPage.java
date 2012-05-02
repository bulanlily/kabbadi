package pages;

import forms.InvoiceForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class ListAdminInvoicesPage extends BasePage {
    public ListAdminInvoicesPage(WebDriver driver) {
        super(driver);

        assertThat(driver.getTitle(), equalTo("List Invoices | Kabbadi"));
    }

    public EditInvoicePage editFirstInvoice() {
        driver.findElement(By.id("invoices")).findElements(By.tagName("tr")).get(1)
                .findElement(By.linkText("EDIT")).click();
        return new EditInvoicePage(driver);
    }

    public ListAdminInvoicesPage confirmFirstPONumberIs(String purchaseOrder) {

        String rowData = driver.findElement(By.id("invoices")).findElements(By.tagName("tr")).get(1).getText();
        assertThat(rowData, containsString(purchaseOrder));
        return this;
    }

    public AddAdminInvoicePage goToAdminAddInvoicePage() {
        return addInvoiceOf("admin");
    }

    public ListAdminInvoicesPage confirmFirstInvoiceNumberIs(String newInvoiceNumber) {
        return confirmFirstInvoiceContainsValue(newInvoiceNumber);
    }

    public AddFinanceInvoicePage goToAddFinancePage() {
        driver.findElement(By.cssSelector("a[href='#finance']")).click();
        driver.findElement(By.id("finance_add_invoice")).click();
        assertThat(driver.getTitle(), containsString("Add/Edit invoice"));
        return new AddFinanceInvoicePage(driver);
    }

    private AddAdminInvoicePage addInvoiceOf(String role) {
        driver.findElement(By.cssSelector("a[href='#" + role + "']")).click();
        driver.findElement(By.id(role + "_add_invoice")).click();
        assertThat(driver.getTitle(), containsString("Add/Edit invoice"));
        return new AddAdminInvoicePage(driver);
    }

    public ViewInvoiceDetailsPage viewInvoiceDetails(String invoiceNumber) {
        WebElement id = driver.findElement(By.id("admin_invoice_" + invoiceNumber));
        id.findElement(By.linkText("VIEW")).click();
        return new ViewInvoiceDetailsPage(driver);
    }

    private ListAdminInvoicesPage confirmFirstInvoiceContainsValue(String fieldValue) {
        String rowData = driver.findElement(By.id("invoices")).findElements(By.tagName("tr")).get(1).getText();
        assertThat(rowData, containsString(fieldValue));
        return this;
    }

    public ListAdminInvoicesPage confirmInvoiceHasNotBeenAddedToAdminList(InvoiceForm invoiceForm) {

        Map<String, Object> fields = invoiceForm.getFields();
        WebElement table = driver.findElement(By.cssSelector("#admin table"));

        for (Object fieldValue : fields.values()) {
            if (!fieldValue.equals(""))
                assertThat(table.getText(), not(containsString(fieldValue+"")));
        }

        return this;
    }

    public ListAdminInvoicesPage viewInvoiceInListPage(InvoiceForm invoice) {
        Map<String, Object> fields = invoice.getFields();
        WebElement tableRow = driver.findElement(By.id("admin_invoice_" + fields.get("invoiceNumber")));
        assertThat(tableRow.getText(), containsString(fields.get("invoiceNumber")+""));
        return this;
    }
}
