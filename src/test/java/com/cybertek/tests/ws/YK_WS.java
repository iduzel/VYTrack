package com.cybertek.tests.ws;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class YK_WS {

    @Test
    public void test1() throws InterruptedException {

        //login
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://qa1.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //login
        Thread.sleep(5000);





        Actions actions= new Actions(driver);

        //finding 'fleet'
        WebElement act = driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[2]"));
        actions.moveToElement(act).perform();

        //list of elements are located under the 'fleet'
        List<WebElement> element = driver.findElements(By.xpath("//div[@id='main-menu']/ul/li[2]//span[@class='title title-level-2']"));

        System.out.println("element.size() = " + element.size());

        for (WebElement webElement : element) {
            //hover all of the elements under 'fleet' one by one
            actions.moveToElement(webElement).perform();
            Thread.sleep(1000);

            //print text of all the elements under 'fleet'
            System.out.println(webElement.getAttribute("innerHTML"));

        }



        for (int i= 0; i< element.size(); i++){
            if (i==2){
                System.out.println(element.get(i).getAttribute("innerHTML"));
                element.get(i).click();

                Thread.sleep(7000);




                // find 'All Vehicle Costs' location
                WebElement AllVehicleCosts = driver.findElement(By.xpath("//div[@id='central-panel']//h1"));
                //print text
                System.out.println(AllVehicleCosts.getText());
                //verify
                Assert.assertEquals(AllVehicleCosts.getText(),"All Vehicle Costs");


                driver.findElement(By.xpath("//button/span[@class='caret']")).click();
                driver.findElement(By.xpath("//div[@class='btn-group open']/ul[@class='dropdown-menu pull-right']/li[4]")).click();
                Thread.sleep(7000);
                driver.findElement(By.xpath("//tbody/tr[94]")).click();

            }





        }










    }
}


