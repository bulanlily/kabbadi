package test;


import org.junit.Test;

public class LoginTest extends BaseTest{
	@Test
	public void testLoginWithValidUserCredentials() {
		launchKabbadi()
        .loginWithValidCredentials();
		}
    
    @Test
    public void testReturningToKabbadiDoesNotNeedLogin() {
        launchKabbadi()
        .loginWithValidCredentials()
        .goToGoogle()
        .returnToKabbadi();
    }
}
