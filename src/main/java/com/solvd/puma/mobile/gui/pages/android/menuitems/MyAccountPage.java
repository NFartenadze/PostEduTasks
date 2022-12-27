package com.solvd.puma.mobile.gui.pages.android.menuitems;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.puma.mobile.gui.pages.common.AddressBookPageBase;
import com.solvd.puma.mobile.gui.pages.common.menuitems.MyAccountPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MyAccountPageBase.class)
public class MyAccountPage extends MyAccountPageBase {
    @FindBy(id = "logout")
    private ExtendedWebElement logoutBtn;
    @FindBy(xpath = "//android.view.View[@content-desc=\"EDIT PROFILE\"]/android.view.View/android.widget.TextView[1]")
    private ExtendedWebElement editProfileBtn;
    @FindBy(xpath = "//android.view.View[@content-desc=\"CHANGE PASSWORD\"]/android.view.View/android.widget.TextView[1]")
    private ExtendedWebElement changePasswordBtn;
    @FindBy(xpath = "//android.view.View[@content-desc=\"ADD NEW\"]")
    private ExtendedWebElement addNewBtn;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickLogout() {
        logoutBtn.click();
    }

    @Override
    public boolean isLogoutPresent() {
        return logoutBtn.isElementPresent();
    }

    @Override
    public void clickEditProfile() {
        editProfileBtn.click();
    }

    @Override
    public boolean isEditProfilePresent() {
        return editProfileBtn.isElementPresent();
    }

    @Override
    public void clickChangePassword() {
        changePasswordBtn.click();
    }

    @Override
    public boolean isChangePasswordPresent() {
        return changePasswordBtn.isElementPresent();
    }

    @Override
    public AddressBookPageBase clickAddNew() {
        addNewBtn.click();
        return initPage(getDriver(), AddressBookPageBase.class);
    }

    @Override
    public boolean isAddNewBtnPresent() {
        return addNewBtn.isElementPresent();
    }
}
