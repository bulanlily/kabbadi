package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

    public LoginPage enterValidUserCredentials() {
        driver.findElement(By.id("username")).sendKeys("bill");
        driver.findElement(By.id("password")).sendKeys("bill");
        return this;
    }
}

