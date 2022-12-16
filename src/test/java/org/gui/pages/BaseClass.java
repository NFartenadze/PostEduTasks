package org.gui.pages;

import org.gui.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseClass extends BaseTest {
    @BeforeMethod
    public void setup() throws MalformedURLException {
        BaseTest.initialization();
    }

    @AfterMethod
    public void afterMethod() {
        BaseTest.driver.close();
        BaseTest.driver.quit();
    }
}
