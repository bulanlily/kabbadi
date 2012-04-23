package pages;

import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);

        assertThat(driver.getTitle(), equalTo("List Invoices | Kabbadi"));
    }


}
