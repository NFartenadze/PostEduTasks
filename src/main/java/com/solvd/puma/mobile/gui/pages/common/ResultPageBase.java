package com.solvd.puma.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.puma.mobile.gui.pages.common.menuitems.ItemPageBase;
import org.openqa.selenium.WebDriver;

public abstract class ResultPageBase extends AbstractPage {
    public ResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void printResultItemTexts();

    public abstract boolean areElementsPresent();

    public abstract ItemPageBase selectSearchedItem(int i);
}
