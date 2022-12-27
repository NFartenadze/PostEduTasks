package org.gui.pages;

import com.solvd.puma.gui.service.DriverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class AbstractTest {
    protected static final Logger LOGGER = LogManager.getLogger(AbstractTest.class);

    @BeforeMethod
    public void setup() {
        DriverService.setup();
        LOGGER.info("driver setup");
    }

    @AfterMethod
    public void terminate() {
        DriverService.terminateDriver();
        LOGGER.info("driver quited");
    }
}
