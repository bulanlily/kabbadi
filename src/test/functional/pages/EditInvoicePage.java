package pages;

import forms.InvoiceForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EditInvoicePage extends BasePage {

    protected EditInvoicePage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("Add/Edit invoice | Kabbadi"));
    }

    public ListAdminInvoicesPage submit(InvoiceForm invoiceForm) {
        fillFormWith(invoiceForm);
        return new ListAdminInvoicesPage(driver);
    }

    public EditInvoicePage changePurchaseOrderNumberTo(String poNumber) {
        driver.findElement(By.name("purchaseOrderNumber")).clear();
        driver.findElement(By.name("purchaseOrderNumber")).sendKeys(poNumber);
        return this;
    }

    public ListAdminInvoicesPage submitInvoice() {
        driver.findElement(By.name("submit")).click();
        return new ListAdminInvoicesPage(driver);
    }

    public EditInvoicePage changeInvoiceNumberTo(String newInvoiceNumber) {
        driver.findElement(By.name("invoiceNumber")).clear();
        driver.findElement(By.name("invoiceNumber")).sendKeys(newInvoiceNumber);
        return this;
    }

    private void fillFormWith(InvoiceForm invoiceForm) {
        Map<String, Object> fields = invoiceForm.getFields();
        for (String fieldName : fields.keySet()) {
            fillFieldWith(fieldName, fields.get(fieldName)+"");
        }
        driver.findElement(By.cssSelector("input[name=submit]")).click();
    }

    public EditInvoicePage fillFieldWith(String fieldName, String fieldValue) {
        driver.findElement(By.name(fieldName)).sendKeys(fieldValue);
        return this;
    }

}
