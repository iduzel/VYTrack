package com.cybertek.tests.ws;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebtableWS {
    WebDriver driver;
    @Test
    public void testWebtables(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));

        System.out.println(table.getText());
    }
}
