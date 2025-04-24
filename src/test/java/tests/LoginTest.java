package tests;

import framework.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify valid login with correct credentials", retryAnalyzer = framework.utils.RetryAnalyzer.class)
    public void testValidLogin() {
        page.navigate("https://www.facebook.com/");
        page.fill("#email", "user");
        page.fill("#pass", "pass");
        page.locator("xpath=//button[@name='login']").click();
        Assert.assertTrue(page.isVisible("#logout"), "Logout button is not visible. Login might have failed.");
    }
}
