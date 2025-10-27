package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelector {


    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Pastikan ChromeDriver ada di PATH kamu
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void endToEndTest() throws InterruptedException {

        //Driver get URL
        driver.get("https://www.saucedemo.com/");

        //Input field Username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        //Input field password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("secret_sauce");

        //Klik button Login
        WebElement loginButton = driver.findElement(By.className("submit-button"));
        loginButton.click();

        Thread.sleep(4000); // jeda selama 4 detik

        //find label
        WebElement label = driver.findElement(By.xpath("//span[@class='title']"));
        System.out.println("Title halaman: " + label);

        Thread.sleep(2000); // jeda selama 3 detik

        //Klik add to cart
        // WebElement cadtButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        //cadtButton.click();

        // Ambil container utama (yang berisi semua produk)
        WebElement container = driver.findElement((By.className("inventory_list")) );

        // Ambil semua produk di dalam container
        List<WebElement> listProduk = container.findElements((By.className("inventory_item")));

        // Loop setiap produk dan tampilkan namanya
        for (WebElement produk : listProduk){
            String namaProduk = produk.findElement(By.xpath(".//div[@class='inventory_item_name ']")).getText();
            if (namaProduk.equalsIgnoreCase("Sauce Labs Bolt T-Shirt")){
                produk.findElement(By.xpath(".//button[contains(text(),'Add to cart')]")).click();
                System.out.println("Berhasil klik Add to cart untuk: " + namaProduk);
                break;
            }

            //System.out.println("Nama Product: "+namaProduk);
        }

        Thread.sleep(2000);


    }
}
