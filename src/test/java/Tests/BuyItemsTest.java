package Tests;

import Page_Object_Model.webpages.BuyItems;
import Page_Object_Model.webpages.HomePage;
import Page_Object_Model.webpages.SignInPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BuyItemsTest {
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
    public void SignInBuyItemAndDeleteFromCart() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        SignInPage signInPage = new SignInPage(driver);

        Assert.assertTrue(signInPage.isPageOpened());
        signInPage.signIn("brodie1@freeallapp.com", "qwerty1234");

        BuyItems buyItems = new BuyItems(driver);
        buyItems.buyAccessoriesItemAndDelete();
    }
    @Test
    public void SignInBuyItemsAndPay() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        SignInPage signInPage = new SignInPage(driver);

        Assert.assertTrue(signInPage.isPageOpened());
        signInPage.signIn("brodie1@freeallapp.com", "qwerty1234");


        BuyItems buyItems = new BuyItems(driver);
        buyItems.buyArtItemAndPaymentCheckout();
    }
}
