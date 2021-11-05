package Tests;

import Page_Object_Model.webpages.AddNewAddress;
import Page_Object_Model.webpages.HomePage;
import Page_Object_Model.webpages.SignInPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddNewAddressTest {
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
    public void AddANewAddress() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();

        SignInPage signInPage = new SignInPage(driver);

        Assert.assertTrue(signInPage.isPageOpened());
        signInPage.signIn("brodie1@freeallapp.com", "qwerty1234");

        AddNewAddress addNewAddress = new AddNewAddress(driver);
        addNewAddress.addANewAddress();
    }
}
