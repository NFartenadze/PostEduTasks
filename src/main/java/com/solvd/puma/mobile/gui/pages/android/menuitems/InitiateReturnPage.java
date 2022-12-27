package com.solvd.puma.mobile.gui.pages.android.menuitems;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.puma.mobile.gui.pages.common.menuitems.InitiateReturnPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = InitiateReturnPageBase.class)
public class InitiateReturnPage extends InitiateReturnPageBase {
    @FindBy(id = "order-no")
    private ExtendedWebElement orderNumberField;
    @FindBy(id = "order-email")
    private ExtendedWebElement emailField;
    @FindBy(id = "billing-postal-code")
    private ExtendedWebElement postalCodeField;
    @FindBy(xpath = "submit-button")
    private ExtendedWebElement submitBtn;

    public InitiateReturnPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeOrderNumber(String s) {
        orderNumberField.type(s);
    }

    @Override
    public boolean isOrderNumberFieldPresent() {
        return orderNumberField.isElementPresent();
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
    public void typePostalCode(String s) {
        postalCodeField.type(s);
    }

    @Override
    public boolean isPostalCodeFieldPresent() {
        return postalCodeField.isElementPresent();
    }

    @Override
    public void clickSubmit() {
        submitBtn.click();
    }

    @Override
    public boolean isSubmitBtnPresent() {
        return submitBtn.isElementPresent();
    }
}
