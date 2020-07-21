package org.example.untitled;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    public static LoginPage loginPage;
    public static MailPage mailPage;
    public static WebDriver driver;

    @BeforeClass
    public static void  setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://gmail.com");

    }
    @Test
    public void mainPageTest() {
        loginPage.loginInput("test.ui.simbirsoft@gmail.com");
        loginPage.loginBtnClick();
        loginPage.passwordInput("jojojos12");
        loginPage.passwordBtnClick();
        int lettersCount = mailPage.lettersCount();
        mailPage.btnComposeClick();
        mailPage.toFieldInput("test.ui.simbirsoft@gmail.com");
        mailPage.subjectFieldInput("Simbirsoft theme");
        if (lettersCount < 5)
            mailPage.textAreaInput("Найдено " + lettersCount + " письма");
        else
            mailPage.textAreaInput("Найдено " + lettersCount + " писем");
        mailPage.btnSendClick();
        Assert.assertTrue(mailPage.newLettersCount(lettersCount) > lettersCount);
    }
    @AfterTest
    public void close() {
        driver.close();
    }
}