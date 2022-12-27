package com.solvd.puma.mobile.gui.pages.common.menuitems;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SupportPageBase extends AbstractPage {
    public SupportPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getEmail();

    public abstract boolean isEmailPresent();

    public abstract String getNumber();

    public abstract boolean isNumberPresent();

}
