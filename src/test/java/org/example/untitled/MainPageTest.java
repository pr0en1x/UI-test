package org.example.untitled;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainPageTest extends BaseTest {
    public static WebDriver driver;

    @Test
    public void mainPageTest() throws IOException {
        driver.get("http://gmail.com");
        LoginPage loginPage = new LoginPage(driver);
        MailPage mailPage = loginPage.loginWithCorrectLoginAndPassword();
        int lettersCount = mailPage.lettersCount();
        mailPage.sendMessage();
        Assert.assertTrue(mailPage.newLettersCount(lettersCount) > lettersCount);
    }
}