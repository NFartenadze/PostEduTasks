package com.solvd.gui.pages;

import com.solvd.gui.components.AccountPanel;
import com.solvd.gui.components.NavigationBar;
import com.solvd.gui.service.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class HomePage extends AbstractPage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//button[@id = \"account-button\"]")
    private WebElement accountButton;
    @FindBy(xpath = "//input['data-test-id=\"search-box\"']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@data-test-id='location-check-stay-on-country']")
    private WebElement stayOnRegion;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;
    @FindBy(xpath = "//div[@data-test-id='main-nav-bar']/ul")
    private WebElement navigationBar;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL(Configuration.getProperty("url"));
    }

    public boolean isAccountButtonPresent() {
        return isDisplayed(accountButton);
    }

    public AccountPanel clickAccountButton() {
        click(accountButton);
        accountButton.sendKeys("");
        return new AccountPanel(getDriver());
    }

    public boolean isSearchBarPresent() {
        return isDisplayed(searchBar);
    }

    public void clickStayOnRegion() {
        click(stayOnRegion);
    }

    public void typeInSearchBar(String s) {
//        sendKeys(searchBar, s);
        sendKeys(searchBar, s);
    }

    public NavigationBar hoverNavigationBar() {
        hover(navigationBar);
        return new NavigationBar(getDriver());
    }


    public void clickSearch() {
        click(this.searchButton);
        super.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
