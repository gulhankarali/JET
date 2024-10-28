package org.gulhan.utils;
import java.io.IOException;
import java.util.Properties;

import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumCapabilitiesManager {

    public UiAutomator2Options getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try {
            TestUtils.log().info("getting capabilities");
            UiAutomator2Options options = new UiAutomator2Options();

            switch (params.getPlatformName()) {
                case "Android":
                    String androidAppUrl = props.getProperty("AppFileNameAndroid");
                    System.out.println("androidAppUrl = " + androidAppUrl);
                    TestUtils.log().info("appUrl is" + androidAppUrl);
                    options.setUdid(props.getProperty("udid"));
                    options.setDeviceName(props.getProperty("deviceName"));
                    options.setAutomationName(props.getProperty("androidAutomationName"));
                    options.setSystemPort(params.getSystemPort());
                    options.setApp(androidAppUrl);
                    break;
                case "iOS":
                    break;
            }
            return options;
        } catch (Exception e) {
            e.printStackTrace();
            TestUtils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
}
