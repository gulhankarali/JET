package org.gulhan.steps;
import org.gulhan.pages.LoginPage;
import org.gulhan.utils.MobileUtils;
import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    public LoginSteps() throws Exception {
        super();
    }

    @Given("I am in the initial screen")
    public void i_am_in_the_initial_screen() {
        MobileUtils.waitFor(5);
        Assert.assertTrue(loginPage.getButton_buttonInitial().isDisplayed());
    }

    @When("click the {string} button")
    public void click_the_button(String buttonName) {
        loginPage.clickInitialButton();
    }

    @Then("I am in the {string} screen")
    public void i_am_in_the_screen(String string) {
        Assert.assertTrue(loginPage.getText_cookieSettings().isDisplayed());
    }

    @And("click the {string} button on Cookies screen")
    public void click_the_button_on_cookies_screen(String buttonName) {
        loginPage.clickCookiesButton();
    }
    
    @And("click the {string} button on the next screen")
    public void click_the_button_on_next_screen(String buttonName) {
        loginPage.clickEnterAddressManually();
    }   

        

}
