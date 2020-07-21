package org.example.untitled;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MailPage {
    public WebDriver driver;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='y6' and contains(.,'Simbirsoft theme')]")
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

    public void btnSendClick() {
        btnSend.click();
    }

    public void toFieldInput(String to) {
        toField.sendKeys(to);
    }

    public void subjectFieldInput(String subject) {
        subjectField.sendKeys(subject);
    }

    public void textAreaInput(String text) {
        textArea.sendKeys(text);
    }

    public void btnComposeClick() {
        btnCompose.click();
    }

    public int lettersCount() {
        return themes.size();
    }

    public int newLettersCount(int n) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='y6' and contains(.,'Simbirsoft theme')]"), n));
        return themes.size();
    }
}
