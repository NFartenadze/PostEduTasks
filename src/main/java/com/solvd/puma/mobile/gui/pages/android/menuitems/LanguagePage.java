package com.solvd.puma.mobile.gui.pages.android.menuitems;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.puma.mobile.gui.pages.android.States;
import com.solvd.puma.mobile.gui.pages.common.menuitems.LanguagePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LanguagePageBase.class)
public class LanguagePage extends LanguagePageBase {

    @FindBy(id = "location-selector-input")
    private ExtendedWebElement searchField;
    @FindBy(xpath = "//android.app.Dialog/android.widget.Button\n")
    private ExtendedWebElement closeBtn;
    @FindBy(xpath = "//android.widget.ListView/android.view.View[1]/android.view.MenuItem[1]")
    private ExtendedWebElement searchedLanguage;


    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void closeLanguagePage() {
        closeBtn.click();
    }

    @Override
    public void searchLanguage(States state) {
        searchField.type(state.getState());
    }

    @Override
    public void selectLanguage() {
        searchedLanguage.click();
    }

}
