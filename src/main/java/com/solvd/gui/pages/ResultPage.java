package com.solvd.gui.pages;

import com.solvd.gui.service.Configuration;
import com.solvd.gui.service.WebDriverPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ResultPage extends AbstractPage {

    private static final Logger logger = LogManager.getLogger(ResultPage.class);

    @FindBy(xpath = "//ul[@id='product-list-items']/li/div[3]/a/h3")
    private List<WebElement> itemTitles;

    @FindBy(css = "#cookie-banner-close-btn")
    private WebElement closeCookieButton;

    @FindBy(xpath = "//li[@data-test-id='product-list-item']")
    private List<WebElement> items;

    public ResultPage(WebDriver driver) {
        super(driver);
        setPageURL(Configuration.getProperty("url")+"/search?q=");
    }

    public void closeCookiePanel() {
        click(closeCookieButton);
    }

    public void clickItem(int i) {
        scrollTo(items.get(i));
        click(items.get(i));
    }

    public void printResultItemTexts() {
        new WebDriverWait(WebDriverPool.get(), Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='product-list-items']")));
        itemTitles
                .forEach(e -> logger.info(e.getText()));
    }


    public int getAmountOfItems() {
        return itemTitles.size();
    }


}