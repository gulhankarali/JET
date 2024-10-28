package org.gulhan.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MobileUtils {
    protected AppiumDriver driver;
    private static final TestUtils utils = new TestUtils();

    public MobileUtils(AppiumDriver driver) {
        DriverManager driverManager = new DriverManager(); 
    
        this.driver = driverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public MobileUtils() {

    }

    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage, int screenCount) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);

    }

    public void scrollElementWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);
    }

    public static void waitFor(int seconds) {
        try { 
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            utils.log().error("Interrupted while waiting", e);
            Thread.currentThread().interrupt();
        }
    }
    public static AppiumDriver getDriver() {
        MobileUtils instance = new MobileUtils();
        return instance.driver;
    }

}
