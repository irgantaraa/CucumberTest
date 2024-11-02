package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement txtAppLogo;

    // logout
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement menuBtn;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutBtn;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addBtnToCart;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement addBtnToCart2;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartBtn;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement txtCartBadge;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    private WebElement txtRemoveFromCart;

    // Assertion
    public String getTxtAppLogo() {
        return txtAppLogo.getText();
    }

    public void setAddBtnToCart() {

        addBtnToCart.click();
        addBtnToCart2.click();
    }

    public void setCartBtn() {

        cartBtn.click();
    }

    public String getTxtCartBadge() {

        return txtCartBadge.getText();
    }

    public String getTxtRemoveFromCart() {
        return txtRemoveFromCart.getText();
    }
}

