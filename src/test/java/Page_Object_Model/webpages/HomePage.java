package Page_Object_Model.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static String pageOfStore = "https://mystore-testlab.coderslab.pl/index.php";
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='user-info']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@title='View my customer account']")
    private WebElement userNickname;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(pageOfStore);
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
    public String getNameOfLoggedUser() {
        return userNickname.getText();
    }
}
