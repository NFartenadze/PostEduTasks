package org.gui.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePageTest {
    WebDriver driver;

    @Test()
    public void SearchBags() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.searchBarType("BAG");
        homePage.clickSearch();
        homePage.getSearchResult();
        homePage.printResultItemTexts();
        homePage.quit();
    }
}