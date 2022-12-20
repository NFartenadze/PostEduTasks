package org.gui.pages;

import com.solvd.gui.components.AccountPanel;
import com.solvd.gui.components.LanguagePanel;
import com.solvd.gui.components.NavigationBar;
import com.solvd.gui.pages.HomePage;
import com.solvd.gui.pages.ItemPage;
import com.solvd.gui.pages.ResultPage;
import com.solvd.gui.service.Configuration;
import com.solvd.gui.service.WebDriverPool;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Puma extends AbstractTest {


    @Test
    public void searchBag() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
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
        } catch (Exception e) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("/Users/nikafartenadze/Desktop/Projects/untitled/src/test/resources/errorimgs.png"));
        }
    }


    @Test
    public void navigateToWomenShoesSection() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            homePage.clickStayOnRegion();
            NavigationBar navigationBar = homePage.hoverNavigationBar();
            Assert.assertTrue(navigationBar.isWomenLinkPresent(), "Woman Link isn't present");
            navigationBar.hoverWomenLink();
            navigationBar.clickShoes();
        } catch (Exception e) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("/Users/nikafartenadze/Desktop/Projects/untitled/src/test/resources/errorimgs.png"));
        }
    }

    @Test
    public void addItemToCart() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            homePage.clickStayOnRegion();
            Assert.assertTrue(homePage.isSearchBarPresent(), "search bar isn't present");
            homePage.typeInSearchBar("Shoes");
            homePage.clickSearch();
            ResultPage resultPage = new ResultPage(driver);
            resultPage.closeCookiePanel();
            resultPage.clickItem(1);
            ItemPage itemPage = new ItemPage(driver);
            itemPage.addToCart();
        } catch (Exception e) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("/Users/nikafartenadze/Desktop/Projects/untitled/src/test/resources/errorimgs.png"));
        }
    }

    @Test
    public void registration() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            homePage.clickStayOnRegion();
            Assert.assertTrue(homePage.isAccountButtonPresent(), "Account button isn't present");
            AccountPanel accountPanel = homePage.clickAccountButton();
            Assert.assertTrue(accountPanel.isRegisterButtonPresent(), "Register button isn't present");
            accountPanel.clickRegisterButton();
        } catch (Exception e) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("/Users/nikafartenadze/Desktop/Projects/untitled/src/test/resources/errorimgs.png"));
        }
    }

    @Test
    public void changeLanguage() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            homePage.clickStayOnRegion();
            Assert.assertTrue(homePage.isAccountButtonPresent(), "Account button isn't present");
            AccountPanel accountPanel = homePage.clickAccountButton();
            Assert.assertTrue(accountPanel.isLanguagePresent(), "Language isn't present");
            LanguagePanel languagePanel = accountPanel.clickLanguage();
            Assert.assertTrue(languagePanel.isSearchFieldPresent(), "Search field is missing");
            languagePanel.typeInSearch("spanish");
            Assert.assertTrue(languagePanel.isSearchButtonPresent());
            languagePanel.clickSearchButton();
            Assert.assertTrue(languagePanel.checkResult());
            languagePanel.clickSearchedLanguage();
        } catch (Exception e) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(Configuration.getProperty("screenshot")));
        }
    }

    @Test
    public void registrationForm() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            homePage.clickStayOnRegion();
            Assert.assertTrue(homePage.isAccountButtonPresent(), "Account button isn't present");
            AccountPanel accountPanel = homePage.clickAccountButton();
            Assert.assertTrue(accountPanel.isRegisterButtonPresent(), "Registration Button isn't present");
            accountPanel.clickRegisterButton();
        } catch (Exception e) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(Configuration.getProperty("screenshot")));
        }
    }


}