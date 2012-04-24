package providers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumProvider {

    private static WebDriver driver;

    public SeleniumProvider() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void close() {
        try {
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error closing selenium session." + e.getMessage(), e);
        }
    }
}
