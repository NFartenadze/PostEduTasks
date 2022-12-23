package org.gui.pages;

import com.solvd.gui.components.AccountPanel;
import com.solvd.gui.components.LanguagePanel;
import com.solvd.gui.components.NavigationBar;
import com.solvd.gui.components.States;
import com.solvd.gui.pages.*;
import com.solvd.gui.service.Screenshot;
import com.solvd.gui.service.WebDriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Puma extends AbstractTest {


    @Test
    public void searchBag() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            Assert.assertTrue(homePage.isPageOpened(),"home page isn't opened");
            homePage.clickStayOnRegion();
            NavigationBar navigationBar = new NavigationBar(driver);
            Assert.assertTrue(navigationBar.isSearchBarPresent(), "search bar isn't present");
            navigationBar.typeInSearchBar("Bag");
            navigationBar.clickSearch();
            ResultPage resultPage = new ResultPage(driver);
            Assert.assertTrue(resultPage.isPageOpened(),"result page isn't opened");
            resultPage.printResultItemTexts();
            Assert.assertEquals(resultPage.getAmountOfItems(),24);
        } catch (Exception e) {
            Screenshot.takeScreenshot(driver);
            throw new RuntimeException(e);
        }
    }


    @Test()
    public void navigateToWomenShoesSection() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            Assert.assertTrue(homePage.isPageOpened(),"home page isn't opened");
            homePage.clickStayOnRegion();
            NavigationBar navigationBar = new NavigationBar(driver);
            Assert.assertTrue(navigationBar.isWomenLinkPresent(), "Woman Link isn't present");
            navigationBar.hoverWomenLink();
//            Assert.assertTrue(navigationBar.isShoesElementPresent(),"shoes isn't present");
            navigationBar.clickShoes();
        } catch (Exception e) {
            Screenshot.takeScreenshot(driver);
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addItemToCart() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
//            Assert.assertTrue(homePage.isPageOpened(),"home page isn't opened");
            homePage.clickStayOnRegion();
            NavigationBar navigationBar = new NavigationBar(driver);
            Assert.assertTrue(navigationBar.isSearchBarPresent(), "search bar isn't present");
            navigationBar.typeInSearchBar("shoes");
            navigationBar.clickSearch();
            ResultPage resultPage = new ResultPage(driver);
            resultPage.closeCookiePanel();
            resultPage.clickItem(0);
            ItemPage itemPage = new ItemPage(driver);
            itemPage.addToCart();
        } catch (Exception e) {
            Screenshot.takeScreenshot(driver);
            throw new RuntimeException(e);
        }
    }

    @Test
    public void registration() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
//            Assert.assertTrue(homePage.isPageOpened(),"home page isn't opened");
            homePage.clickStayOnRegion();

            //accessing navbar
            NavigationBar navigationBar = new NavigationBar(driver);
            Assert.assertTrue(navigationBar.isAccountButtonPresent(), "Account button isn't present");

            //opening account panel
            AccountPanel accountPanel = navigationBar.clickAccountButton();
            Assert.assertTrue(accountPanel.isRegisterButtonPresent(), "Register button isn't present");
            //opening registration page
            RegistrationPage registrationPage = accountPanel.clickRegisterButton();
//            registrationPage.fillRegistrationForm("asdasd","asdasd","asdasd","Asdasd");
            Assert.assertTrue(registrationPage.isFirstNameFieldPresent(), "first name field isn't present");
            registrationPage.typeFirstName("john");
            Assert.assertTrue(registrationPage.isLastNameFieldPresent(), "last name field isn't present");
            registrationPage.typeLastName("Doe");
            Assert.assertTrue(registrationPage.isEmailFieldPresent(), "email field isn't present");
            registrationPage.typeEmail("john1148@gmail.com");
            Assert.assertTrue(registrationPage.isPasswordFieldPresent(), "password field isn't present");
            registrationPage.typePassword("john11");
            Assert.assertTrue(registrationPage.isRegisterButtonPresent(), "register button isn't present");
            registrationPage.clickRegister();
        } catch (Exception e) {
            Screenshot.takeScreenshot(driver);
            throw new RuntimeException(e);
        }
    }

    @Test
    public void changeLanguage() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
