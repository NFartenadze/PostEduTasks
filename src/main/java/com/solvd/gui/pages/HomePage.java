package com.solvd.gui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);
    private By searchResult = By.xpath("//ul[@id='product-list-items']/li/div[3]/a/h3");
    private By searchBar = By.xpath("//input['data-test-id=\"search-box\"']");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By navigationBar = By.xpath("");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public List getSearchResult() {
        return driver.findElements(searchResult);
    }

    public void printResultItemTexts() {
        driver.findElements(searchResult)
                .forEach(e -> logger.info(e.getText()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void typeInSearchBar(String s) {
        type(searchBar, s);
    }

    public WebElement getSearchBar() {
        return getElement(searchBar);
    }

    public void hoverNavigationBar() {
        hover(navigationBar);
    }

    public WebElement getSearchButton() {
        return getElement(searchButton);
    }

    public String getHomePageTitle() {
        return getPageTitle();
    }

    public void NavigationBar() {
        getElement(navigationBar);
    }

    public void clickSearch() {
        getElement(searchButton).click();
    }

}
