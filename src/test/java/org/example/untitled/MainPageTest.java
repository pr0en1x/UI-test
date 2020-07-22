package org.example.untitled;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {
    public static LoginPage loginPage;
    public static MailPage mailPage;
    public static WebDriver driver;

    @Test
    public void mainPageTest() {
        driver.get("http://gmail.com");
        loginPage = new LoginPage(driver);
        loginPage.loginInput(ConfProperties.getProperty("login"));
        loginPage.loginBtnClick();
        loginPage.passwordInput(ConfProperties.getProperty("password"));
        loginPage.passwordBtnClick();
        int lettersCount = mailPage.lettersCount();
        mailPage.btnComposeClick();
        mailPage.toFieldInput(ConfProperties.getProperty("login"));
        mailPage.subjectFieldInput("Simbirsoft theme");
        if (lettersCount < 5)
            mailPage.textAreaInput("Найдено " + lettersCount + " письма");
        else
            mailPage.textAreaInput("Найдено " + lettersCount + " писем");
        mailPage.btnSendClick();
        Assert.assertTrue(mailPage.newLettersCount(lettersCount) > lettersCount);
    }
}