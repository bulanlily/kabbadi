package pages;

import config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasePage{
	protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage goToGoogle() {
        driver.get("http://www.google.com");
        return new BasePage(driver);
    }

    public ListInvoicePage returnToKabbadi() {
        driver.get(Configuration.KABBADI_URL);
        return new ListInvoicePage(driver);
    }

    public boolean idExists(String id) {
        try {
            driver.findElement(By.id(id));
        }
        catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public String getTitle(){
        return  driver.getTitle();
    }
}
