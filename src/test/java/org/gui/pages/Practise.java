package org.gui.pages;

import com.solvd.gui.components.NavigationBar;
import com.solvd.gui.pages.HomePage;
import com.solvd.gui.pages.ItemPage;
import com.solvd.gui.pages.ResultPage;
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
        homePage.clickStayOnRegion();
//        Assert.assertTrue(homePage.isPageOpened(), "Home Page isn't opened");
        Assert.assertTrue(homePage.isSearchBarPresent(), "search bar isn't present");
        homePage.typeInSearchBar("Bag");
        homePage.clickSearch();
        ResultPage resultPage = new ResultPage(driver);
        Assert.assertEquals(resultPage.getAmountOfItems(), 24);
        resultPage.printResultItemTexts();
    }

    @Test
    public void navigateToWomenShoesSection() {
        WebDriver driver = WebDriverPool.get();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickStayOnRegion();
        NavigationBar navigationBar = homePage.hoverNavigationBar();
        Assert.assertTrue(navigationBar.isWomenLinkPresent(), "Woman Link isn't present");
        navigationBar.hoverWomenLink();
        Assert.assertTrue(navigationBar.isShoesElementPresent(), "Women shoes link isn't present in panel");
        navigationBar.clickShoes();
    }

    @Test
    public void addItemToCart() {
        WebDriver driver = WebDriverPool.get();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickStayOnRegion();
        Assert.assertTrue(homePage.isSearchBarPresent(), "search bar isn't present");
        homePage.typeInSearchBar("Shoes");
        homePage.clickSearch();
        ResultPage resultPage = new ResultPage(driver);
        resultPage.closeCookiePanel();
        resultPage.clickItem(0);
        ItemPage itemPage = new ItemPage(driver);
        itemPage.addToCart();
    }


}