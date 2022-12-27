package com.solvd.puma.mobile.gui.pages.android.menuitems;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.puma.mobile.gui.pages.common.menuitems.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    @FindBy(id = "email")
    private ExtendedWebElement emailField;
    @FindBy(id = "password")
    private ExtendedWebElement passwordField;
    @FindBy(id = "rememberMe")
    private ExtendedWebElement rememberMeCheckBox;
    @FindBy(id = "login-submit")
    private ExtendedWebElement loginBtn;
    @FindBy(xpath = "//android.view.View[3]/android.widget.Button[2]")
    private ExtendedWebElement forgotPasswordBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeEmail(String s) {
        emailField.type(s);
    }

    @Override
    public boolean isEmailFieldPresent() {
        return emailField.isElementPresent();
    }

    @Override
    public void typePassword(String s) {
        passwordField.type(s);
    }

    @Override
    public boolean isPasswordFieldPresent() {
        return passwordField.isElementPresent();
    }

    @Override
    public void checkRememberMe() {
        rememberMeCheckBox.check();
    }

    @Override
    public boolean isRememberMeCheckboxPresent() {
        return rememberMeCheckBox.isElementPresent();
    }

    @Override
    public void clickLogin() {
        loginBtn.click();
    }

    @Override
    public boolean isLoginBtnPresent() {
        return loginBtn.isElementPresent();
    }

    @Override
    public void clickForgottenPassword() {
        forgotPasswordBtn.click();
    }

    @Override
    public boolean isForgotPasswordPresent() {
        return forgotPasswordBtn.isElementPresent();
    }
}
