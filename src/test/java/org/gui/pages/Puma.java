package org.gui.pages;

import com.solvd.gui.components.AccountPanel;
import com.solvd.gui.components.LanguagePanel;
import com.solvd.gui.components.NavigationBar;
import com.solvd.gui.pages.*;
import com.solvd.gui.service.Screenshot;
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
            Screenshot.takeScreenshot(driver);
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
            homePage.typeInSearchBar("qweiqwkehjqgwglke");
            homePage.clickSearch();
            ResultPage resultPage = new ResultPage(driver);
            resultPage.closeCookiePanel();
            resultPage.clickItem(0);
            ItemPage itemPage = new ItemPage(driver);
            itemPage.addToCart();
        } catch (Exception e) {
            Screenshot.takeScreenshot(driver);
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
            Screenshot.takeScreenshot(driver);
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
            Screenshot.takeScreenshot(driver);
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
            RegistrationPage registrationPage = accountPanel.clickRegisterButton();
        } catch (Exception e) {
            Screenshot.takeScreenshot(driver);
        }
    }

    @Test
    public void addNewAddress() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            homePage.clickStayOnRegion();
            Assert.assertTrue(homePage.isAccountButtonPresent(), "Account button isn't present");

            //account panel
            AccountPanel accountPanel = homePage.clickAccountButton();
            Assert.assertTrue(accountPanel.isLoginButtonPresent(), "login button isn't present");

            //login page
            LoginPage loginPage = accountPanel.clickLoginButton();
            Assert.assertTrue(loginPage.isLoginFieldPresent(), "login field isn't present");
            loginPage.typeLogin("john1148@gmail.com");
            Assert.assertTrue(loginPage.isPasswordFieldPresent(), "password field isn't present");
            loginPage.typePassword("john1148");
            Assert.assertTrue(loginPage.isLoginBtnPresent(), "login button isn't present");
            loginPage.clickLoginBtn();

            homePage.clickAccountButton();
            Assert.assertTrue(accountPanel.isMenuItemPresent(AccountPanel.MenuItems.MY_ACCOUNT), "My Account isn't present");
            accountPanel.clickMenuItem(AccountPanel.MenuItems.MY_ACCOUNT);

            //account dashboard page
            DashboardPage dashboardPage = new DashboardPage(accountPanel.getDriver());
            Assert.assertTrue(dashboardPage.isAddNewPresent(), "add new button isn't present");

            //address book page
            AddressBookPage addressBookPage = dashboardPage.clickAddNew();
            Assert.assertTrue(addressBookPage.isAddressTitleFieldPresent(), "address title field isn't present");
            addressBookPage.typeAddressTitle("example");
            addressBookPage.selectCountry(2);
            Assert.assertTrue(addressBookPage.isFirstNameFieldPresent(), "first name field isn't present");
            addressBookPage.typeFirstName("example");
            Assert.assertTrue(addressBookPage.isLastNameFieldPresent(), "last name field isn't present");
            addressBookPage.typeLastName("example");
            Assert.assertTrue(addressBookPage.isStreetNumberFieldPresent(), "street number field isn't present");
            addressBookPage.typeStreetNumber("example");
            Assert.assertTrue(addressBookPage.isCompanyInfoFieldPresent(), "address title field isn't present");
            addressBookPage.typeCompanyInfo("example");
            Assert.assertTrue(addressBookPage.isCityFieldPresent(), "address title field isn't present");
            addressBookPage.typeCity("example");
            Assert.assertTrue(addressBookPage.isPostalCodeFieldPresent(), "address title field isn't present");
            addressBookPage.typePostalCode("example");
            Assert.assertTrue(addressBookPage.isPhoneNumberFieldPresent(), "address title field isn't present");
            addressBookPage.typePhoneNumber("5555555555");
            Assert.assertTrue(addressBookPage.isSaveBtnPresent(), "address title field isn't present");
            addressBookPage.clickSaveBtn();

        } catch (Exception e) {
            Screenshot.takeScreenshot(driver);
        }
    }


}