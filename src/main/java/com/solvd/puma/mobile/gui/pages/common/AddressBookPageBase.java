package com.solvd.puma.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.puma.mobile.gui.pages.android.States;
import org.openqa.selenium.WebDriver;

public abstract class AddressBookPageBase extends AbstractPage {
    public AddressBookPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectState(States state);

    public abstract boolean isPhoneNumberFieldPresent();

    public abstract void typePhoneNumber(String s);

    public abstract boolean isPostalCodeFieldPresent();

    public abstract void clickBackToMyAccountButton();

    public abstract void checkMakeDefault();

    public abstract void typeFirstName(String s);

    public abstract void typeLastName(String s);

    public abstract boolean isFirstNameFieldPresent();

    public abstract boolean isLastNameFieldPresent();

    public abstract boolean isAddressTitleFieldPresent();

    public abstract boolean isStreetNumberFieldPresent();

    public abstract boolean isCompanyInfoFieldPresent();

    public abstract boolean isSaveBtnPresent();

    public abstract void clickSaveBtn();

    public abstract boolean isCityFieldPresent();

    public abstract void typeStreetNumber(String s);

    public abstract void typeCompanyInfo(String s);

    public abstract void typeAddressTitle(String s);

    public abstract void typeCity(String s);

    public abstract void typePostalCode(String s);

    public abstract boolean isCountrySelectorPresent();

    public abstract void selectCountry(String s);

}
