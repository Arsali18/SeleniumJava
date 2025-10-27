package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;

public class TestLocator {
   WebDriver driver;

   @BeforeMethod
    public void setUp(){
       if (driver==null) {
           driver = new FirefoxDriver();
           driver.manage().window().maximize();
           driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
       }

   }

   @Test
    public void locatorTest() throws InterruptedException {
      String label= driver.getTitle();
       System.out.println(label);

       WebElement dropDownElement= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
       Select select = new Select(dropDownElement);

       select.selectByValue("AED");
       System.out.println(select.getOptions().get(2).getText());

       driver.findElement(By.cssSelector("div.paxinfo")).click();

       //increment value
       Thread.sleep(3000);
       //Adult
       for (int i=0; i <= 3; i++){
           driver.findElement(By.id("hrefIncAdt")).click();
       }
       //Child
       for (int i=0; i <= 2; i++){
           driver.findElement(By.id("hrefIncChd")).click();
       }
       //Infant
       for (int i=0; i <= 3; i++){
           driver.findElement(By.cssSelector("span#hrefIncInf")).click();
       }

       driver.findElement(By.xpath("//input[@name='ctl00$mainContent$chk_StudentDiscount']")).click();

       System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
       Thread.sleep(3000);

       driver.findElement(By.cssSelector("input[class='buttonN']")).click();



   }

   @Test //(dependsOnMethods = {"locatorTest"})
   public void destinationFlight() throws InterruptedException {

       //From country
       driver.findElement(By.cssSelector("input[class='select_CTXT']")).click();
       //List Value
       List<WebElement> listOfValue = driver.findElements(By.xpath("//div[@id='dropdownGroup1']//following::div[@class='dropdownDiv']/ul[1]/li"));
       System.out.println("Record: "+ listOfValue.size());



       //Looping all value for get value target
       for (WebElement value : listOfValue){
           //System.out.println(value.getText());
           if (value.getText().equals("Bagdogra (IXB)")){
               value.click();
               break;
           }
       }
       Thread.sleep(2000);
       driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
       Thread.sleep(2000);
       // ⚠️ Harus ambil ulang list-nya (karena yang lama sudah "stale")
       listOfValue = driver.findElements(By.xpath("//div[@id='dropdownGroup1']//following::div[@class='dropdownDiv']/ul[1]/li"));
       for (WebElement value : listOfValue){
           if (value.getText().equalsIgnoreCase("Chennai (MAA)")){
               value.click();
               System.out.println("Select Berhasil");
               break;
           }
       }
       //Arrival Country
       driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));

       List<WebElement> arrivalCountry = driver.findElements(By.xpath("//div[@id='dropdownGroup1']//following::div[@class='dropdownDiv']/ul[2]/li"));


   }

   @AfterClass
    public void tearDown(){
       if (driver != null){
           driver.quit();
       }
   }
}
