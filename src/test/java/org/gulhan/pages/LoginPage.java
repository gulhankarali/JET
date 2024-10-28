package org.gulhan.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

    public LoginPage() throws Exception {
    }

    @AndroidFindBy(xpath = "//android.widget.Button")
    private WebElement button_initial;

    public WebElement getButton_buttonInitial() {
        return button_initial;
    }
    public void clickInitialButton() {
        button_initial.click();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cookie settings']")
    private WebElement text_cookieSettings;

    public WebElement getText_cookieSettings() {
        return text_cookieSettings;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Accept all cookies']")
    private WebElement button_cookies;

    public void clickCookiesButton() {
        button_cookies.click();
    }

    @AndroidFindBy(xpath =  "//android.widget.TextView[@text='Enter address manually']")
    private WebElement text_enterAddressManually;

    public void clickEnterAddressManually() {
        text_enterAddressManually.click();
    }

}
