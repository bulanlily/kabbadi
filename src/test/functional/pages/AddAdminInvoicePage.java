package pages;

import builder.InvoiceTestBuilder;
import forms.InvoiceForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class AddAdminInvoicePage extends BasePage {

    public AddAdminInvoicePage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), containsString("Add/Edit invoice"));
    }

    public ListAdminInvoicesPage submit(InvoiceForm invoiceForm) {
        fillFormWith(invoiceForm);
        return new ListAdminInvoicesPage(driver);
    }

    public AddAdminInvoicePage invalidBlankInvoiceNumber() {
        Map<String, Object> fields = new InvoiceTestBuilder().withInvoiceNumber("").buildAdmin().getFields();
        for (Object key : fields.keySet())  {
             driver.findElement(By.name(key+"")).sendKeys(fields.get(key)+"");
        }

        driver.findElement(By.name("submit")).click();

        return new AddAdminInvoicePage(driver);
    }

    public AddAdminInvoicePage fillFieldWith(String fieldName, String fieldValue) {
        driver.findElement(By.name(fieldName)).sendKeys(fieldValue);
        return this;
    }

    private void fillFormWith(InvoiceForm invoiceForm) {
        Map<String, Object> fields = invoiceForm.getFields();
        for (String fieldName : fields.keySet()) {
            fillFieldWith(fieldName, fields.get(fieldName)+"");
        }
        driver.findElement(By.cssSelector("input[name=submit]")).click();
    }

    public AddAdminInvoicePage confirmAddInvoicePage() {
        assertThat(getTitle(), containsString("Add/Edit invoice"));
        return this;
    }
}

