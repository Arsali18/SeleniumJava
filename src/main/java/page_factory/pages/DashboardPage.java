package page_factory.pages;

import org.openqa.selenium.WebDriver;
import page_factory.object_repository.DashboarObjectRepository;

public class DashboardPage {
    private DashboarObjectRepository dashboarObjectRepository;

    public DashboardPage(WebDriver driver){
        this.dashboarObjectRepository = new DashboarObjectRepository(driver);
    }

    public void addToCart(){
        dashboarObjectRepository.buttonAddCart.click();
        dashboarObjectRepository.buttonCart.click();
    }
}
