package com.solvd.gui.pages;

import com.solvd.gui.components.NavigationBar;
import com.solvd.gui.service.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class HomePage extends AbstractPage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//ul[@id='product-list-items']/li/div[3]/a/h3")
    private List<WebElement> searchResult;

    @FindBy(xpath = "//input['data-test-id=\"search-box\"']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;
    @FindBy(xpath = "")
    private WebElement navigationBar;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL(Configuration.getProperty("url"));
    }

    public int getSearchResultSize() {
        return searchResult.size();
    }

    public void printResultItemTexts() {
        searchResult
                .forEach(e -> logger.info(e.getText()));
        super.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public boolean isSearchBarPresent() {
        return searchBar.isDisplayed();
    }

    public void typeInSearchBar(String s) {
//        sendKeys(searchBar, s);
        sendKeys(this.searchBar, s);

    }

    public void hoverNavigationBar() {
        hover(navigationBar);
    }


    public NavigationBar getNavigationBar() {
        return new NavigationBar();
    }

    public void clickSearch() {
        click(this.searchButton);
        super.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
