package org.example.untitled;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {
    public static WebDriver driver;

    @Test
    public void mainPageTest() {
        driver.get("http://gmail.com");
        LoginPage loginPage = new LoginPage(driver);
        MailPage mailPage = loginPage.loginWithCorrectLoginAndPassword();
        int lettersCount = mailPage.lettersCount();
        mailPage.sendMessage();
        Assert.assertTrue(mailPage.newLettersCount(lettersCount) > lettersCount);
    }
}