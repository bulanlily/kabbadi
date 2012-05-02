package pages;

import forms.AssetForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

public class ViewAssetDetailsPage extends BasePage {
    public ViewAssetDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ViewAssetDetailsPage verifyIfAssetDataIsOnTable(AssetForm asset) {
        WebElement table = driver.findElement(By.cssSelector("table"));

        Map<String, Object> fields = asset.getFields();
        String tableText = table.getText();

        for (Object value : fields.values()) {
            assertThat(tableText, containsString(value + ""));
        }

        return this;
    }
}
