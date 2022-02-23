package com.KK.pageobjects;

import com.KK.generic.WebDriverCommonLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;
    WebDriverCommonLibrary wcl= new WebDriverCommonLibrary(driver);
    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }
    @FindBy(xpath = "//input[@title='Search']")
    private WebElement SearchBox;

    public void enterSearchText(String SearchText){
        wcl.enterData(SearchBox, SearchText);
    }
}
