package org.example.untitled;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static org.example.untitled.MainPageTest.driver;

public class BaseTest {
    @BeforeTest
    public static void  setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterSuite
    public void close() {
        driver.close();
    }
}
