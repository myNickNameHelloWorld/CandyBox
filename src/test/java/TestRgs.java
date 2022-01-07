import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestRgs {
    WebDriver webDriver;
    WebDriverWait wait;

    @Before
    public void before() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("https://rgs.ru/");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='/for-companies']")));
    }

    @Test
    public void test() {
        //Закрыте куки-соглашения
        WebElement cookiesClose = webDriver.findElement(By.xpath("//button[@class='btn--text']"));
        cookiesClose.click();

        //Клик по кнопке "Компаниям"
        WebElement companies = webDriver.findElement(By.cssSelector("[href='/for-companies']"));
        companies.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='item text--basic current' and contains(@li, Проектировщиков)]")));

        //Клик по кнопке "Здоровье"
        WebElement health = webDriver.findElement(By.xpath("//span[@class='padding' and text()='Здоровье']"));
        health.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/for-companies/zdorove/dobrovolnoe-meditsinskoe-strakhovanie' and contains(@a, Добровольное)]")));

        //Клик по кнопке "Добровольное медецинское страхование"
        WebElement healthInsurance = webDriver.findElement(By.xpath("//a[@href='/for-companies/zdorove/dobrovolnoe-meditsinskoe-strakhovanie' and contains(@a, Добровольное)]"));
        healthInsurance.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='action-item btn--basic' and contains(@span, Отправить)]")));

        //Клик по кнопке "Отправить заявку"
        WebElement sendRequest = webDriver.findElement(By.xpath("//button[@class='action-item btn--basic' and contains(@span, Отправить)]"));
        sendRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='userName']")));

        //Проверка заголовка
        String headTittle = webDriver.getTitle();
        Assert.assertTrue(headTittle.equals("Добровольное медицинское страхование для компаний и юридических лиц в Росгосстрахе"));

        //Клик по кнопке "Отправить заявку"
        WebElement text = webDriver.findElement(By.xpath("//h2[@class='section-basic__title title--h2 word-breaking title--h2' and text()='Оперативно перезвоним']"));
        String tittle = text.getText();
        Assert.assertTrue(tittle.equals("Оперативно перезвоним\n" + "для оформления полиса"));

        //Заполнение полей и проверка введеных значений
        String xPath = "//input[@placeholder='%s']";
        fillInputField(webDriver.findElement(By.xpath(String.format(xPath, "Иванов Иван Иванович"))), "Гомер Симпсон");
        fillInputFieldPhone(webDriver.findElement(By.xpath(String.format(xPath, "+7 XXX XXX XX XX"))), "9997775533");
        fillInputField(webDriver.findElement(By.xpath(String.format(xPath, "hello@email.com"))), "qwertyqwerty");
        fillInputField(webDriver.findElement(By.xpath(String.format(xPath, "Введите"))), "Спрингфилд");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='checkbox-body form__checkbox']")));

        //Клик по кнопке "Обработка персональных данных"
        WebElement checkBox = webDriver.findElement(By.xpath("//div[@class='checkbox-body form__checkbox']"));
        checkBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='form__button-submit btn--basic']")));


        //Клик по кнопке "Свяжитесь со мной"
        WebElement clickSubmit = webDriver.findElement(By.xpath("//button[@class='form__button-submit btn--basic']"));
        clickSubmit.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"userEmail\"]/../../span")));

        //Проверка, что у поля email присутствует сообщение об ошибке
        WebElement errorAlert = webDriver.findElement(By.xpath("//input[@name=\"userEmail\"]/../../span"));
        Assert.assertEquals("Проверка ошибки у почты", "Введите корректный адрес электронной почты", errorAlert.getText());
    }

    @After
    public void after() {
        webDriver.quit();
    }

    private void fillInputField(WebElement webElement, String value) {
        waitUtilElementToBeClickable(webElement);
        webElement.sendKeys(value);
        boolean checkFlag = wait.until(ExpectedConditions.attributeContains(webElement, "value", value));
        Assert.assertTrue("Поле заполнено некорректно", checkFlag);
    }

    private void fillInputFieldPhone(WebElement webElement, String value) {
        String xPathPhone = "//input[@placeholder='%s']";
        waitUtilElementToBeClickable(webElement);
        webElement.sendKeys(value);
        String phone = webDriver.findElement(By.xpath(String.format(xPathPhone, "+7 XXX XXX XX XX"))).getAttribute("value");
        Assert.assertEquals("Поле заполнено некорректно", "+7 (999) 777-5533", phone);
    }

    private void waitUtilElementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
