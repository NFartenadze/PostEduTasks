package com.solvd.gui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }


    @Override
    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
            return element;
        } catch (Exception e) {
            logger.info(e);
            e.printStackTrace();
        }
        return element;
    }

    @Override
    public void type(By locator, String s) {
        driver.findElement(locator).sendKeys(s);
    }

    @Override
    public void hover(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(locator)).perform();
    }

    @Override
    public void waitForElementToAppear(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            logger.info("Problem while waiting for element");
        }
    }

    @Override
    public void waitForPageTitle(String title) {
        try {
            wait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e) {
            logger.info("Problem while waiting for title to appear");
        }
    }
}
