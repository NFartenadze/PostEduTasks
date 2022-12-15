package org.gui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class HomePage extends BaseTest {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    By searchResult = By.xpath("//ul[@id='product-list-items']/li/div[3]/a/h3");
    By searchBar = By.xpath("//input['data-test-id=\"search-box\"']");
    By searchButton = By.xpath("//button[@type='submit']");


    public List getSearchResult() {
        return driver.findElements(searchResult);
    }

    public void printResultItemTexts() {
        driver.findElements(searchResult)
                .forEach(e -> logger.info(e.getText()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void searchBarType(String s) {
        enterTextBy(searchBar, s);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
}
