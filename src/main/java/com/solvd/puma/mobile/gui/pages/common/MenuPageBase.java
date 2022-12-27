package com.solvd.puma.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.puma.mobile.gui.pages.common.menuitems.*;
import org.openqa.selenium.WebDriver;

public abstract class MenuPageBase extends AbstractPage {
    public MenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickGiftGuide();

    public abstract boolean isGiftGuidePresent();

    public abstract void clickNewArrivals();

    public abstract boolean isNewArrivalsPresent();

    public abstract void clickWomen();

    public abstract boolean isWomenPresent();

    public abstract void clickMen();

    public abstract boolean isMenPresent();

    public abstract void clickKids();

    public abstract boolean isKidsPresent();

    public abstract void clickCollaborations();

    public abstract boolean isCollaborationsPresent();

    public abstract void clickSport();

    public abstract boolean isSportPresent();

    public abstract void clickSale();

    public abstract boolean isSalePresent();

    public abstract MyAccountPageBase clickMyAccount();

    public abstract boolean isMyAccountPresent();

    public abstract InitiateReturnPageBase clickInitiateReturn();

    public abstract boolean isInitiateReturnPresent();

    public abstract SupportPageBase clickSupport();

    public abstract boolean isSupportPresent();

    public abstract WishListPageBase clickWishList();

    public abstract boolean isWishListPresent();

    public abstract LanguagePageBase clickLanguage();

    public abstract boolean isLanguagePresent();

    public abstract LoginPageBase clickLoginBtn();

    public abstract boolean isLoginBtnPresent();

    public abstract RegistrationPageBase clickRegisterBtn();

    public abstract boolean isRegistrationBtnPresent();


}
