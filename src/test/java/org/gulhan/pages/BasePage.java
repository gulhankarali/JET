package org.gulhan.pages;

import org.gulhan.utils.DriverManager;
import org.gulhan.utils.MobileUtils;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
    protected AppiumDriver driver;
    protected MobileUtils mobileUtils;

    public BasePage() {
        DriverManager driverManager = new DriverManager();
        this.driver = driverManager.getDriver(); 
        this.mobileUtils = new MobileUtils(driver);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

}
