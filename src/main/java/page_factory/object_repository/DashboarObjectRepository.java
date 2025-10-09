package page_factory.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboarObjectRepository {

    //defind web element using @findby annotation

    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    public WebElement buttonAddCart;

    @FindBy (xpath = "//a[@class='shopping_cart_link']")
    public WebElement buttonCart;

    public DashboarObjectRepository(WebDriver driver){
        PageFactory.initElements(driver,this);
    }




}
