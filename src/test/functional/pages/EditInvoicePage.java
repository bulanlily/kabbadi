package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EditInvoicePage extends BasePage {

    protected EditInvoicePage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("Add a new invoice | Kabbadi"));
    }

    public EditInvoicePage changePurchaseOrderNumberTo(String poNumber) {
        driver.findElement(By.name("purchaseOrderNumber")).clear();
        driver.findElement(By.name("purchaseOrderNumber")).sendKeys(poNumber);
        return this;
    }

    public ListInvoicePage clickSubmit() {
        driver.findElement(By.name("submit")).click();
        return new ListInvoicePage(driver);
    }
}