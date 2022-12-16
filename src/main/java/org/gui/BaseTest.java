package org.gui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop;

    public BaseTest() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/resources/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initialization() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        //unable to read properties from file
//        String browserName = prop.getProperty("browserName");
//        String seleniumServer = prop.getProperty("selenium-server");
//        String url = prop.getProperty("url");
//        if (browserName.equals("chrome")) {
//            WebDriverManager.chromedriver().setup();
////            System.setProperty("webdriver.chrome.driver", "/Users/nikafartenadze/Desktop/selenium/chromedriver");
//            caps.setBrowserName(prop.getProperty(browserName));
//            driver = new RemoteWebDriver(new URL(prop.getProperty(seleniumServer)), caps);
//            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        }
//        driver.manage().window().maximize();
//        driver.get(prop.getProperty(url));


        String browserName = "chrome";
        String seleniumServer = "http://172.20.10.2:4444";
        String url = "https://us.puma.com/us/en";

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
//            System.setProperty("webdriver.chrome.driver", "/Users/nikafartenadze/Desktop/selenium/chromedriver");
            caps.setBrowserName(browserName);
            driver = new RemoteWebDriver(new URL(seleniumServer), caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void enterTextBy(By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).sendKeys(text);
    }


}
