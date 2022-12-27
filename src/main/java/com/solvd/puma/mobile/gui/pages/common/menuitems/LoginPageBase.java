package com.solvd.puma.mobile.gui.pages.common.menuitems;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeEmail(String s);

    public abstract boolean isEmailFieldPresent();

    public abstract void typePassword(String s);

    public abstract boolean isPasswordFieldPresent();

    public abstract void checkRememberMe();

    public abstract boolean isRememberMeCheckboxPresent();

    public abstract void clickLogin();

    public abstract boolean isLoginBtnPresent();

    public abstract void clickForgottenPassword();

    public abstract boolean isForgotPasswordPresent();


}
