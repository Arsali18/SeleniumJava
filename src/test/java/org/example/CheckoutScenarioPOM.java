package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_factory.pages.CartPage;
import page_factory.pages.CheckoutPage;
import page_factory.pages.DashboardPage;
import page_factory.pages.LoginPage;

public class CheckoutScenarioPOM {

        WebDriver driver;

        @BeforeClass
        public void setUp() {
            // Pastikan ChromeDriver ada di PATH kamu
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }




        @Test
        public void checkoutWithPOM() throws InterruptedException {
            //Driver get URL
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000); // jeda selama 3 detik

            //Do Login
            LoginPage loginPage = new LoginPage(driver);
            loginPage.doLogin("standard_user","secret_sauce");

            Thread.sleep(2000);
            //Add To Cart
            DashboardPage dashboardPage =  new DashboardPage(driver);
            dashboardPage.addToCart();

            //Klik checkout on cart
            CartPage cartPage = new CartPage(driver);
            cartPage.clickCheckout();

            //doCheckout
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.doCheckout("James","Jordi","17554");
            Thread.sleep(2000);

            System.out.println("Checkout Berhasil");




        }
    @AfterClass
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }
    }
