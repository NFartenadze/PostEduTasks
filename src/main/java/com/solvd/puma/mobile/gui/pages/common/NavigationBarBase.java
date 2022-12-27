package com.solvd.puma.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NavigationBarBase extends AbstractPage {
    public NavigationBarBase(WebDriver driver) {
        super(driver);
    }

    public abstract MenuPageBase openMenuPage();

    public abstract boolean isMenuPresent();

    public abstract CartPageBase openCartPage();

    public abstract boolean isCartPresent();

    public abstract SearchPageBase openSearchPage();

    public abstract boolean isSearchPresent();

    public abstract WishListPageBase openWishList();

    public abstract boolean isWishListPresent();
}
