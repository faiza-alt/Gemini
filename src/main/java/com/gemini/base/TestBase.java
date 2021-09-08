package com.gemini.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;;
import java.util.concurrent.TimeUnit;

public class TestBase {

   public static WebDriver driver;

        //Launch the browser and navigate to the registration page
    public void navigateToRegistrationPage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        String URL="https://exchange.sandbox.gemini.com/signin?redirect=56164ca5f83d11575cdb4138df6532b3a4045a24-1630945223697-%2F";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);


        //Verify The page
        String expectedPageTitle = "[Sandbox] Gemini - Sign In";
        Assert.assertTrue(driver.getTitle().contains(expectedPageTitle), "Test Failed");

        //Click on "Create an account" link
        WebElement create_new_account = driver.findElement(By.linkText("Create new account"));
        create_new_account.click();
        Assert.assertEquals(driver.getTitle(),"[Sandbox] Gemini - Register");
        driver.findElement(By.xpath("//div/a[text()='OK']")).click();

        //scroll the page and Click on "Create a business account" link
        WebElement createBusinessAccountLink = driver.findElement(By.linkText("Create a business account"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", createBusinessAccountLink);
        Thread.sleep(3000);
        createBusinessAccountLink.click();
    }




    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
