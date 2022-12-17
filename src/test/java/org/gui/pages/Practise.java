package org.gui.pages;

import com.solvd.gui.pages.HomePage;
import com.solvd.gui.service.WebDriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practise extends AbstractTest {


    @Test
    public void searchBag() {
        WebDriver driver = WebDriverPool.get();
        HomePage homePage = new HomePage(driver);
        homePage.open();
//        Assert.assertTrue(homePage.isPageOpened(), "Home Page isn't opened");
        Assert.assertTrue(homePage.isSearchBarPresent(), "search bar isn't present");
        homePage.typeInSearchBar("Bag");
        homePage.clickSearch();
        Assert.assertEquals(homePage.getSearchResultSize(), 24);
        homePage.printResultItemTexts();
    }

    @Test
    public void addItemToCart() {
        WebDriver driver = WebDriverPool.get();
        HomePage homePage = new HomePage(driver);
        homePage.typeInSearchBar("Bag");
        homePage.clickSearch();
        Assert.assertEquals(homePage.getSearchResultSize(), 24);

    }


}