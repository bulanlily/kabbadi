package test;

import config.Configuration;
import db.TestInvoiceRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pages.LoginPage;
import providers.SeleniumProvider;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
public abstract class BaseTest {

    SeleniumProvider seleniumProvider;

    @Autowired
    private TestInvoiceRepository invoiceRepository;

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

    @Before
    @After
    public void deleteInvoices() {
         invoiceRepository.deleteAll();
    }



}
