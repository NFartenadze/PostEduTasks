package org.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
    public static WebDriver driver;
    public static HomePage homePage;

    @BeforeMethod
    public void setup() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        try {
            driver = new RemoteWebDriver(new URL("http://10.10.146.218:4444"), caps);
            homePage = new HomePage(driver);
            homePage.open();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @AfterMethod
    public void after() {
        homePage.quitBrowser();
        driver.quit();
    }
}
