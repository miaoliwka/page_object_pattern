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
    private WebElement userEmail;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='submit-login']")
    private WebElement submitButton;

    @FindBy(xpath = "//li[@class='alert alert-danger']")
    private WebElement signInError;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserEmail(String usersEmail) {
        userEmail.clear();
        userEmail.sendKeys(usersEmail);
    }
    public void setUserPassword(String userPassword) {
        password.clear();
        password.sendKeys(userPassword);
        }

        public void signIn(String usersEmail, String password) {
        if (isPageOpened()) {
            setUserEmail(usersEmail);
            setUserPassword(password);
            clickOnSubmit();
        }
        }
        public boolean isPageOpened(){
        return homePage.getText().contains("Log in to your account");
        }

        public void clickOnSubmit() {
        submitButton.click();
    }
        public boolean errorMessageIsVisible() {
        return signInError.isDisplayed();
        }
}
