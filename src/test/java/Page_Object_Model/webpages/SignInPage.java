package Page_Object_Model.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    @FindBy(xpath = "//h1")
    private WebElement homePage;

    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@data-action='show-password']")
    private WebElement showPassword;

    @FindBy(xpath = "//button[@id='submit-login']")
    private WebElement submitButton;

    @FindBy(xpath = "//li[@class='alert alert-danger']")
    private WebElement signInError;

        public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        public void fillLoginUserData(String email, String password) {
            emailInput.sendKeys(email);
            passwordInput.sendKeys(password);
            showPassword.click();
            submitButton.click();
    }

        public boolean errorMessageIsVisible() {
        return signInError.isDisplayed();
    }
}
