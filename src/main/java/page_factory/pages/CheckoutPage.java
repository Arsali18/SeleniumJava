package page_factory.pages;

import org.openqa.selenium.WebDriver;
import page_factory.object_repository.CheckoutObjectRepository;
import page_factory.object_repository.DashboarObjectRepository;

public class CheckoutPage {

    private CheckoutObjectRepository checkoutObjectRepository;

    public CheckoutPage(WebDriver driver){
        this.checkoutObjectRepository = new CheckoutObjectRepository(driver);
    }

    public void doCheckout(String firstName,String lastName,  String zipCode){
        checkoutObjectRepository.fistName.sendKeys(firstName);
        checkoutObjectRepository.lastName.sendKeys(lastName);
        checkoutObjectRepository.zipCode.sendKeys(zipCode);
        checkoutObjectRepository.continueButton.click();

    }
}
