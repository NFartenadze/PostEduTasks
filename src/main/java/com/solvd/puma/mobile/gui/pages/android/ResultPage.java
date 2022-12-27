package com.solvd.puma.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.puma.mobile.gui.pages.common.ResultPageBase;
import com.solvd.puma.mobile.gui.pages.common.menuitems.ItemPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ResultPageBase.class)
public class ResultPage extends ResultPageBase {
    @FindBy(xpath = "")
    private List<ExtendedWebElement> resultItems;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void printResultItemTexts() {

    }

    @Override
    public boolean areElementsPresent() {
        return false;
    }

    @Override
    public ItemPageBase selectSearchedItem(int i) {
        resultItems.get(i).click();
        return initPage(getDriver(), ItemPageBase.class);
    }
}
