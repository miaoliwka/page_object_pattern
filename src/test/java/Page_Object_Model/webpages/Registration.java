package Page_Object_Model.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
    private WebDriver driver;

    @FindBy(xpath = "//a[@data-link-action='display-register-form']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//input[@name='id_gender' and @value='1']")
    private WebElement mrCheckbox;

    @FindBy(xpath = "//input[@name='id_gender' and @value='1']")
    private WebElement mrsCheckbox;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[@class='form-control' and @name='email' and @type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@data-action='show-password']")
    private WebElement showPassword;

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthday;

    @FindBy(xpath = "//input[@name='optin']")
    private WebElement receiveOffersCheckbox;

    @FindBy(xpath = "//input[@name='newsletter']")
    private WebElement newsletterCheckbox;

    @FindBy(xpath = "//button[@data-link-action='save-customer']")
    private WebElement saveButton;

    public Registration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillUserRegisterData(
            String firstName,
            String lastName,
            String email,
            String password) {

        createAccountButton.click();
        mrsCheckbox.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        showPassword.click();
        birthday.sendKeys("04/08/1981");

        if(!receiveOffersCheckbox.isSelected())
            receiveOffersCheckbox.click();

        if(!newsletterCheckbox.isSelected())
            newsletterCheckbox.click();

        saveButton.click();
    }
}
