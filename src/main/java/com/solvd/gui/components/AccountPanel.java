package com.solvd.gui.components;

import com.solvd.gui.pages.AbstractPage;
import com.solvd.gui.pages.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPanel extends AbstractPage {
    private static final Logger logger = LogManager.getLogger(AccountPanel.class);

    @FindBy(xpath = "//a[@class='tw-ceac4s tw-xbcb1y']")
    private List<WebElement> accountMenuItems;

    @FindBy(xpath = "//span[contains(text(),'Language')]")
    private WebElement language;
    @FindBy(xpath = "//a[@data-test-id='login-button']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[@data-test-id='register-button']")
    private WebElement registerButton;

    public AccountPanel(WebDriver driver) {
        super(driver);
    }

    public boolean isLanguagePresent() {
        return language.isDisplayed();
    }

    public LanguagePanel clickLanguage() {
        logger.info("language button clicked");
        return new LanguagePanel(getDriver());
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isDisplayed();
    }

    public boolean isRegisterButtonPresent() {
        return registerButton.isDisplayed();
    }

    public boolean isMenuItemPresent(MenuItems i) {
        return accountMenuItems.get(i.getItemIndex()).isDisplayed();
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public RegistrationPage clickRegisterButton() {
        click(registerButton);
        return new RegistrationPage(getDriver());
    }

    public void clickMenuItem(MenuItems i) {
        click(accountMenuItems.get(i.getItemIndex()));
    }

    public enum MenuItems {
        MY_ACCOUNT(0),
        INITIATE_RETURN(1),
        SUPPORT(2),
        WISHLIST(3);

        private int itemIndex;

        MenuItems(int itemIndex) {
            this.itemIndex = itemIndex;
        }

        public int getItemIndex() {
            return itemIndex;
        }
    }
}
