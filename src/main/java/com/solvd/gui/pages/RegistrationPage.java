package com.solvd.gui.pages;

import com.solvd.gui.service.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger(RegistrationPage.class);

    @FindBy(xpath = "//input[@name='firstName']")
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
        setPageURL(Configuration.getProperty("url") + "/account/login?action=register");
    }

    public boolean isFirstNameFieldPresent() {
        return isDisplayed(firstNameField);
    }

    public boolean isLastNameFieldPresent() {
        return isDisplayed(lastNameField);
    }

    public boolean isEmailFieldPresent() {
        return isDisplayed(emailField);
    }

    public boolean isPasswordFieldPresent() {
        return isDisplayed(passwordField);
    }

    public boolean isRegisterButtonPresent() {
        return isDisplayed(registerButton);
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

    public void clickRegister() {
        scrollTo(registerButton);
        click(registerButton);
    }
}
