package steps;

import core.DriverFactory;
import core.TestConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private DriverFactory driverFactory = null;

    @Before
    public void initBrowser() {
        driverFactory = new DriverFactory();
        BaseSteps.setDriver(driverFactory.getWebDriver(TestConfig.getProperty("browser")));
    }

    @After(order = 0)
    public void closeBrowser() {
        driverFactory.quitDriver();
    }
}
