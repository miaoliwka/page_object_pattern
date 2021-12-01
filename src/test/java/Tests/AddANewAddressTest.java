package Tests;

import Page_Object_Model.webpages.AddANewAddress;
import Page_Object_Model.webpages.HomePage;
import Page_Object_Model.webpages.SignInPage;
import common.Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AddANewAddressTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = Utils.setUpDriver();
    }

    @Test
    public void AddANewAddress() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);
        AddANewAddress addNewAddress = new AddANewAddress(driver);

        homePage.clickSignInButton();
        signInPage.fillLoginUserData("brodie1@freeallapp.com", "qwerty12345");
        addNewAddress.addANewAddress();

        Assert.assertTrue(addNewAddress.successAlertIsVisible());
    }
}
