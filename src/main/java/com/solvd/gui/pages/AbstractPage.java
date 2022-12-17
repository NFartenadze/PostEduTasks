package com.solvd.gui.pages;

import com.solvd.gui.service.WebDriverPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(AbstractPage.class);
    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    protected String pageURL;
    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void open() {
        this.driver.get(this.pageURL);
        this.driver.manage().window().fullscreen();

    }


    protected void hover(WebElement element) {
        String name = element.getAccessibleName();
        Actions actions = new Actions(driver);
        new WebDriverWait(WebDriverPool.get(), TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
        actions.moveToElement(element).perform();
        LOGGER.info(name + " was hovered");
    }

    protected void click(WebElement element) {
        String name = element.getAccessibleName();
        new WebDriverWait(WebDriverPool.get(), TIMEOUT).until(ExpectedConditions.elementToBeClickable(element)).click();
        LOGGER.info(name + " was clicked.");
    }

    protected void sendKeys(WebElement element, String string) {
        String name = element.getAccessibleName();
        new WebDriverWait(WebDriverPool.get(), TIMEOUT).until(ExpectedConditions.visibilityOf(element)).sendKeys(string);
        LOGGER.info(name + " was written in" + element.getAccessibleName());
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    public String getPageURL() {
        return this.pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

//    public boolean isPageOpened(){
//        return new WebDriverWait(WebDriverPool.get(), TIMEOUT).until(ExpectedConditions.);
//    };
}
