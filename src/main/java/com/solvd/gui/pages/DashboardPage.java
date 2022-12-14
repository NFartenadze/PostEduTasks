package com.solvd.gui.pages;

import com.solvd.gui.service.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends AbstractPage {
    private static final Logger logger = LogManager.getLogger(RegistrationPage.class);

    @FindBy(xpath = "//a[@id = 'edit-profile-button']")
    private WebElement editProfile;

    @FindBy(xpath = "//a[@id = 'edit-password-button']")
    private WebElement editPassword;

    @FindBy(xpath = "//a[@data-test-id='add-new-address']")
    private WebElement addNew;

    public DashboardPage(WebDriver driver) {
        super(driver);
        setPageURL(Configuration.getProperty("url") + "/account");
    }

    public AddressBookPage clickAddNew() {
        click(addNew);
        return new AddressBookPage(getDriver());
    }

    public void clickEditPassword() {
        click(editPassword);
    }

    public void clickEditProfile() {
        click(editProfile);
    }


    public boolean isEditProfilePresent() {
        return isDisplayed(editProfile);
    }

    public boolean isEditPasswordPresent() {
        return isDisplayed(editPassword);
    }

    public boolean isAddNewPresent() {
        return isDisplayed(addNew);
    }


}
