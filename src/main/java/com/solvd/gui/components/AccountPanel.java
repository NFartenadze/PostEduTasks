package com.solvd.gui.components;

import com.solvd.gui.pages.AbstractPage;
import com.solvd.gui.pages.LoginPage;
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
    @FindBy(xpath = "//a[contains(text(),'Register here')]")
    private WebElement registerButton;

    public AccountPanel(WebDriver driver) {
        super(driver);
    }

    public boolean isLanguagePresent() {
        return isDisplayed(language);
    }

    public LanguagePanel clickLanguage() {
//        new WebDriverWait(WebDriverPool.get(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(language));
        click(language);
        logger.info("language button clicked");
        return new LanguagePanel(getDriver());
    }

    public boolean isLoginButtonPresent() {
        return isDisplayed(loginButton);
    }

    public boolean isRegisterButtonPresent() {
        return isDisplayed(registerButton);
    }

    public boolean isMenuItemPresent(MenuItems i) {
        return isDisplayed(accountMenuItems.get(i.getItemIndex()));
    }

    public LoginPage clickLoginButton() {
        click(loginButton);
        return new LoginPage(getDriver());
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
