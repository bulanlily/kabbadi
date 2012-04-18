package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
        assertThat(driver.getTitle(), equalTo("CAS – Central Authentication Service"));
	}

    public HomePage loginWithValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("bill");
        driver.findElement(By.id("password")).sendKeys("bill");
        driver.findElement(By.name("submit")).click();
        return new HomePage(driver);
    }

    public LoginPage loginWithInvalidCredentials() {
        driver.findElement(By.id("username")).sendKeys("bill");
        driver.findElement(By.id("password")).sendKeys("not bill");
        driver.findElement(By.name("submit")).click();
        return new LoginPage(driver);
    }
}

