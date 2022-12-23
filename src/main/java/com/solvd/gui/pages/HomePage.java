package com.solvd.gui.pages;

import com.solvd.gui.components.AccountPanel;
import com.solvd.gui.components.NavigationBar;
import com.solvd.gui.service.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class HomePage extends AbstractPage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//button[@data-test-id='location-check-stay-on-country']")
    private WebElement stayOnRegion;
    @FindBy(xpath = "//div[@data-test-id='main-nav-bar']")
    private NavigationBar navigationBar;
    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL(Configuration.getProperty("url"));
    }


    public void clickStayOnRegion() {
        click(stayOnRegion);
    }



    public NavigationBar getNavigationBar() {
        return navigationBar;
    }




}
