package entity;

import config.Configuration;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import providers.SeleniumProvider;

public class As {
    private SeleniumProvider browser;

    public As(SeleniumProvider browser) {
        this.browser = browser;
    }

    public LoginPage launchKabaddi(){
        WebDriver driver = browser.getDriver();
        driver.get(Configuration.KABBADI_URL);
        return new LoginPage(driver);
    }

}
