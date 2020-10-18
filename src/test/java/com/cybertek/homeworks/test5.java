package com.cybertek.homeworks;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class test5 extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();



    @Test
    public void test5() throws InterruptedException {
        //Test case #5
        // 1.Go to “https://qa1.vytrack.com/"
        // 2.Login as a store manager
        // 3.Navigate to “Activities -> Calendar Events”
        //4.Click on the top checkbox to select all
        // 5.Verify that all calendar events were selected

        loginPage.loginAsStoreManager();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        WebElement checkbox = driver.findElement(By.cssSelector("button>input[type='checkbox']"));
        checkbox.click();

        Assert.assertTrue(checkbox.isSelected());
        Thread.sleep(1000);

//           // WebElement page1 = driver.findElement(By.xpath("//input[@tabindex='-1']"));
//            List<WebElement> page1rows1column = driver.findElements(By.xpath("//input[@tabindex='-1']"));
//
//            for (WebElement element : page1rows1column) {
//                Assert.assertTrue(element.isSelected());
//                Thread.sleep(500);
//            }

        //find the text include "Total Page number" (70)
        WebElement element = driver.findElement(By.cssSelector("label:nth-of-type(2)"));
        String s = element.getText();

        //dvide by String
        String [] arr=s.split(" ");

        //pull it 70 as a String
        System.out.println(arr[1]);

        //adjust as a intiger 70
        int numberOfPages = Integer.parseInt(arr[1]);

        List<WebElement> list;
        for(int i = 0 ; i<numberOfPages;i++){
            //find, how many element in one page

            list = driver.findElements(By.xpath("//input[@tabindex='-1']"));
            //add number of element in page
            //Assert.assertTrue(list.get(i).isSelected());
            Thread.sleep(500);
            for(int j=0; j<list.size(); j++){

                Assert.assertTrue(list.get(j).isSelected());

            }

            WebElement pageClick = driver.findElement(By.xpath("//i[@class='fa-chevron-right hide-text']"));
            pageClick.click();
            Thread.sleep(2000);

        }

    }


}