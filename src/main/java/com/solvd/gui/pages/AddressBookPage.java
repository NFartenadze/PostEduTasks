package com.solvd.gui.pages;

import com.solvd.gui.components.States;
import com.solvd.gui.service.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddressBookPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='address-title-input']")
    private WebElement addressTitleField;
    @FindBy(xpath = "//select[@id='address-form-country-select']/option")
    private List<WebElement> country;
    @FindBy(xpath = "//input[@id='firstName-input']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='lastName-input']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='address1']")
    private WebElement streetNumber;
    @FindBy(xpath = "//input[@id='address2-input']")
    private WebElement companyInfo;
    @FindBy(xpath = "//input[@id='city-input']")
    private WebElement city;
    @FindBy(xpath = "//input[@id='postalCode-input']")
    private WebElement postalCode;
    @FindBy(xpath = "//select[@id='address-form-state-select']")
    private WebElement state;

    @FindBy(xpath = "//input[@id=\"phone-input\"]")
    private WebElement phoneNumber;
    @FindBy(xpath = "//button[@data-test-id='add-address-button']")
    private WebElement saveButton;

    @FindBy(xpath = "//a[@data-test-id='back-to-account']")
    private WebElement backToMyAccountButton;
    @FindBy(xpath = "//input[@type='checkbox' and @id='preferred-address']")
    private WebElement makeDefaultCheckBox;


    public AddressBookPage(WebDriver driver) {
        super(driver);
        setPageURL(Configuration.getProperty("url") + "/account/addresses/add-address");
    }

    public void selectState(States s) {
        Select stateDropDown = new Select(state);
        stateDropDown.selectByVisibleText(s.getState());
    }

    public boolean isPhoneNumberFieldPresent() {
        return isDisplayed(phoneNumber);
    }

    public void typePhoneNumber(String s) {
        sendKeys(phoneNumber, s);
    }

    public boolean isPostalCodeFieldPresent() {
        return isDisplayed(postalCode);
    }

    public void clickBackToMyAccountButton() {
        click(backToMyAccountButton);
    }

    public void checkMakeDefault() {
        click(makeDefaultCheckBox);
    }

    public void typeFirstName(String s) {
        sendKeys(firstName, s);
    }

    public void typeLastName(String s) {
        sendKeys(lastName, s);
    }

    public boolean isFirstNameFieldPresent() {
        return isDisplayed(firstName);
    }

    public boolean isLastNameFieldPresent() {
        return isDisplayed(lastName);
    }

    public boolean isAddressTitleFieldPresent() {
        return isDisplayed(addressTitleField);
    }

    public boolean isStreetNumberFieldPresent() {
        return isDisplayed(streetNumber);
    }

    public boolean isCompanyInfoFieldPresent() {
        return isDisplayed(companyInfo);
    }

    public boolean isSaveBtnPresent() {
        return isDisplayed(saveButton);
    }

    public void clickSaveBtn() {
        click(saveButton);
    }

    public boolean isCityFieldPresent() {
        return isDisplayed(city);
    }

    public void typeStreetNumber(String s) {
        sendKeys(streetNumber, s);
    }

    public void typeCompanyInfo(String s) {
        sendKeys(companyInfo, s);
    }

    public void typeAddressTitle(String s) {
        sendKeys(addressTitleField, s);
    }

    public void typeCity(String s) {
        sendKeys(city, s);
    }

    public void typePostalCode(String s) {
        sendKeys(postalCode, s);
    }

    public void selectCountry(int i) {
        country.get(i).click();
        country.get(i).click();
    }

}
