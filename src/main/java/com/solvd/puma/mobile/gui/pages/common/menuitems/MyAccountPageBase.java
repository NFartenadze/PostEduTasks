package com.solvd.puma.mobile.gui.pages.common.menuitems;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.puma.mobile.gui.pages.common.AddressBookPageBase;
import org.openqa.selenium.WebDriver;

public abstract class MyAccountPageBase extends AbstractPage {
    public MyAccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickLogout();

    public abstract boolean isLogoutPresent();

    public abstract void clickEditProfile();

    public abstract boolean isEditProfilePresent();

    public abstract void clickChangePassword();

    public abstract boolean isChangePasswordPresent();

    public abstract AddressBookPageBase clickAddNew();

    public abstract boolean isAddNewBtnPresent();
}
