package org.gui.pages;

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
    WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://us.puma.com/us/en");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        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
        //search bar
        WebElement searchBar = driver.findElement(By.xpath("//input['data-test-id=\"search-box\"']"));
        searchBar.sendKeys("Bag");
        searchBar.sendKeys(Keys.ENTER);
        //searched items list
        List<WebElement> searchResult = driver.findElements(By.xpath("//ul[@id=\"product-list-items\"]/li/div[3]/a/h3"));
        searchResult.forEach(e -> logger.info(e.getText()));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.quit();
    }
}
