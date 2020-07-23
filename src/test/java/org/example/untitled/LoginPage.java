package org.example.untitled;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "identifierId")
    private WebElement loginField;

    @FindBy(id = "identifierNext")
    private WebElement loginBtn;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "passwordNext")
    private WebElement passwordBtn;

    public MailPage loginWithCorrectLoginAndPassword() {
        loginField.sendKeys(ConfProperties.getProperty("login"));
        loginBtn.click();
        passwordField.sendKeys(ConfProperties.getProperty("password"));
        passwordBtn.click();
        return new MailPage(driver);
    }
}
