package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FinalTaskScenario {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.agoda.com/?site_id=1922884&tag=6da0c587-ac74-45f1-9a0a-d908d27c6f8d&gad_source=1&gad_campaignid=21045292504&gbraid=0AAAAAD-GdVkOeKroe31iEjnPGiZ3JDmUi&device=c&network=g&adid=695824194136&rand=391454384237080061&aud=kwd-2230651387&gclid=CjwKCAjwu9fHBhAWEiwAzGRC_1hCSkgsQYvIiNMZIrM8zjGg2NL8NUIf-99SqiJpsIL8Z6dokc5n0xoCn5sQAvD_BwE&pslc=1&ds=iZIjODRAsaaSgA6i");
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
    }

    @Test
    public void arrageDeparture()throws InterruptedException {
        // Klik tab flight
        WebElement btnFlights = wait.until(ExpectedConditions.elementToBeClickable(By.id("tab-flight-tab")));
        btnFlights.click();

        // Klik field "Flying from"
        WebElement fieldFlyingFrom = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'AutocompleteSearch__IconBox')]")
        ));
        fieldFlyingFrom.click();

        // Tunggu sampai box input pencarian muncul dan ketik “Jakarta”
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@class,'SearchBoxTextEditor')]")
        ));
        searchBox.sendKeys("Jakarta");

        // Tunggu sampai suggestion muncul
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='autocompleteSearch-origin']//li[contains(@class,'Suggestion')]")
        ));

        // Ambil semua hasil suggestion
        List<WebElement> airportList = driver.findElements(
                By.xpath("//div[@id='autocompleteSearch-origin']//li[contains(@class,'Suggestion')]")
        );

        System.out.println("Jumlah hasil ditemukan: " + airportList.size());

        // Loop semua hasil dan klik sesuai teks
        for (WebElement airport : airportList) {
            String airportName = airport.getText();
           // System.out.println("Ditemukan: " + airportName);

            if (airportName.contains("Soekarno-Hatta International Airport")) {
                wait.until(ExpectedConditions.elementToBeClickable(airport)).click();
                //System.out.println(">> Klik pada: " + airportName);
                break;
            }
        }

        //klik field Arrival
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("Box-sc-kv6pi1-0")
        ));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Flying to']"))).sendKeys("Singapore");
        // Tunggu sampai suggestion muncul
        Thread.sleep(2000);
        List<WebElement> destinationList = driver.findElements(
                By.xpath("//div[@id='autocompleteSearch-destination']//li")
        );

        // Loop semua hasil dan klik sesuai teks
        for (WebElement airportDest : destinationList) {
            String destinationName = airportDest.getText();
             //System.out.println("Ditemukan: " + destinationName);

            if (destinationName.contains("Changi Airport")) {
                wait.until(ExpectedConditions.elementToBeClickable(airportDest)).click();
                System.out.println(">> Klik pada: " + destinationName);
                break;
            }
        }

//        destinationList.stream()
//                .filter(el -> el.getText().contains("Changi Airport"))
//                .findFirst()
//                .ifPresent(el -> {
//                    wait.until(ExpectedConditions.elementToBeClickable(el)).click();
//                    System.out.println(">> Klik pada: " + el.getText());
//                });
        Thread.sleep(1000);

        //Set tanggal
        WebElement fromDate = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[@data-selenium-date='2025-10-29']")
                )
        );

        fromDate.click();

        Thread.sleep(1000);

        //increase adult
//       WebElement plussBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-element-name='flight-occupancy-adult-increase']")));
//       for (int i = 0; i <=1; i ++){
//           plussBtn.click();
//       }

       //close dropdown occupansy
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-occupancy"))).click();

       //Klik button search
        driver.findElement(By.cssSelector("button[data-test='SearchButtonBox']")).click();

        Thread.sleep(5000);
        By airlinesSection = By.xpath("//div[@data-component='flight-filter-item-airline']");
        wait.until(ExpectedConditions.presenceOfElementLocated(airlinesSection));
        //klik check box air asia
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@data-element-value='AirAsia']"))).click();


        Thread.sleep(3000);
        //Klik Cheapest
        driver.findElement(By.xpath("//button[contains(@data-testid,'flights-quick-sort-item-Price-button')]")).click();

        //variable nominal
        String hargaTiket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='sc-dmqHEX Typographystyled__TypographyStyled-sc-1uoovui-0 czWcZb gPcWqz']"))).getText();
        //click card
        WebElement maskapaiCard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-testid='flight-infinite-scroll']//div[@class='GridItem__GridItemStyled-sc-3btv1u-0 fXrNCt'])[1]")));
        maskapaiCard.click();
        Thread.sleep(4000);


        //click Select
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-component='flight-card-bookButton']"))).click();
        Thread.sleep(4000);


        //Validasi maskapai
        String maskapai = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='AirAsia']"))).getText();
        Assert.assertEquals(maskapai,"AirAsia","Maskapai Tidak sesuai");
        System.out.println("Maskapai sesuai");

        //Validasi Harga
        String contactDetailPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@data-component='mob-price-desc-text'])[7]"))).getText();
        Assert.assertTrue(contactDetailPrice.contains(hargaTiket), "Harga sesuai");
        System.out.println("Nominal sesuai");
            

        //inputan Contact Details
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact.contactFirstName"))).sendKeys("Ali");
//        driver.findElement(By.id("contact.contactLastName")).sendKeys("Arsali");
//        driver.findElement(By.id("contact.contactEmail")).sendKeys("Arsali@gmail.com");
//        driver.findElement(By.xpath("//button[@aria-haspopup='listbox']")).click();
//
//        String option = driver.findElement(By.xpath("//div[@data-testid='portal']//ul[@role='listbox']/li[5]")).getText();
//        System.out.println("ini option: "+option);


        Thread.sleep(4000);
    }




    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
