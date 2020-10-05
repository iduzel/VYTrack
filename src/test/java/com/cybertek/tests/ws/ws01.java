package com.cybertek.tests.ws;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ws01 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //click Click For JS Alert Button
        driver.findElement(By.xpath("//button[1]")).click();

        //switch to JS alert pop up
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();


        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss();


        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);
        alert.sendKeys("Accepted");
        alert.accept();
    }
}
