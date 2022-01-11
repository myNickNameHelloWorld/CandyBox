import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestRgs extends TestSettings {

    @ParameterizedTest
//    @ValueSource(strings = {"Гомер Симпсон", "Джоджо Бинкс", "Безумны Макс"})
    @CsvSource(value = {"Гомер Симпсон, Спрингфилд", "Джоджо Бинкс, Набу", "Безумны Макс, Земля"})
    public void test(String s, String st) {
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
        Assertions.assertTrue(headTittle.equals("Добровольное медицинское страхование для компаний и юридических лиц в Росгосстрахе"), "Проверка заголовка страницы");

        //Клик по кнопке "Отправить заявку"
        WebElement text = webDriver.findElement(By.xpath("//h2[@class='section-basic__title title--h2 word-breaking title--h2' and text()='Оперативно перезвоним']"));
        String tittle = text.getText();
        Assertions.assertTrue(tittle.equals("Оперативно перезвоним\n" + "для оформления полиса"), "Проверка заголовка поля ввода");

        //Заполнение полей и проверка введеных значений
        String xPath = "//input[@placeholder='%s']";
        fillInputField(webDriver.findElement(By.xpath(String.format(xPath, "Иванов Иван Иванович"))), s);
        fillInputFieldPhone(webDriver.findElement(By.xpath(String.format(xPath, "+7 XXX XXX XX XX"))), "9997775533");
        fillInputField(webDriver.findElement(By.xpath(String.format(xPath, "hello@email.com"))), "qwertyqwerty");
        fillInputField(webDriver.findElement(By.xpath(String.format(xPath, "Введите"))), st);
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
        Assertions.assertEquals("Введите корректный адрес электронной почты", errorAlert.getText(), "Проверка ошибки у почты");
    }


    private void fillInputField(WebElement webElement, String value) {
        waitUtilElementToBeClickable(webElement);
        webElement.sendKeys(value);
        boolean checkFlag = wait.until(ExpectedConditions.attributeContains(webElement, "value", value));
        Assertions.assertTrue(checkFlag, "Поле заполнено некорректно");
    }

    private void fillInputFieldPhone(WebElement webElement, String value) {
        String xPathPhone = "//input[@placeholder='%s']";
        waitUtilElementToBeClickable(webElement);
        webElement.sendKeys(value);
        String phone = webDriver.findElement(By.xpath(String.format(xPathPhone, "+7 XXX XXX XX XX"))).getAttribute("value");
        Assertions.assertEquals("+7 (999) 777-5533", phone, "Поле заполнено некорректно");
    }

    private void waitUtilElementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
