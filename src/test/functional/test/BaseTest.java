package test;

import config.Configuration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import providers.SeleniumProvider;

public class BaseTest {
    SeleniumProvider seleniumProvider;

    @Before
    public void setup() {
        seleniumProvider = new SeleniumProvider();
    }
    
    public LoginPage launchKabbadi() {
        WebDriver driver = seleniumProvider.getDriver();
        driver.get(Configuration.KABBADI_URL);
        return new LoginPage(driver);
    }

    @After
    public void teardown() {
        seleniumProvider.close();
    }

}
