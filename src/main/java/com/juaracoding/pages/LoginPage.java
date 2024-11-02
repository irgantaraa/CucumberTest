package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[text()='Products']")
    private WebElement txtProducts;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtInvalid;

    @FindBy(xpath = "//img[@alt='company-branding']")
    private WebElement imgCompanyBranding;

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement btnLogout;

    //h3[@data-test='error']

    public void loginUser(String username, String password){
        this.username.sendKeys(username);
        Utils.delay(2);
        this.password.sendKeys(password);
    }

    public void setBtnLogin(){
        btnLogin.click();
    }

    public void logout(){
        userDropdown.click();
        btnLogout.click();
    }

    public void clearUsernamePassword(){
        username.sendKeys(Keys.CONTROL+"a");
        username.sendKeys(Keys.DELETE);
        password.sendKeys(Keys.CONTROL+"a");
        password.sendKeys(Keys.DELETE);
    }

    public String getTxtProducts(){
        return txtProducts.getText();
    }

    public String getTxtInvalid(){
        return txtInvalid.getText();
    }


}