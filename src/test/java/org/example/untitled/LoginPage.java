package org.example.untitled;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoginPage {
    public WebDriver driver;
    final Path tokenFile = Paths.get(System.getProperty("user.home")).resolve("config");
    final String login = Files.readAllLines(tokenFile).get(0).trim();
    final String password = Files.readAllLines(tokenFile).get(1).trim();

    public LoginPage(WebDriver driver) throws IOException {
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

    public MailPage loginWithCorrectLoginAndPassword() throws IOException {
        loginField.sendKeys(login);
        loginBtn.click();
        passwordField.sendKeys(password);
        passwordBtn.click();
        return new MailPage(driver);
    }
}
