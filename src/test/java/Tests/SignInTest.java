package Tests;

import Page_Object_Model.webpages.HomePage;
import Page_Object_Model.webpages.SignInPage;
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
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testSignInWithValidCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        SignInPage signInPage = new SignInPage(driver);

        Assert.assertTrue(signInPage.isPageOpened());
        signInPage.signIn("brodie1@freeallapp.com", "qwerty1234");

        Assert.assertEquals("John Smith", homePage.getNameOfLoggedUser());
    }

    @Test
    public void testSignInWithInvalidPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("brodie1@freeallapp.com", "wrongPass");

        Assert.assertTrue(signInPage.errorMessageIsVisible());
    }

    @Test
    public void testSignInWithInvalidEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn("wrongEmail@gmail.com", "qwerty1234");

        Assert.assertTrue(signInPage.errorMessageIsVisible());
    }
}
