package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase {
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
        WebElement cadtButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        cadtButton.click();

        //klik cart button
        WebElement cartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartButton.click();

        Thread.sleep(2000); // jeda selama 2 detik


        //Klik button checkout
        WebElement checkoutBTN = driver.findElement(By.name("checkout"));
        checkoutBTN.click();

        //input firstname
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Arsali");

        //input last name
        WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastName.sendKeys("Ali");

        //input ZIP
        WebElement zipField = driver.findElement(By.xpath("//input[@id='postal-code']"));
        zipField.sendKeys("Bojong belung");

        //Klik button Continue
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton.click();

        //Klik button finish
        WebElement finishButton = driver.findElement(By.xpath("//button[@id='finish']"));
        finishButton.click();

        Thread.sleep(4000); // jeda selama 4 detik
        }

    @AfterClass
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }

    }





