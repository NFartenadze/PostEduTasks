package com.solvd.gui.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverService {
    private static final Logger LOGGER = LogManager.getLogger(DriverService.class);
    private static final String selenium_server = Configuration.getProperty("selenium-server");

    public static void setup() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(Configuration.getProperty("browserName"));
        try {
            WebDriverPool.add(new RemoteWebDriver(new URL(selenium_server), desiredCapabilities));
        } catch (MalformedURLException e) {
            LOGGER.error("MalFormedURLException occured while setting up driver");
            throw new RuntimeException(e);
        }
    }

    public static void terminateDriver() {
        WebDriver driver = WebDriverPool.get();
        driver.close();
        driver.quit();
    }
}
