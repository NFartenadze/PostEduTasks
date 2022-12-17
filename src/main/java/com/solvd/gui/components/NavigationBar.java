package com.solvd.gui.components;

import com.solvd.gui.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractPage {
    @FindBy(xpath = "//div[@data-test-id='main-nav-bar']/ul//span[contains(text(),'Women')]")
    private WebElement women;
    @FindBy(xpath = "//div[@data-test-id='main-nav-bar']/ul//span[contains(text(),'Men')]")
    private WebElement men;
    @FindBy(xpath = "//div[@data-test-id='main-nav-bar']/ul//span[contains(text(),'Kids')]")
    private WebElement kids;

    @FindBy(xpath = "//a[@data-link-name='Shoes']")
    private WebElement shoesLink;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void hoverWomenLink() {
        hover(women);
    }

    public boolean isShoesElementPresent() {
        return shoesLink.isDisplayed();
    }

    public void clickShoes() {
        shoesLink.click();
    }

    public boolean isWomenLinkPresent() {
        return women.isDisplayed();
    }

    public void hoverMenLink() {
        hover(men);
    }


    public boolean isMenLinkPresent() {
        return men.isDisplayed();
    }

    public void hoverKidsLink() {
        hover(kids);
    }

    public boolean isKidsLinkPresent() {
        return kids.isDisplayed();
    }
}
