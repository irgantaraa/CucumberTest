package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {
    private static WebDriver driver;

    private static ExtentTest extentTest;

    private static LoginPage loginPage = new LoginPage();

    public LoginTest() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    // TCC.HR.00001
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS, "I am on the login page");
    }

    @When("I enter a valid username and password")
    public void i_enter_a_valid_username_and_password() {
        loginPage.loginUser("standard_user", "secret_sauce");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS, "I enter a valid username and password");
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS, "I click the login button");
    }

    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_inventory_page() {
        Assert.assertEquals(loginPage.getTxtProducts(), "Products");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS, "I should be redirected to Product page");
    }

    // TCC.HR.00002
    @Given("I am logged out")
    public void i_am_logged_out() {
        loginPage.logout();
        extentTest.log(LogStatus.PASS, "I am logged out");
    }

    @When("I enter an empty username an empty and password")
    public void i_enter_an_invalid_username_or_password() {
        loginPage.loginUser(" ", " ");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS, "I enter empty field");
    }

    @Then("I see message invalid credentials")
    public void i_see_message_invalid_credentials() {
        Assert.assertEquals(loginPage.getTxtInvalid(), "Epic sadface: Username and password do not match any user in this service");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS, "I see message invalid credentials");
    }

    // TCC.HR.00003 - Failed login with empty username
    @When("I enter an empty username and valid password")
    public void I_enter_an_empty_username_and_valid_password() {
        loginPage.loginUser("", "secret_sauce");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS, "I enter an empty username and a valid password");
    }

    @Then("I should see an error message indicating that the username is required")
    public void i_should_see_an_error_message_indicating_that_the_username_is_required() {
        // Update the expected message to match the actual behavior of the application
        Assert.assertEquals(loginPage.getTxtInvalid(), "Epic sadface: Username is required");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS, "I see an error message indicating that the username is required");
    }

    // TCC.HR.00004 - Failed login with empty password
    @When("I enter a valid username and an empty password")
    public void i_enter_a_valid_username_and_an_empty_password() {
        loginPage.loginUser("standard_user", "");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS, "I enter a valid username and an empty password");
    }

    @Then("I should see an error message indicating that the password is required")
    public void i_should_see_an_error_message_indicating_that_the_password_is_required() {
        Assert.assertEquals(loginPage.getTxtInvalid(), "Epic sadface: Password is required");
        Utils.delay(2);
        extentTest.log(LogStatus.PASS, "I see an error message indicating that the password is required");
    }
}

