package org.gulhan.runners;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.ThreadContext;
import org.gulhan.utils.DriverManager;
import org.gulhan.utils.GlobalParams;
import org.gulhan.utils.PropertyManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber.html"
                , "summary"
                , "me.jvt.cucumber.report.PrettyReports:target/cucumber-html-reports"
        }
        ,features = {"src/test/resources"}
        ,glue = {"org.gulhan.steps"}
        ,snippets = CucumberOptions.SnippetType.CAMELCASE
        ,dryRun=false
        ,tags = "@Login"
)
public class CukesRunner {

    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();
        params.initializeGlobalParams();

        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"
                + params.getDeviceName());

        // Uncomment these lines:
        // if (props.getProperty("remoteOrLocal").equalsIgnoreCase("Local"))
        //     new ServerManager().startServer();
        DriverManager.initializeDriver();
        Thread.sleep(1500);

        DriverManager driverManager = new DriverManager(); // Create an instance of DriverManager
        // Cast to the specific driver type that supports getContextHandles()
        AndroidDriver driver = (AndroidDriver) driverManager.getDriver(); 
        Set<String> contexts = driver.getContextHandles(); 
        for (String context : contexts) {
            System.out.println("context: " + context);
        }
    }

    @AfterClass
    public static void quit() throws IOException, InterruptedException {
        Properties props = new PropertyManager().getProps();
        DriverManager driverManager = new DriverManager();
        if (driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);

        }
        // if (props.getProperty("remoteOrLocal").equalsIgnoreCase("Local")) {
        //     ServerManager serverManager = new ServerManager();
        //     if (serverManager.getServer() != null) {
        //         serverManager.getServer().stop();
        //     }
        // }
    }

}
