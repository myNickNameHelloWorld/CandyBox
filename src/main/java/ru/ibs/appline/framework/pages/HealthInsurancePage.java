package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HealthInsurancePage extends BasePage {

    @FindBy(xpath = "//button[@class='action-item btn--basic' and contains(@span, Отправить)]")
    private WebElement sendRequest;

    @FindBy(xpath = "//h2[@class='section-basic__title title--h2 word-breaking title--h2' and text()='Оперативно перезвоним']")
    private WebElement textFieldTitle;

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@name='userTel']")
    private WebElement inputPhone;

    @FindBy(xpath = "//input[@name='userEmail']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@placeholder='Введите']")
    private WebElement inputAdres;

    @FindBy(xpath = "//div[@class='checkbox-body form__checkbox']")
    private WebElement checkBox;

    @FindBy(xpath = "//button[@class='form__button-submit btn--basic']")
    private WebElement clickSubmit;

    @FindBy(xpath = "//input[@name=\"userEmail\"]/../../span")
    private WebElement errMessage;


    public HealthInsurancePage fillField(String nameField, String value) {
        WebElement element = null;
        switch (nameField) {
            case "ФИО":
                fillInputField(inputName, value);
                element = inputName;
                break;
            case "Номер телефона":
                fillInputFieldPhone(inputPhone, value);
                element = inputPhone;
                break;
            case "Почта":
                fillInputField(inputEmail, value);
                element = inputEmail;
                break;
            case "Адрес":
                fillInputField(inputAdres, value);
                element = inputAdres;
                break;
            default:
                Assertions.fail("Поле с наименованием '" + nameField + "' отсутствует на странице");
        }
        if (element == inputPhone) {
            String valueExpected = String.format("+7 (%s) %s-%s", value.substring(0, 3), value.substring(3, 6), value.substring(6, 10));
            Assertions.assertEquals(element.getAttribute("value"), valueExpected, "Поле было заполненно не корректно");
        } else {
            Assertions.assertEquals(element.getAttribute("value"), value, "Поле было заполненно не корректно");
        }
        return this;
    }

    public HealthInsurancePage checkOpenPage() {
        String headTittle = driverManager.getWebDriver().getTitle();
        Assertions.assertTrue(headTittle.equals("Добровольное медицинское страхование для компаний и юридических лиц в Росгосстрахе"),
                "Проверка заголовка страницы");
        return pageManager.getHealthInsurancePage();
    }

    public HealthInsurancePage checkInputFieldPage() {
        String tittle = textFieldTitle.getText();
        Assertions.assertTrue(tittle.equals("Оперативно перезвоним\n" + "для оформления полиса"),
                "Проверка заголовка поля ввода");
        return pageManager.getHealthInsurancePage();
    }

    public HealthInsurancePage clickSendRequest() {
        waitUtilVisibilityOfElement(sendRequest).click();
        return pageManager.getHealthInsurancePage();
    }

    public HealthInsurancePage clickCheckBox() {
        waitUtilElementToBeClickable(checkBox).click();
        return pageManager.getHealthInsurancePage();
    }

    public HealthInsurancePage clickSubmitMe() {
        waitUtilVisibilityOfElement(clickSubmit).click();
        return pageManager.getHealthInsurancePage();
    }

    public HealthInsurancePage checkEmailError() {
        Assertions.assertEquals("Введите корректный адрес электронной почты", errMessage.getText(), "Проверка ошибки у почты");
        return pageManager.getHealthInsurancePage();
    }
}
