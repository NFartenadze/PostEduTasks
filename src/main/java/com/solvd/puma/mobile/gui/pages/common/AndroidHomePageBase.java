package com.solvd.puma.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AndroidHomePageBase extends AbstractPage {
    public AndroidHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ChromeHomePageBase openChrome();

    public abstract boolean isChromePresent();


}
