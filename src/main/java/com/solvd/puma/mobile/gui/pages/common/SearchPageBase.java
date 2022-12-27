package com.solvd.puma.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchPageBase extends AbstractPage {
    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ResultPageBase searchProduct(String s);

    public abstract boolean isSearchFieldPresent();


}
