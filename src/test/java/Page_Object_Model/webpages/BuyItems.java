package Page_Object_Model.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyItems {
    private WebDriver driver;

    @FindBy(xpath = "//li[@id='category-6']")
    private WebElement accessoriesButton;

    @FindBy(xpath = "//img[@alt='Mountain fox cushion']")
    private WebElement MountainFoxCushionPillow;

    @FindBy(xpath = "//input[@class='input-color' and @value='11']")
    private WebElement BlackColorOfPillow;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//a[@data-link-action='delete-from-cart']")
    private WebElement deleteFromCartButton;

    @FindBy(xpath = "//li[@id='category-9']")
    private WebElement artButton;

    @FindBy(xpath = "//img[@alt='Brown bear - Vector graphics']")
    private WebElement BrownBearGraphic;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement clickAddToCartButton;

    @FindBy(xpath = "//button[@name='confirm-addresses']")
    private WebElement clickContinueAddress;

    @FindBy(xpath = "//input[@id='payment-option-1']")
    private WebElement clickPayByCheckButton;

    @FindBy(xpath = "//input[@name='conditions_to_approve[terms-and-conditions]']")
    private WebElement checkTermsAndConditions;

    @FindBy(xpath = "//button[@class='btn btn-primary center-block']")
    private WebElement orderWithObligatoryToPay;

    public BuyItems(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void buyAccessoriesItemAndDelete(){
        accessoriesButton.click();
        MountainFoxCushionPillow.click();
        BlackColorOfPillow.click();
        addToCartButton.click();
        proceedToCheckoutButton.click();
        deleteFromCartButton.click();
    }
    public void buyArtItemAndPaymentCheckout(){
        artButton.click();
        BrownBearGraphic.click();
        clickAddToCartButton.click();
        proceedToCheckoutButton.click();
        proceedToCheckoutButton.click();
        clickContinueAddress.click();

        if(!clickPayByCheckButton.isSelected())
            clickPayByCheckButton.click();

        if(!checkTermsAndConditions.isSelected())
            checkTermsAndConditions.click();

        orderWithObligatoryToPay.click();

    }
}