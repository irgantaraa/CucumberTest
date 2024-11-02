package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage   {
    private WebDriver driver;

    public CheckOutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipPostalCode;

    @FindBy(xpath = "//input[@id='continue']") // button continue https://www.saucedemo.com/checkout-step-one.html
    private WebElement btnContinue;

    @FindBy(xpath = "//button[@id='finish']") // button finish https://www.saucedemo.com/checkout-step-two.html
    private WebElement btnFinish;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement txtCheckoutComplete;


    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement btnBackToProducts;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtError;

    public void inputYourInformation(String firstName, String lastName, String zipPostalCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipPostalCode.sendKeys(zipPostalCode);

    }

    public void setBtnContinue() {
        btnContinue.click();
    }

    public void setBtnFinish(){

        btnFinish.click(); // button finish ke checkout
    }

    public void setBtnBackToProducts(){
        btnBackToProducts.click();
    }

    public String getTxtCheckoutComplete(){

        return txtCheckoutComplete.getText();
    }

    public String getTxtError(){
        return txtError.getText();
    }


}
