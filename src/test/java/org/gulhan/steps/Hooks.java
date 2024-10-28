package org.gulhan.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;

import java.io.IOException;
import java.util.Properties;

import org.gulhan.utils.MobileUtils;
import org.gulhan.utils.PropertyManager;

public class Hooks extends MobileUtils {

    PropertyManager props = new PropertyManager();
    byte[] screenshot;

    public Hooks() throws Exception {
    }

    @Before
    public void initialize() throws Exception {

    }

    @After
    public void quit(Scenario scenario) throws IOException, InterruptedException
    {
        Properties myprops = props.getProps();
        if (scenario.isFailed())
        {
            screenshot = MobileUtils.getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        
    }
}
