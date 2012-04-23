package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        assertThat(driver.getTitle(), equalTo("Home Page | Kabbadi"));
    }

    public AdminAddInvoicePage goToAdminAddInvoicePage() {
        assertThat(driver.getTitle(), containsString("Admin"));
        assertThat(driver.getTitle(), containsString("Add Invoice"));
        driver.findElement(By.name("Add New")).click();
        return new AdminAddInvoicePage(driver);
    }


   
}
