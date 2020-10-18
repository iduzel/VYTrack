package com.cybertek.homeworks.day18_HW_6TestCases;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends TestBase {

    LoginPage loginPage =new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void test2() throws InterruptedException {
        extentLogger = report.createTest("day_18_test1");

        extentLogger.info("signed in as a store manager");
        loginPage.loginAsStoreManager();

        extentLogger.info("navigated to 'Activities' , ' Calendar events'");
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("find the location of 'perPage'");
        WebElement number = driver.findElement(By.xpath("//*[@*='number']")) ;
        String findNumber = number.getAttribute("value");

        extentLogger.info("Verify that perPage \"1\" is displayed");
        Assert.assertEquals(findNumber,"1","verify the number is '1' ");
        extentLogger.pass("PASSED");
        Thread.sleep(2000);
    }

}
