package org.example.untitled;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import static org.example.untitled.MainPageTest.driver;

@Listeners({CustomTestListener.class})
public class BaseTest {
    @BeforeTest
    public static void  setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterSuite
    public void close() {
        driver.close();
    }
}
