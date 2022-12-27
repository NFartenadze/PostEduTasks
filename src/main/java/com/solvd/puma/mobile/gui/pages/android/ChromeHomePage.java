package com.solvd.puma.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.puma.mobile.gui.pages.common.ChromeHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChromeHomePageBase.class)
public class ChromeHomePage extends ChromeHomePageBase {
    @FindBy(xpath = "com.android.chrome:id/search_box_text")
    ExtendedWebElement searchBar;

    public ChromeHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void navigateTo(String url) {
        searchBar.type(url);
        searchBar.sendKeys(Keys.ENTER);
    }

    @Override
    public boolean isSearchBarPresent() {
        return searchBar.isElementPresent();
    }
}
