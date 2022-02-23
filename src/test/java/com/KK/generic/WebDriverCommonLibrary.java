package com.KK.generic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebDriverCommonLibrary {
    WebDriver driver;
    public WebDriverCommonLibrary(WebDriver driver){
        this.driver=driver;
    }

    // To enter data
    public  void enterData(WebElement textBox, String value){
        textBox.clear();
        textBox.sendKeys(value);
    }

    // To check checkbox
    public  void  clickCheckBox(WebElement checkBox){
        if (checkBox.isSelected()){
            Reporter.log("Checkbox is already selected", true);
        }else {
            checkBox.click();
        }
    }

    //To select by visible text
    public void selectOptionText(WebElement dropdown, String optionText){
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
    }

    //to handle mouse hover
    public  void mouseOver(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // to explicit wait
    public  void explicitWaitforVisible(int seconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //to scroll by View
    public void scrollView(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    //to scrolldown
    public void scrollDown(int scrollHeight){
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,"+scrollHeight+")");

    }
    // hard code wait
    public  void hardCodeWait(int secs){
        try{
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  void switchToJSPopUpAndAccept(WebDriver driver){
        Alert alert =driver.switchTo().alert();
        alert.accept();
    }
}
