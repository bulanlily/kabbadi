package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class AdminAddInvoicePage extends BasePage{
	public AdminAddInvoicePage(WebDriver driver) {
		super(driver);
        assertThat(driver.getTitle(), containsString("Admin"));
	}


    public HomePage validFillAdminAddInvoicePage() {
        driver.findElement(By.name("purchaseOrderNumber ")).sendKeys("bill");
        driver.findElement(By.name("invoiceNumber ")).sendKeys("bill");
        driver.findElement(By.name("STPIApprovalNumberAndDate ")).sendKeys("bill");
        driver.findElement(By.name("descriptionOfGoods ")).sendKeys("bill");
        driver.findElement(By.name("currency ")).sendKeys("bill");
        driver.findElement(By.name("foreignCurrency ")).sendKeys("bill");
        driver.findElement(By.name("amountSTPIApproval ")).sendKeys("bill");
        driver.findElement(By.name("CIFValueInINR ")).sendKeys("bill");
        driver.findElement(By.name("bondNumber0 ")).sendKeys("bill");
        driver.findElement(By.name("bondDate1 ")).sendKeys("bill");
        driver.findElement(By.name("billOfEntryNumber2 ")).sendKeys("bill");
        driver.findElement(By.name("billOfEntryDate3 ")).sendKeys("bill");
        driver.findElement(By.name("assessableValueInINR4 ")).sendKeys("bill");
        driver.findElement(By.name("dutyExempt5 ")).sendKeys("bill");
        driver.findElement(By.name("twentyFivePercentDF6 ")).sendKeys("bill");
        driver.findElement(By.name("CGApprovedInINR7 ")).sendKeys("bill");
        driver.findElement(By.name("dutyForgone8 ")).sendKeys("bill");
        driver.findElement(By.name("runningBalance9 ")).sendKeys("bill");
        driver.findElement(By.name("outrightPurchase0 ")).sendKeys("bill");
        driver.findElement(By.name("loanBasis1 ")).sendKeys("bill");
        driver.findElement(By.name("freeOfCharge2 ")).sendKeys("bill");
        driver.findElement(By.name("status3 ")).sendKeys("bill");
        driver.findElement(By.name("remarks4 ")).sendKeys("bill");
        driver.findElement(By.name("location ")).sendKeys("bill");

        driver.findElement(By.name("Submit invoice")).click();

        return new HomePage(driver);
    }

    public void invalidBlankInvoiceNumber() {
        driver.findElement(By.name("purchaseOrderNumber ")).sendKeys("bill");
        driver.findElement(By.name("invoiceNumber ")).sendKeys("");
        driver.findElement(By.name("STPIApprovalNumberAndDate ")).sendKeys("bill");
        driver.findElement(By.name("descriptionOfGoods ")).sendKeys("bill");
        driver.findElement(By.name("currency ")).sendKeys("bill");
        driver.findElement(By.name("foreignCurrency ")).sendKeys("bill");
        driver.findElement(By.name("amountSTPIApproval ")).sendKeys("bill");
        driver.findElement(By.name("CIFValueInINR ")).sendKeys("bill");
        driver.findElement(By.name("bondNumber0 ")).sendKeys("bill");
        driver.findElement(By.name("bondDate1 ")).sendKeys("bill");
        driver.findElement(By.name("billOfEntryNumber2 ")).sendKeys("bill");
        driver.findElement(By.name("billOfEntryDate3 ")).sendKeys("bill");
        driver.findElement(By.name("assessableValueInINR4 ")).sendKeys("bill");
        driver.findElement(By.name("dutyExempt5 ")).sendKeys("bill");
        driver.findElement(By.name("twentyFivePercentDF6 ")).sendKeys("bill");
        driver.findElement(By.name("CGApprovedInINR7 ")).sendKeys("bill");
        driver.findElement(By.name("dutyForgone8 ")).sendKeys("bill");
        driver.findElement(By.name("runningBalance9 ")).sendKeys("bill");
        driver.findElement(By.name("outrightPurchase0 ")).sendKeys("bill");
        driver.findElement(By.name("loanBasis1 ")).sendKeys("bill");
        driver.findElement(By.name("freeOfCharge2 ")).sendKeys("bill");
        driver.findElement(By.name("status3 ")).sendKeys("bill");
        driver.findElement(By.name("remarks4 ")).sendKeys("bill");
        driver.findElement(By.name("location ")).sendKeys("bill");
    }
}

