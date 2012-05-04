package pages;

import forms.InvoiceForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
public class AddFinanceInvoicePage extends BasePage {

    protected AddFinanceInvoicePage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), containsString("Add/Edit Invoice"));
    }

    public ListFinanceInvoicesPage submit(InvoiceForm invoiceForm) {
        fillFormWith(invoiceForm);
        return new ListFinanceInvoicesPage(driver);
    }

    public AddFinanceInvoicePage submitInvalid(InvoiceForm invoiceForm) {
        fillFormWith(invoiceForm);
        return this;
    }

    private AddFinanceInvoicePage selectFieldWith(String fieldName, String fieldValue) {
        Select select = new Select(driver.findElement(By.name(fieldName)));
        select.selectByVisibleText(fieldValue);
        return this;
    }


    public AddFinanceInvoicePage fillFieldWith(String fieldName, String fieldValue) {
        driver.findElement(By.cssSelector("input[name=" + fieldName + "]")).sendKeys(fieldValue);
        return this;
    }

    public AddFinanceInvoicePage checkErrorMessage(String errorMessage) {
        WebElement form = driver.findElement(By.cssSelector("form"));
        assertThat(form.getText(), containsString(errorMessage));
        return this;
    }
}
