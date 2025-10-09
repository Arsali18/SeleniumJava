package page_factory.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartRepository {

    @FindBy(name = "checkout")
    public WebElement buttonCheckout;

    public CartRepository(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
