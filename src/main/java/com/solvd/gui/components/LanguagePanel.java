package com.solvd.gui.components;

import com.solvd.gui.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguagePanel extends AbstractPage {
    @FindBy(xpath = "//input[@id='location-selector-input']")
    private WebElement searchField;
    @FindBy(xpath = "//ul[@id='location-results-listbox']/li")
    private WebElement searchedLanguage;

    @FindBy(xpath = "//*[@id='location-selector-input']/../div[contains(@class,'absolute')]")
    private WebElement searchButton;


    public LanguagePanel(WebDriver driver) {
        super(driver);
    }

    public void clickSearchedLanguage() {
        click(searchedLanguage);
    }

    public boolean checkResult() {
        return searchedLanguage.isDisplayed();
    }

    public boolean isSearchFieldPresent() {
        return searchField.isDisplayed();
    }

    public void typeInSearch(String s) {
        sendKeys(searchField, s);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public boolean isSearchButtonPresent() {
        return searchButton.isDisplayed();
    }


}
