package pages;

import forms.InvoiceForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EditInvoicePage extends BasePage {

    protected EditInvoicePage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("Add/Edit Invoice | Kabbadi"));
    }

    public ListAdminInvoicesPage submit(InvoiceForm invoiceForm) {
        fillFormWithValidDetails(invoiceForm);
        return new ListAdminInvoicesPage(driver);
    }

    public EditInvoicePage changePurchaseOrderNumberTo(String poNumber) {
        driver.findElement(By.name("purchaseOrderNumber")).clear();
        driver.findElement(By.name("purchaseOrderNumber")).sendKeys(poNumber);
        return this;
    }

    public ListAdminInvoicesPage submitInvoice() {
        driver.findElement(By.name("submitButton")).click();
        driver.findElement(By.id("submit-modal")).click();
        return new ListAdminInvoicesPage(driver);
    }

    public EditInvoicePage changeInvoiceNumberTo(String newInvoiceNumber) {
        driver.findElement(By.name("invoiceNumber")).clear();
        driver.findElement(By.name("invoiceNumber")).sendKeys(newInvoiceNumber);
        return this;
    }
}
