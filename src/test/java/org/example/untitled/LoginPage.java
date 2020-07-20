package org.example.untitled;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public  LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(id = "identifierId")
    private WebElement loginField;


    @FindBy(id = "identifierNext")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[contains(@name, 'password')]")
    private WebElement passwordField;

    @FindBy(id = "passwordNext")
    private WebElement passwordBtn;

    public void loginInput(String login) {
        loginField.sendKeys(login);
    }

    public void loginBtnClick() {
        loginBtn.click();
    }

    public void passwordInput(String password) {
        passwordField.sendKeys(password);
    }

    public void passwordBtnClick() {
        passwordBtn.click();
    }
}
