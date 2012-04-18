package test;


import entity.As;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import providers.SeleniumProvider;

public class LoginTest {
    SeleniumProvider browser;
    
    @Before
    public void setUp() {
        browser = new SeleniumProvider();
    }

	@Test
	public void testLoginWithValidUserCredentials() {
		With(browser)
        .launchKabaddi()
        .enterValidUserCredentials();
		}

    private As With(SeleniumProvider browser) {
        return new As(browser);
    }

    @After
    public void tearDown() {
        browser.close();
    }
}
