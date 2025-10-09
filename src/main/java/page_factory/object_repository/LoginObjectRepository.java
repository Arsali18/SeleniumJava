package page_factory.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjectRepository {

    //defind web element  using @findBy annotation

    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement userPassword;

    @FindBy(className = "submit-button")
    public WebElement submitButton;

    public LoginObjectRepository(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
