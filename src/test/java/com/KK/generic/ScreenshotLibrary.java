package com.KK.generic;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




import java.io.File;
import java.io.IOException;

public class ScreenshotLibrary {
    WebDriver driver;
    public ScreenshotLibrary(WebDriver driver){
        this.driver=driver;
    }
    public void takeScreenshot(String methodname){
        TakesScreenshot ts= (TakesScreenshot)driver;
        File src= ts.getScreenshotAs(OutputType.FILE);
                File dest= new File("/KaliKartel/screenshots/"+methodname+".png");
        try {
            FileUtils.copyFile(src,dest);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
