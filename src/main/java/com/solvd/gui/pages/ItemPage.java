package com.solvd.gui.pages;

import com.solvd.gui.service.WebDriverPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage extends AbstractPage {
    @FindBy(xpath = "//button[@data-test-id='pdp-add-to-cart']")
    private WebElement cartButton;

    public ItemPage(WebDriver driver) {
        super(driver);
        setPageURL(driver.getCurrentUrl());
    }

    public boolean isCartButtonPresent() {
        return isDisplayed(cartButton);
    }

    public void addToCart() {
        new WebDriverWait(WebDriverPool.get(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(cartButton));
        scrollTo(cartButton);
        click(cartButton);
    }
}
