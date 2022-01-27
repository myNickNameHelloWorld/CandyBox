package ru.ibs.appline.framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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


    protected void scrollToElementJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected WebElement clickElementJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getWebDriver();
        js.executeScript("arguments[0].click();", element);
        return element;
    }

    protected WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitUntilVisibilityOf(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitUntilTextToBePresent(WebElement element, String text) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected Boolean waitUntilInvisibilityOf(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected int strToInt(String str) {
        str = str.replaceAll("[^0-9]", "");
        return Integer.parseInt(str);
    }

    protected void waitUntilSwitchText(WebElement element) {
        String str = element.getText();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, str)));
    }

    public void actionsActions(WebElement element) {
        Actions actions = new Actions(driverManager.getWebDriver());
        actions.moveToElement(element).click(element).build().perform();
    }

    protected void sleep(int millsec) {
        try {
            Thread.sleep(millsec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
