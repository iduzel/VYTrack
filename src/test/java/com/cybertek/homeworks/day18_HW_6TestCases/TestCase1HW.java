package com.cybertek.homeworks.day18_HW_6TestCases;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase1HW  extends TestBase {


    LoginPage loginPage =new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();



    @Test
    public void test1() throws InterruptedException {
        extentLogger = report.createTest("day_18_test1");

        extentLogger.info("signed in as a store manager");
        loginPage.loginAsStoreManager();

        extentLogger.info("navigated to 'Activities' , ' Calendar events'");
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("find the location of 'Options'");
        WebElement actualText =driver.findElement(By.xpath("//div[@*='btn btn-link dropdown-toggle']"));

        extentLogger.info("Verify that page subtitle \"Options\" is displayed");
        Assert.assertTrue(actualText.isDisplayed(),"Verify 'Options' is displayed");

        extentLogger.pass("PASSED");
        Thread.sleep(2000);
    }


    @Test
    public void test2() throws InterruptedException {
        extentLogger = report.createTest("day_18_test2");

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

       @Test
    public void test3() throws InterruptedException {
           loginPage.loginAsStoreManager();
           dashboardPage.navigateToModule("Activities", "Calendar Events");



           Thread.sleep(5000);
           WebElement dropdownElement = driver.findElement(By.xpath("//button[@class='btn dropdown-toggle ']"));
           String s = dropdownElement.getText();
           System.out.println("s = " + s);

           Assert.assertEquals(s,"25","verify per page number is 25");
           Thread.sleep(2000);
       }

       @Test
    public void test4() throws InterruptedException {

        /*Test case #4
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that number of calendar events (rows in
the table) is equals to number of records*/

           loginPage.loginAsStoreManager();
           dashboardPage.navigateToModule("Activities", "Calendar Events");

           int TotalListSize = 0 ;
           Thread.sleep(9000);


           //70 (Total page number) in icinde oldugu texti bul
           WebElement element = driver.findElement(By.cssSelector("label:nth-of-type(2)"));
           String s = element.getText();

           //String'i böl
           String [] arr=s.split(" ");

           //aradan 70 (Total page number) i String olarak cek
           System.out.println(arr[1]);

           //String olan 70 (Total page number) i int'e cevir
           int numberOfPages = Integer.parseInt(arr[1]);
           System.out.println("numberOfPages = " + numberOfPages);




           List<WebElement> list;

           for(int i = 0 ; i<numberOfPages;i++){
               //Tek sayfada listelenen sayiyi bul
               list = driver.findElements(By.xpath("//tbody/tr"));

               //sayfada listelenen sayiyi ekle
               TotalListSize+= list.size();

               //Sayfayi ilerletmek icin 'page'e tikla
               WebElement pageClick = driver.findElement(By.xpath("//i[@class='fa-chevron-right hide-text']"));
               pageClick.click();
               Thread.sleep(2000);

           }

           System.out.println("TotalListSize = " + TotalListSize);




           //'Total of record' in gectigi texti bul
           WebElement findTheTotal = driver.findElement(By.xpath("//*[contains(text(),'Total of')]"));
           String totalTextNumber = findTheTotal.getText();
           System.out.println("totalTextNumber = " + totalTextNumber);

           //texti böl
           String [] arr2 = totalTextNumber.split(" ");
           //rakamin kacinci String'te oldugunu bul
           for (String str: arr2 ) {
               System.out.println("str = " + str);

           }

           //Rakami String'ten int'e cevir
           int TotalNumber = Integer.parseInt(arr2[2]);

           System.out.println("TotalNumber = " + TotalNumber);
           System.out.println("TotalListSize = " + TotalListSize);
           Assert.assertEquals(TotalNumber,TotalListSize, "Verify that number of calendar events (rows in\n" +
                   "the table) is equals to number of records ");

           Thread.sleep(2000);
       }

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

        Thread.sleep(2000);
        System.out.println("-------");
    }

    @Test
    public void test6() throws InterruptedException {

           loginPage.loginAsStoreManager();
           dashboardPage.navigateToModule("Activities", "Calendar Events");

           driver.findElement(By.xpath("//*[text()='Testers meeting']")).click();
           Thread.sleep(1000);

           WebElement element = driver.findElement(By.xpath("//div[@class='section-content']"));
           Assert.assertTrue(element.isDisplayed());

           }



       }




