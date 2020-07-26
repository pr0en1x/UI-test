package org.example.untitled;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class MailPage {
    public WebDriver driver;
    final Path tokenFile = Paths.get(System.getProperty("user.home")).resolve("config");
    final String login = Files.readAllLines(tokenFile).get(0).trim();

    public MailPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".y6")
    private List<WebElement> themes;

    @FindBy(css = ".aic")
    private WebElement btnCompose;

    @FindBy(name = "to")
    private WebElement toField;

    @FindBy(name = "subjectbox")
    private WebElement subjectField;

    @FindBy(css = ".editable")
    private WebElement textArea;

    @FindBy(css = ".dC")
    private WebElement btnSend;

    public void sendMessage() {
        int count = lettersCount();
        btnCompose.click();
        toField.sendKeys(login);
        subjectField.sendKeys("Simbirsoft theme");
        if (count < 5)
            textArea.sendKeys("Найдено " + count + " письма");
        else
            textArea.sendKeys("Найдено " + count + " писем");
        btnSend.click();
    }

    public int lettersCount() {
        List<WebElement> sortedList = themes.stream().filter(e -> e.getText().contains("Simbirsoft theme")).collect(Collectors.toList());
        return sortedList.size();
    }

    public int newLettersCount(int n) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='y6' and contains(.,'Simbirsoft theme')]"), n));
        return lettersCount();
    }
}
