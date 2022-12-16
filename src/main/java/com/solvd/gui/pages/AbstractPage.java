package com.solvd.gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class AbstractPage {
    WebDriver driver;
    WebDriverWait wait;

    public AbstractPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    //Methods
    public abstract String getPageTitle();

    public abstract WebElement getElement(By locator);

    public abstract void type(By locator, String s);

    public abstract void hover(By locator);

    public abstract void waitForElementToAppear(By locator);

    public abstract void waitForPageTitle(String title);

    public <T extends BasePage> T getInstance(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
