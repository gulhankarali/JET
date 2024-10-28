package org.gulhan.utils;

import java.io.IOException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriver getDriver() {
        return driver.get();
    }


    public static AppiumDriver initializeDriver() throws Exception {
        AppiumDriver driver = null;
        GlobalParams params = new GlobalParams();
        PropertyManager props = new PropertyManager();

        if (driver == null) {
            try {
                TestUtils utils = new TestUtils(); // Create a new instance
                utils.log().info("initializing Appium driver");
                UiAutomator2Options options = new AppiumCapabilitiesManager().getCaps();
                
                switch (params.getPlatformName()) {
                    case "Android":
                        driver = new AndroidDriver(
                                new URL(props.getProps().getProperty("appiumURL")), 
                                options);
                        break;
                    case "iOS":
                        break;
                }
                if (driver == null) {
                    throw new Exception("driver is null. ABORT!!!");
                }
                utils.log().info("Driver is initialized");
                DriverManager.setDriver(driver);
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return driver;
    }
    public static void setDriver(AppiumDriver driver) {
        DriverManager.driver.set(driver);
    }
}    
