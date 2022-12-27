package com.solvd.puma.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.puma.mobile.gui.pages.common.ResultPageBase;
import com.solvd.puma.mobile.gui.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {
    @FindBy(xpath = "//android.view.View/android.view.View/android.widget.EditText")
    private ExtendedWebElement searchField;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ResultPageBase searchProduct(String s) {
        searchField.type(s);
        return initPage(getDriver(), ResultPageBase.class);
    }

    @Override
    public boolean isSearchFieldPresent() {
        return searchField.isElementPresent();
    }


}
