package org.gui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    protected WebDriver driver;
    By searchResult = By.xpath("//ul[@id=\"product-list-items\"]/li/div[3]/a/h3");
    By searchInput = By.xpath("//input['data-test-id=\"search-box\"']");
    By searchButton = By.xpath("//button[@type=\"submit\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void quitBrowser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();
    }

    public void open() {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "/Users/nikafartenadze/Desktop/selenium/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://us.puma.com/us/en");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public List<WebElement> getSearchResult() {
        return driver.findElements(searchResult);
    }

    public void printResultItemTexts() {
        driver.findElements(searchResult)
                .forEach(e -> logger.info(e.getText()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void searchBarType(String s) {
        driver.findElement(searchInput).sendKeys(s);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
}
