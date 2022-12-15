package org.gui.pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseClass extends BaseTest {
    @BeforeMethod
    public void setup() throws MalformedURLException {
        initialization();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}
