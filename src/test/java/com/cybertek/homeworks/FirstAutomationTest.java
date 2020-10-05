package com.cybertek.homeworks;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FirstAutomationTest extends TestBase {

    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

    @Test
    public void firstAutomation() throws InterruptedException {

        extentLogger = report.createTest("FirstAutomationTest");

        LoginPage loginPage = new LoginPage();


        extentLogger.info("Open Chrome");
        extentLogger.info("Go to 'https://vytrack.com/'");
        extentLogger.info("Enter Username: salesmanager140");
        extentLogger.info("Enter password: UserUser123");
        extentLogger.info("Login as a salemanager");
        loginPage.loginAsSalesManager();
        Thread.sleep(1000);



        DashboardPage dashboardPage = new DashboardPage();

        extentLogger.info("Click 'Contacts' under the 'Customers' button");
        dashboardPage.navigateToModule("Customers","Contacts");
        Thread.sleep(1000);

        String expectedEmail = "mbrackstone9@example.com";
        String expectedName = "Mariam Brackstone";
        String expectedPhone = "+18982323434";

        extentLogger.info("Find the person who has this email : mbrackstone9@example.com");
        List<WebElement> element = driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']/td[@*='Email']"));


        WebElement findPerson;
        Thread.sleep(3000);
        extentLogger.info("Click on email");
          for (int i = 0; i < element.size(); i++) {
            if(element.get(i).getText().equals(expectedEmail)){
                findPerson =element.get(i);
                Thread.sleep(2000);


                findPerson.click();

                break;


                }

        }





        String actualName = driver.findElement(By.xpath("//*[@class='user-name']")).getText();
        System.out.println("actualName = " + actualName);
        Thread.sleep(1000);

        String actualEmail= driver.findElement(By.xpath("//*[@*='email']")).getText();
        System.out.println("actualEmail = " + actualEmail);
        Thread.sleep(1000);

        String actualPhone =driver.findElement(By.xpath("//*[@*='phone']")).getText();
        System.out.println("actualPhone = " + actualPhone);
        Thread.sleep(1000);

        extentLogger.info("verify that full name is: Mariam Brackstone");
        Assert.assertEquals(actualName,expectedName);

        extentLogger.info("verify that email is: mbrackstone9@example.com");
        Assert.assertEquals(actualEmail,expectedEmail);

        extentLogger.info("verify that phone number is +18982323434");
        Assert.assertEquals(actualPhone,expectedPhone);

        extentLogger.pass("FirstAutomationTest is Passed");



              

    }


}
