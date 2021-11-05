package Page_Object_Model.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddress {
    private WebDriver driver;

    @FindBy(css = "a[title='Addresses']")
    private WebElement addressSite;

    @FindBy(css = "a[data-link-action='add-address']")
    private WebElement createNewAddress;

    @FindBy(xpath = "//input[@name='alias']")
    private WebElement alias;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement address;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postcode;

    @FindBy(xpath = "//option[@value='17']")
    private WebElement country;

    @FindBy(xpath = "//button[@class='btn btn-primary float-xs-right']")
    private WebElement saveButton;

    public AddNewAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addANewAddress(){
        addressSite.click();
        createNewAddress.click();
        alias.clear();
        alias.sendKeys("Johnny");
        address.clear();
        address.sendKeys("St.Monica Street 1345");
        city.clear();
        city.sendKeys("Leeds");
        postcode.clear();
        postcode.sendKeys("456-98762");
        country.click();
        saveButton.click();
    }
}
