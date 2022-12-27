package com.solvd.puma.mobile.gui.pages.common.menuitems;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class RegistrationPageBase extends AbstractPage {
    public RegistrationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeFirstName(String s);

    public abstract boolean isFirstNameFieldPresent();

    public abstract void typeLastName(String s);

    public abstract boolean isLastNameFieldPresent();

    public abstract void typeEmail(String s);

    public abstract boolean isEmailFieldPresent();

    public abstract void typePassword(String s);

    public abstract boolean isPasswordFieldPresent();

    public abstract void checkAddToMailingList();

    public abstract boolean isAddToMailingListCheckboxPresent();

    public abstract void clickRegister();

    public abstract boolean isRegisterBtnPresent();
}
