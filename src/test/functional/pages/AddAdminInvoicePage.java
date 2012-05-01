package pages;

import builder.InvoiceTestBuilder;
import forms.InvoiceForm;
import kabbadi.domain.Invoice;
import org.apache.commons.lang.time.DateFormatUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class AddAdminInvoicePage extends BasePage {

    private final Invoice invoice;

    public AddAdminInvoicePage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), containsString("Add/Edit invoice"));
        invoice = new InvoiceTestBuilder().build();
    }

    public ListAdminInvoicesPage submit(InvoiceForm invoiceForm) {
        fillFormWith(invoiceForm);
        return new ListAdminInvoicesPage(driver);
    }

    public AddAdminInvoicePage submitInvalid(InvoiceForm invoiceForm) {
        fillFormWith(invoiceForm);
        return this;
    }

    public AddAdminInvoicePage invalidBlankInvoiceNumber() {
        driver.findElement(By.name("purchaseOrderNumber")).sendKeys(invoice.getPurchaseOrderNumber());
        driver.findElement(By.name("STPIApprovalNumberAndDate")).sendKeys(invoice.getSTPIApprovalNumberAndDate());
        driver.findElement(By.name("descriptionOfGoods")).sendKeys(invoice.getDescriptionOfGoods());
        driver.findElement(By.name("foreignValue.currency")).sendKeys(invoice.getForeignCurrency());
        driver.findElement(By.name("amountSTPIApproval")).sendKeys(String.valueOf(invoice.getAmountSTPIApproval()));
        driver.findElement(By.name("CIFValueInINR")).sendKeys(String.valueOf(invoice.getCIFValueInINR()));
        driver.findElement(By.name("bondNumber")).sendKeys(invoice.getBondNumber());
        driver.findElement(By.name("bondDate")).sendKeys(format(invoice.getBondDate()));
        driver.findElement(By.name("dateOfArrival")).sendKeys(format(invoice.getDateOfArrival()));
        driver.findElement(By.name("billOfEntryNumber")).sendKeys(invoice.getBillOfEntryNumber());
        driver.findElement(By.name("billOfEntryDate")).sendKeys(format(invoice.getBillOfEntryDate()));
        driver.findElement(By.name("assessableValueInINR")).sendKeys(String.valueOf(invoice.getAssessableValueInINR()));
        driver.findElement(By.name("dutyExempt")).sendKeys(String.valueOf(invoice.getDutyExempt()));
        driver.findElement(By.name("twentyFivePercentDF")).sendKeys(String.valueOf(invoice.getTwentyFivePercentDF()));
        driver.findElement(By.name("cgApprovedInINR")).sendKeys(String.valueOf(invoice.getCgApprovedInINR()));
        driver.findElement(By.name("dutyForgone")).sendKeys(String.valueOf(invoice.getDutyForgone()));
        driver.findElement(By.name("runningBalance")).sendKeys(String.valueOf(invoice.getRunningBalance()));

        List<WebElement> importTypeOptions = driver.findElement(By.name("importType")).findElements(By.tagName("option"));
        for (WebElement importTypeOption : importTypeOptions) {
            if(importTypeOption.getText().equals(invoice.getImportType().getDescription())) {
                importTypeOption.click();
            }
        }

        driver.findElement(By.name("status")).sendKeys(invoice.getStatus());
        driver.findElement(By.name("remarks")).sendKeys(invoice.getRemarks());
        driver.findElement(By.name("location")).sendKeys(invoice.getLocation());

        driver.findElement(By.name("submit")).click();

        return new AddAdminInvoicePage(driver);
    }

    private String format(Date date) {
        return DateFormatUtils.format(date, "dd/MM/yyyy");
    }

    public AddAdminInvoicePage fillFieldWith(String fieldName, String fieldValue) {
        driver.findElement(By.cssSelector("input[name=" + fieldName + "]")).sendKeys(fieldValue);
        return this;
    }

    private void fillFormWith(InvoiceForm invoiceForm) {
        Map<String, String> fields = invoiceForm.getFields();
        for (String fieldName : fields.keySet()) {
            fillFieldWith(fieldName, fields.get(fieldName));
        }
        driver.findElement(By.cssSelector("input[name=submit]")).click();
    }

    public AddAdminInvoicePage confirmAddInvoicePage() {
        assertThat(getTitle(), containsString("Add/Edit invoice"));
        return this;
    }
}

