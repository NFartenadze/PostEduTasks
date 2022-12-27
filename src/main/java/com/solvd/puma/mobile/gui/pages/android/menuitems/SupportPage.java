package com.solvd.puma.mobile.gui.pages.android.menuitems;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.puma.mobile.gui.pages.common.menuitems.SupportPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SupportPageBase.class)
public class SupportPage extends SupportPageBase {
    @FindBy(xpath = "//android.view.View[@content-desc=\"customerservice.us@puma.com\"]/android.widget.TextView")
    private ExtendedWebElement email;
    @FindBy(xpath = "//android.view.View[@content-desc=\"1-888-565-PUMA (7862)\"]")
    private ExtendedWebElement number;

    public SupportPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getEmail() {
        return email.getText();
    }

    @Override
    public boolean isEmailPresent() {
        return email.isElementPresent();
    }

    @Override
    public String getNumber() {
        return number.getText();
    }

    @Override
    public boolean isNumberPresent() {
        return number.isElementPresent();
    }
}
