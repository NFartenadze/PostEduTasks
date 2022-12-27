package com.solvd.puma.mobile.gui.pages.android.menuitems;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.puma.mobile.gui.pages.common.menuitems.RegistrationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = RegistrationPageBase.class)
public class RegistrationPage extends RegistrationPageBase {
    @FindBy(id = "first-name")
    private ExtendedWebElement firstNameField;
    @FindBy(id = "last-name")
    private ExtendedWebElement lastNameField;
    @FindBy(id = "email")
    private ExtendedWebElement emailField;
    @FindBy(id = "password")
    private ExtendedWebElement passwordField;
    @FindBy(id = "email-list")
    private ExtendedWebElement addToEmailListCheckBox;
    @FindBy(id = "register")
    private ExtendedWebElement registerBtn;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeFirstName(String s) {
        firstNameField.type(s);
    }

    @Override
    public boolean isFirstNameFieldPresent() {
        return firstNameField.isElementPresent();
    }

    @Override
    public void typeLastName(String s) {
        lastNameField.type(s);
    }

    @Override
    public boolean isLastNameFieldPresent() {
        return lastNameField.isElementPresent();
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
    public void checkAddToMailingList() {
        addToEmailListCheckBox.check();
    }

    @Override
    public boolean isAddToMailingListCheckboxPresent() {
        return addToEmailListCheckBox.isElementPresent();
    }

    @Override
    public void clickRegister() {
        registerBtn.click();
    }

    @Override
    public boolean isRegisterBtnPresent() {
        return registerBtn.isElementPresent();
    }
}
