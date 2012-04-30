package pages;

import builder.InvoiceTestBuilder;
import forms.InvoiceForm;
import kabbadi.domain.Invoice;
import org.apache.commons.lang.time.DateFormatUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class FinanceAddInvoicePage extends BasePage {

    private final Invoice invoice;

    protected FinanceAddInvoicePage(WebDriver driver) {
        super(driver);
//        assertThat(driver.getTitle(), containsString("Add/Edit invoice"));
        invoice = new InvoiceTestBuilder().build();
    }

    public FinanceAddInvoicePage fillForm() {
        driver.findElement(By.name("invoiceNumber")).sendKeys(invoice.getInvoiceNumber());
        driver.findElement(By.name("dateOfInvoice")).sendKeys(format(invoice.getDateOfInvoice()));
        driver.findElement(By.name("purchaseOrderNumber")).sendKeys(invoice.getPurchaseOrderNumber());
        driver.findElement(By.name("location")).sendKeys(invoice.getLocation());
        driver.findElement(By.name("invoiceNumber")).sendKeys(invoice.getInvoiceNumber());
        driver.findElement(By.name("supplierNameAndAddress")).sendKeys(invoice.getSupplierNameAndAddress());
        driver.findElement(By.name("openingPurchaseValueAsOnApril01")).sendKeys(String.valueOf(invoice.getOpeningPurchaseValueAsOnApril01()));
        driver.findElement(By.name("additionsDuringTheYear")).sendKeys(String.valueOf(invoice.getAdditionsDuringTheYear()));
        driver.findElement(By.name("deletionsDuringTheYear")).sendKeys(String.valueOf(invoice.getDeletionsDuringTheYear()));
        driver.findElement(By.name("dateOfCommissioning")).sendKeys(format(invoice.getDateOfCommissioning()));
        driver.findElement(By.name("costCentre")).sendKeys(invoice.getCostCentre());
        driver.findElement(By.name("quantity")).sendKeys(String.valueOf(invoice.getQuantity()));
        driver.findElement(By.name("identificationNumber")).sendKeys(invoice.getIdentificationNumber());
        return new FinanceAddInvoicePage(driver);
    }
    public ListAdminInvoicesPage submit() {
        driver.findElement(By.cssSelector("input[name=submit]")).click();
        return new ListAdminInvoicesPage(driver);
    }

    private String format(Date date) {
        return DateFormatUtils.format(date, "dd/MM/yyyy");
    }

}
