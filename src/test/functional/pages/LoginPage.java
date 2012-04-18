package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}

    public HalloBillPage loginWithValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("bill");
        driver.findElement(By.id("password")).sendKeys("bill");
        return returnToKabbadi();
    }

    public LoginPage loginWithInvalidCredentials() {
        driver.findElement(By.id("username")).sendKeys("bill");
        driver.findElement(By.id("password")).sendKeys("not bill");
        return this;
    }
}

