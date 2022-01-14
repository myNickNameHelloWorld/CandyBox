package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.framework.managers.DriverManager;
import ru.ibs.appline.framework.managers.PageManager;

import java.time.Duration;

public class BasePage {
    protected DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getWebDriver(), Duration.ofSeconds(10), Duration.ofMillis(1000));

    public BasePage() {
        PageFactory.initElements(driverManager.getWebDriver(), this);
    }

    protected void fillInputField(WebElement webElement, String value) {
        waitUtilElementToBeClickable(webElement);
        webElement.sendKeys(value);
        boolean checkFlag = wait.until(ExpectedConditions.attributeContains(webElement, "value", value));
        Assertions.assertTrue(checkFlag, "Поле заполнено некорректно");
    }

    protected void fillInputFieldPhone(WebElement webElement, String value) {
        String xPathPhone = "//input[@placeholder='%s']";
        waitUtilElementToBeClickable(webElement);
        webElement.sendKeys(value);
        String phone = driverManager.getWebDriver().findElement(By.xpath(String.format(xPathPhone, "+7 XXX XXX XX XX"))).getAttribute("value");
        String valueExpected = String.format("+7 (%s) %s-%s", value.substring(0, 3), value.substring(3, 6), value.substring(6, 10));
        Assertions.assertEquals(valueExpected, phone, "Поле заполнено некорректно");
    }

    protected WebElement waitUtilElementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitUtilVisibilityOfElement(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected Boolean waitUtilInvisibilityOfElement(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }
}
