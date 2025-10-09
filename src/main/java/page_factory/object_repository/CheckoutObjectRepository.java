package page_factory.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutObjectRepository {

    @FindBy (id = "first-name")
    public WebElement fistName;

    @FindBy (xpath = "//input[@id='last-name']")
    public WebElement lastName;

    @FindBy (xpath = "//input[@id='postal-code']")
    public WebElement zipCode;

    @FindBy (xpath = "//input[@id='continue']")
    public WebElement continueButton;

    public CheckoutObjectRepository(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


}
