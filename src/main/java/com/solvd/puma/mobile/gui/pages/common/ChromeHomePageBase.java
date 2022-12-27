package com.solvd.puma.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ChromeHomePageBase extends AbstractPage {
    public ChromeHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void navigateTo(String url);

    public abstract boolean isSearchBarPresent();
}
