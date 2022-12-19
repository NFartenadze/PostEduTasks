package com.solvd.gui.components;

import com.solvd.gui.pages.AbstractPage;
import com.solvd.gui.service.WebDriverPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationBar extends AbstractPage {
    private static final Duration TIMEOUT = Duration.ofSeconds(10);
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
        return new WebDriverWait(WebDriverPool.get(), TIMEOUT).until(ExpectedConditions.visibilityOf(shoesLink)).isDisplayed();
    }

    public void clickShoes() {
        click(shoesLink);
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
