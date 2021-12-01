package Tests;

import Page_Object_Model.webpages.HomePage;
import Page_Object_Model.webpages.SignInPage;
import common.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignInTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = Utils.setUpDriver();
    }

    @Test
    public void testSignInWithValidCredentials() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        homePage.clickSignInButton();
        signInPage.fillLoginUserData("brodie1@freeallapp.com", "qwerty12345");

        Assert.assertEquals("John Smith", homePage.getNameOfLoggedUser());
    }

    @Test
    public void testSignInWithInvalidPassword() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        homePage.clickSignInButton();
        signInPage.fillLoginUserData("brodie1@freeallapp.com", "wrongPass");

        Assert.assertTrue(signInPage.errorMessageIsVisible());
    }

    @Test
    public void testSignInWithInvalidEmail() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        homePage.clickSignInButton();
        signInPage.fillLoginUserData("wrongEmail@gmail.com", "qwerty12345");

        Assert.assertTrue(signInPage.errorMessageIsVisible());
    }
}
