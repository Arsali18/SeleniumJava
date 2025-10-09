package page_factory.pages;

import org.openqa.selenium.WebDriver;
import page_factory.object_repository.CartRepository;

public class CartPage {
    private CartRepository cartRepository;

    public  CartPage(WebDriver driver){
        this.cartRepository = new CartRepository(driver);
    }

    public void clickCheckout(){
        cartRepository.buttonCheckout.click();
    }
}