//            Assert.assertTrue(homePage.isPageOpened(),"home page isn't opened");
            homePage.clickStayOnRegion();

            //accessing navigation bar
            NavigationBar navigationBar = new NavigationBar(driver);
            Assert.assertTrue(navigationBar.isAccountButtonPresent(), "Account button isn't present");

            //opening account panel
            AccountPanel accountPanel = navigationBar.clickAccountButton();
            Assert.assertTrue(accountPanel.isLanguagePresent(), "Language isn't present");

            //opening language panel
            LanguagePanel languagePanel = accountPanel.clickLanguage();
            Assert.assertTrue(languagePanel.isSearchFieldPresent(), "Search field is missing");
            languagePanel.typeInSearch("spanish");
            Assert.assertTrue(languagePanel.isSearchButtonPresent());
            languagePanel.clickSearchButton();
            Assert.assertTrue(languagePanel.checkResult());
            languagePanel.clickSearchedLanguage();
        } catch (Exception e) {
            Screenshot.takeScreenshot(driver);
            throw new RuntimeException(e);
        }
    }


    @Test
    public void addNewAddress() throws IOException {
        WebDriver driver = WebDriverPool.get();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
//            Assert.assertTrue(homePage.isPageOpened(),"home page isn't opened");
            homePage.clickStayOnRegion();
            NavigationBar navigationBar = new NavigationBar(driver);
            Assert.assertTrue(navigationBar.isAccountButtonPresent(), "Account button isn't present");

            //account panel
            AccountPanel accountPanel = navigationBar.clickAccountButton();
            Assert.assertTrue(accountPanel.isLoginButtonPresent(), "login button isn't present");

            //login page
            LoginPage loginPage = accountPanel.clickLoginButton();
            Assert.assertTrue(loginPage.isPageOpened(),"login page isn't opened");
            Assert.assertTrue(loginPage.isLoginFieldPresent(), "login field isn't present");
            loginPage.typeLogin("john1148@gmail.com");
            Assert.assertTrue(loginPage.isPasswordFieldPresent(), "password field isn't present");
            loginPage.typePassword("john1148");
            Assert.assertTrue(loginPage.isLoginBtnPresent(), "login button isn't present");
            loginPage.clickLoginBtn();
            navigationBar.clickAccountButton();
            Assert.assertTrue(accountPanel.isMenuItemPresent(AccountPanel.MenuItems.MY_ACCOUNT), "My Account isn't present");
            accountPanel.clickMenuItem(AccountPanel.MenuItems.MY_ACCOUNT);

            //account dashboard page
            DashboardPage dashboardPage = new DashboardPage(accountPanel.getDriver());
            Assert.assertTrue(dashboardPage.isPageOpened(),"dashboard page isn't opened");
            Assert.assertTrue(dashboardPage.isAddNewPresent(), "add new button isn't present");

            //address book page
            AddressBookPage addressBookPage = dashboardPage.clickAddNew();
//            addressBookPage.addNewAddress("Default", AddressBookPage.Countries.CANADA,"john","doe","12123",
//                    "etc","smt","123123",States.ALASKA,"1312312312");

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
            addressBookPage.selectState(States.ILLINOIS);
            Assert.assertTrue(addressBookPage.isPhoneNumberFieldPresent(), "address title field isn't present");
            addressBookPage.typePhoneNumber("5555555555");
            Assert.assertTrue(addressBookPage.isSaveBtnPresent(), "address title field isn't present");
            addressBookPage.clickSaveBtn();
        } catch (Exception e) {
            Screenshot.takeScreenshot(driver);
        }
    }


}