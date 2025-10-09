package page_factory.pages;

import org.openqa.selenium.WebDriver;
import page_factory.object_repository.LoginObjectRepository;

public class LoginPage {

    private LoginObjectRepository loginObjectRepository;

    public LoginPage(WebDriver driver){
        this.loginObjectRepository = new LoginObjectRepository(driver);
    }

    public void doLogin(String username, String password){
        loginObjectRepository.userName.sendKeys(username);
        loginObjectRepository.userPassword.sendKeys(password);
        loginObjectRepository.submitButton.click();
    }
}
