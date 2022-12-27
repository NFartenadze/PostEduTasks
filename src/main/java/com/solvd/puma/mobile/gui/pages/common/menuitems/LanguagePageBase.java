package com.solvd.puma.mobile.gui.pages.common.menuitems;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.puma.mobile.gui.pages.android.States;
import org.openqa.selenium.WebDriver;

public abstract class LanguagePageBase extends AbstractPage {
    public LanguagePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void closeLanguagePage();

    public abstract void searchLanguage(States state);

    public abstract void selectLanguage();
}
