package com.solvd.gui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger(RegistrationPage.class);

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@data-test-id='register']")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFirstNameFieldPresent() {
        return firstNameField.isDisplayed();
    }

    public boolean isLastNameFieldPresent() {
        return lastNameField.isDisplayed();
    }

    public boolean isEmailFieldPresent() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldPresent() {
        return passwordField.isDisplayed();
    }

    public boolean isRegisterButtonPresent() {
        return registerButton.isDisplayed();
    }

    public void typeFirstName(String s) {
        sendKeys(firstNameField, s);
    }

    public void typeLastName(String s) {
        sendKeys(lastNameField, s);
    }

    public void typeEmail(String s) {
        sendKeys(emailField, s);
    }

    public void typePassword(String s) {
        sendKeys(passwordField, s);
    }
}
