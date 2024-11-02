package com.juaracoding;
import com.juaracoding.pages.CheckOutPage;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.HomePage;
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

public class CheckOutTest {
    private WebDriver driver;
    private ExtentTest extentTest;
    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private CartPage cartPage = new CartPage();
    private CheckOutPage checkoutPage = new CheckOutPage();

    public CheckOutTest() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;

    }

    @Given("I am logged in to the application")
    public void i_am_logged_in_to_the_application() {
        driver.get(Constants.URL);
        loginPage.loginUser("standard_user", "secret_sauce");
        loginPage.setBtnLogin();
        Utils.delay(3);
        extentTest.log(LogStatus.PASS, "I am logged in to the application");
    }

    @When("I add a product to the cart")
    public void i_add_a_product_to_the_cart() {
        Utils.delay(3);
        homePage.setAddBtnToCart();
        homePage.setCartBtn();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS, "I add a product to the cart");

    }

    @And("I proceed to checkout")
    public void i_proceed_to_checkout() {
        Utils.delay(2);
        cartPage.setBtnCheckout();
        extentTest.log(LogStatus.PASS, "I proceed to checkout");
    }

    @And("I provide valid checkout information")
    public void i_provide_valid_checkout_information() {
        checkoutPage.inputYourInformation("irgantara", "Pratama", "17131");
        Utils.delay(2);
        checkoutPage.setBtnContinue();
        extentTest.log(LogStatus.PASS, "I provide valid checkout information");
    }

    @And("I finish the checkout process")
    public void i_finish_the_checkout_process() {
        checkoutPage.setBtnFinish();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS, "I finish the checkout process");

    }

    @Then("I should see the order confirmation page")
    public void i_should_see_the_order_confirmation_page() {
        checkoutPage.getTxtCheckoutComplete();
        Assert.assertEquals(checkoutPage.getTxtCheckoutComplete(), "Thank you for your order!");
        Utils.delay(2);
        checkoutPage.setBtnBackToProducts();
        extentTest.log(LogStatus.PASS, "I should see the order confirmation page");
    }

    // Negative scenario for empty checkout information
    @And("I provide empty checkout information")
    public void i_provide_empty_checkout_information() {
        checkoutPage.inputYourInformation("", "", ""); // assuming that empty parameters are allowed
        checkoutPage.setBtnContinue();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS, "I provide empty checkout information");
    }

//    @And("I try to finish the checkout process")
//    public void i_try_to_finish_the_checkout_process() {
//        checkoutPage.setBtnFinish();
//        extentTest.log(LogStatus.PASS, "I try to finish the checkout process");
//    }

    @Then("I should see an error message indicating that the information is required")
    public void i_should_see_an_error_message_indicating_that_the_information_is_required() {
        String errorMessage = checkoutPage.getTxtError();
        Assert.assertEquals(errorMessage, "Error: First Name is required");
        extentTest.log(LogStatus.PASS, "I see an error message indicating that the information is required");
    }
}

