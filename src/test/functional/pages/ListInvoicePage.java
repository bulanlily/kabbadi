package pages;

import forms.InvoiceForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class ListInvoicePage extends BasePage {
    public ListInvoicePage(WebDriver driver) {
        super(driver);

        assertThat(driver.getTitle(), equalTo("List Invoices | Kabbadi"));
    }

    public EditInvoicePage editFirstInvoice() {
        driver.findElement(By.id("invoices")).findElements(By.tagName("tr")).get(1)
                .findElement(By.linkText("EDIT")).click();
        return new EditInvoicePage(driver);
    }

    public ListInvoicePage confirmFirstPONumberIs(String purchaseOrder) {

        String rowData = driver.findElement(By.id("invoices")).findElements(By.tagName("tr")).get(1).getText();
        assertThat(rowData, containsString(purchaseOrder));
        return this;
    }

    public AddInvoicePage goToAdminAddInvoicePage() {
        return addInvoiceOf("admin");
    }

    public ListInvoicePage confirmInvoiceHasBeenAddedToAdminList(InvoiceForm invoiceForm) {
        Map<String, String> fields = invoiceForm.getFields();
        WebElement tableRow = driver.findElement(By.id("admin_invoice_" + fields.get("invoiceNumber")));

        for (String fieldValue : fields.values()) {
            assertThat(tableRow.getText(), containsString(fieldValue));
        }

        return this;
    }

    public ViewSingleInvoiceDetailPage viewFirstInvoiceDetails() {
        driver.findElement(By.linkText("VIEW")).click();
        return new ViewSingleInvoiceDetailPage(driver);
    }

    public FinanceListInvoicePage goToFinanceInvoiceListPage() {
        driver.findElement(By.linkText("Finance")).click();
        return new FinanceListInvoicePage(driver);
    }

    public ListInvoicePage confirmInvoiceIsInInvoiceList() {
        assertTrue(idExists("admin_invoice_123123"));
        return new ListInvoicePage(driver);
    }

    public AddInvoicePage goToFinanceAddInvoicePage() {
        return addInvoiceOf("finance");
    }

    private AddInvoicePage addInvoiceOf(String role) {
        driver.findElement(By.cssSelector("a[href='#" + role + "']")).click();
        driver.findElement(By.id(role +"_add_invoice")).click();
        assertThat(driver.getTitle(), containsString("Add a new invoice"));
        return new AddInvoicePage(driver);
    }

    public ViewSingleInvoiceDetailPage selectViewDetailsPageForInvoice(String invoiceNumber) {
        WebElement id = driver.findElement(By.id("admin_invoice_" + invoiceNumber));
        id.findElement(By.linkText("VIEW")).click();
        return new ViewSingleInvoiceDetailPage(driver);
    }

    public ListInvoicePage confirmInvoiceNumberIs(String newInvoiceNumber) {

        String rowData = driver.findElement(By.id("invoices")).findElements(By.tagName("tr")).get(1).getText();
        assertThat(rowData, containsString(newInvoiceNumber));
        return this;
    }
}
