package pages;

import forms.AssetForm;
import forms.InvoiceForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AddAssetPage extends BasePage {
    public AddAssetPage(WebDriver driver) {
        super(driver);
    }

    public ListISInvoicesPage submit(AssetForm assetForm) {
        fillFormWithAndSubmit(assetForm);
        return new ListISInvoicesPage(driver);
    }

    private void fillFormWithAndSubmit(AssetForm assetForm) {
        Map<String, Object> fields = assetForm.getFields();
        for (String fieldName : fields.keySet()) {
            fillFieldWith(fieldName, fields.get(fieldName) + "");
        }
        driver.findElement(By.cssSelector("input[name=submit]")).click();
    }

    public void fillFieldWith(String fieldName, String fieldValue) {
        driver.findElement(By.cssSelector("input[name=" + fieldName + "]")).sendKeys(fieldValue);
    }
}
