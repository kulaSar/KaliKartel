package com.KK.testScripts;

import com.KK.generic.BaseLibrary;
import com.KK.pageobjects.SearchPage;
import org.testng.annotations.Test;

public class TestHarness extends BaseLibrary {
    @Test
    public void verifySearch() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchText("Kula");
    }

}
