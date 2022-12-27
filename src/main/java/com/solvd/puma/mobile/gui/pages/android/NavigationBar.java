package com.solvd.puma.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.puma.mobile.gui.pages.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NavigationBarBase.class)
public class NavigationBar extends NavigationBarBase {
    @FindBy(xpath = "//android.view.View[2]/android.view.View/android.widget.Button[1]")
    private ExtendedWebElement searchIcon;
    @FindBy(id = "nav-wishlist-link")
    private ExtendedWebElement wishListIcon;
    @FindBy(id = "nav-cart-link")
    private ExtendedWebElement cartIcon;
    @FindBy(xpath = "//android.view.View[2]/android.view.View/android.widget.Button[2]")
    private ExtendedWebElement menuToggle;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public MenuPageBase openMenuPage() {
        menuToggle.click();
        return initPage(getDriver(), MenuPageBase.class);
    }

    @Override
    public boolean isMenuPresent() {
        return menuToggle.isElementPresent();
    }

    @Override
    public CartPageBase openCartPage() {
        cartIcon.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public boolean isCartPresent() {
        return cartIcon.isElementPresent();
    }

    @Override
    public SearchPageBase openSearchPage() {
        searchIcon.click();
        return initPage(getDriver(), SearchPageBase.class);
    }

    @Override
    public boolean isSearchPresent() {
        return searchIcon.isElementPresent();
    }

    @Override
    public WishListPageBase openWishList() {
        return initPage(getDriver(), WishListPageBase.class);
    }

    @Override
    public boolean isWishListPresent() {
        return wishListIcon.isElementPresent();
    }
}
