package pages;

import config.Configuration;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);

        assertThat(driver.getTitle(), equalTo("Home Page | Kabbadi"));
    }


}
