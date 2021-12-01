package Tests;

import Page_Object_Model.webpages.BuyItems;
import Page_Object_Model.webpages.HomePage;
import Page_Object_Model.webpages.SignInPage;
import common.Utils;
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
        driver = Utils.setUpDriver();
    }

    @Test
    public void SignInBuyItemAndDeleteFromCart() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);
        BuyItems buyItems = new BuyItems(driver);

        homePage.clickSignInButton();
        signInPage.fillLoginUserData("brodie1@freeallapp.com", "qwerty12345");
        buyItems.buyAccessoriesItemAndDelete();
    }
    @Test
    public void SignInBuyItemsAndPay() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);
        BuyItems buyItems = new BuyItems(driver);

        homePage.clickSignInButton();
        signInPage.fillLoginUserData("brodie1@freeallapp.com", "qwerty12345");
        buyItems.buyArtItemAndPaymentCheckout();
    }
}
