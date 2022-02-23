package com.KK.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseLibrary {
    public static WebDriver driver;
    @BeforeMethod
    @Parameters({"browser","url"})
    public void setUp(String browser, String baseUrl){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");
            driver=new ChromeDriver();
            Reporter.log("Chrome launched", true);
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","-------");
            driver=new FirefoxDriver();
            Reporter.log("Firefox launched", true);
        }
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @AfterClass
    public  void tearDown(){

    }
    @AfterMethod
    public void afterCondition(ITestResult result){
        if(result.isSuccess()){
            Reporter.log("Script is passed  :) ", true);
            String methodName=result.getMethod().getMethodName();
            ScreenshotLibrary sl=new ScreenshotLibrary(driver);
            sl.takeScreenshot(methodName);
            Reporter.log(" Passed Screenshot has been taken ... ",true);
        }
        else {
            Reporter.log("Script is failed  :( ",true);
            String methodName=result.getMethod().getMethodName();
            ScreenshotLibrary sl=new ScreenshotLibrary(driver);
            sl.takeScreenshot(methodName);
            Reporter.log("Screenshot has been taken ... ",true);
        }
        //driver.close();
        //Reporter.log("browser closed .. ",true);
    }

}
