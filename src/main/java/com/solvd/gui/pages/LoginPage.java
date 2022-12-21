package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "")
    private WebElement loginField;
    @FindBy(xpath = "")
    private WebElement passwordField;
    @FindBy(xpath = "")
    private WebElement rememberCredentialsCheckbox;
    @FindBy(xpath = "")
    private WebElement loginBtn;
    @FindBy(xpath = "")
    private WebElement forgotPasswordBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL(driver.getCurrentUrl());
    }

    public void clickLoginBtn() {
        click(loginBtn);
    }

    public void typeLogin(String s) {
        sendKeys(loginField, s);
    }

    public void typePassword(String s) {
        sendKeys(passwordField, s);
    }

    public void checkRememberCredentials() {
        click(rememberCredentialsCheckbox);
    }

    public void clickForgotPasswordBtn() {
        click(forgotPasswordBtn);
    }

    public boolean isLoginBtnPresent() {
        return loginBtn.isDisplayed();
    }

    public boolean isForgotPasswordBtnPresent() {
        return forgotPasswordBtn.isDisplayed();
    }

    public boolean isRememberCredentialsCheckboxPresent() {
        return rememberCredentialsCheckbox.isDisplayed();
    }

    public boolean isPasswordFieldPresent() {
        return passwordField.isDisplayed();
    }

    public boolean isLoginFieldPresent() {
        return loginField.isDisplayed();
    }

}
