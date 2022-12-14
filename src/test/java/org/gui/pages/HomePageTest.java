package org.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class HomePageTest {

    public static WebDriver driver;

    @Test()
    public void SearchBags() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        try {
            driver = new RemoteWebDriver(new URL("http://10.10.146.218:4444"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.searchBarType("BAG");
        homePage.clickSearch();
        homePage.getSearchResult();
        homePage.printResultItemTexts();
        homePage.quit();
    }
}