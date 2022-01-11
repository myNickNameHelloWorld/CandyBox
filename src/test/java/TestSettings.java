import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestSettings {
    WebDriver webDriver;
    WebDriverWait wait;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("https://rgs.ru/");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='/for-companies']")));
    }

    @AfterEach
    public void after() {
        webDriver.quit();
    }
}
