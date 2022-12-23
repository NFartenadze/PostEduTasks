package com.solvd.gui.components;

import com.solvd.gui.pages.AbstractPage;
import com.solvd.gui.pages.ResultPage;
import com.solvd.gui.service.WebDriverPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationBar extends AbstractPage {
    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    @FindBy(xpath = "//div[@data-test-id='main-nav-bar']/ul//span[contains(text(),'Women')]")
    private WebElement women;
    @FindBy(xpath = "//div[@data-test-id='main-nav-bar']/ul//span[contains(text(),'Men')]")
    private WebElement men;
    @FindBy(xpath = "//div[@data-test-id='main-nav-bar']/ul//span[contains(text(),'Kids')]")
    private WebElement kids;
    @FindBy(xpath = "//button[@id = \"account-button\"]")
    private WebElement accountButton;
    @FindBy(xpath = "//input['data-test-id=\"search-box\"']")
    private WebElement searchBar;
    @FindBy(xpath = "//a[@data-link-name='Shoes']")
    private WebElement shoesLink;
    @FindBy(xpath = "//input[@type='search']/../div/button[@type='submit']")
    private WebElement searchButton;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void hoverWomenLink() throws InterruptedException {
        hover(women);
    }

    public boolean isShoesElementPresent() {
        return isDisplayed(shoesLink);
    }

    public void clickShoes() {
        new WebDriverWait(WebDriverPool.get(), TIMEOUT).until(ExpectedConditions.visibilityOf(shoesLink));
        click(shoesLink);
    }

    public boolean isWomenLinkPresent() {
        return isDisplayed(women);
    }

    public void typeInSearchBar(String s) {
        sendKeys(searchBar, s);
    }

    public ResultPage clickSearch() {
        click(this.searchButton);
        ResultPage resultPage = new ResultPage(getDriver());
        resultPage.setPageURL(getPageURL() + searchBar.getText());
        return resultPage;
    }

    public boolean isAccountButtonPresent() {
        return isDisplayed(accountButton);
    }

    public AccountPanel clickAccountButton() {
        click(accountButton);
        return new AccountPanel(getDriver());
    }

    public boolean isSearchBarPresent() {
        return isDisplayed(searchBar);
    }

    public void hoverMenLink() {
        hover(men);
    }


    public boolean isMenLinkPresent() {
        return isDisplayed(men);
    }

    public void hoverKidsLink() {
        hover(kids);
    }

    public boolean isKidsLinkPresent() {
        return isDisplayed(kids);
    }
}
