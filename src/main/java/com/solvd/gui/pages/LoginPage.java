package com.solvd.gui.pages;

import com.solvd.gui.service.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@id=\"email\"]")
    private WebElement loginField;
    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id=\"rememberMe\"]")
    private WebElement rememberCredentialsCheckbox;
    @FindBy(xpath = "//button[@id=\"login-submit\"]")
    private WebElement loginBtn;
    @FindBy(xpath = "//button[@data-test-id=\"forgotten-password-link\"]")
    private WebElement forgotPasswordBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL(Configuration.getProperty("url") + "/account/login?action=login");
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
        return isDisplayed(loginBtn);
    }

    public boolean isForgotPasswordBtnPresent() {
        return isDisplayed(forgotPasswordBtn);
    }

    public boolean isRememberCredentialsCheckboxPresent() {
        return isDisplayed(rememberCredentialsCheckbox);
    }

    public boolean isPasswordFieldPresent() {
        return isDisplayed(passwordField);
    }

    public boolean isLoginFieldPresent() {
        return isDisplayed(loginField);
    }

}
