package Tests;

import Page_Object_Model.webpages.HomePage;
import Page_Object_Model.webpages.Registration;
import common.Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegistrationTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = Utils.setUpDriver();
    }

    @Test
    public void RegistrationANewUser(){
        String email = Utils.generateEmail();
        String firstName = "Alice";
        String lastName = "Smith";
        String password = "qwerty";

        HomePage homePage = new HomePage(driver);
        Registration registration = new Registration(driver);

        homePage.clickSignInButton();
        registration.fillUserRegisterData(firstName, lastName, email, password);

        Assert.assertEquals("Alice Smith", homePage.getNameOfLoggedUser());
    }
}
