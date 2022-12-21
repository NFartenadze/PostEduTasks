package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage {
    @FindBy(xpath = "//button[@data-test-id='pdp-add-to-cart']")
    private WebElement cartButton;

    public ItemPage(WebDriver driver) {
        super(driver);
        setPageURL(driver.getCurrentUrl());
    }

    public void addToCart() {
        scrollTo(cartButton);
        click(cartButton);
    }
}
