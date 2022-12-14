package org.gui.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://us.puma.com/us/en");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

        //search bar
        WebElement searchBar = driver.findElement(By.xpath("//input['data-test-id=\"search-box\"']"));
        searchBar.sendKeys("Bag");
        searchBar.sendKeys(Keys.ENTER);

//        List<WebElement> searchResult = driver.findElements(By.xpath("//a[@data-test-id=\"product-list-item-link\"]"));

        //searched items list
        List<WebElement> searchResult = driver.findElements(By.xpath("//ul[@id=\"product-list-items\"]/li/div[3]/a/h3"));
        searchResult.forEach(e -> logger.info(e.getText()));


        driver.quit();
    }
}
