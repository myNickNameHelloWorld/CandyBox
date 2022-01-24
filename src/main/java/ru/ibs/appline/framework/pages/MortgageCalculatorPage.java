package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MortgageCalculatorPage extends BasePage {

//    @FindBy(xpath = "//div[contains(text(), 'Стоимость')]/../input")
    @FindBy(xpath = "//label[contains(text(), 'Стоимость')]/../input")
    private WebElement propertyValues;

    @FindBy(xpath = "//label[contains(text(), 'Первоначальный')]/../input")
    private WebElement initialPayment;

    @FindBy(xpath = "//label[contains(text(), 'Срок')]/../input")
    private WebElement creditPeriod;

    @FindBy(xpath = "//span[contains(text(), 'Страхование')]/../../span/label/div/input")
    private WebElement insuranceCheckBox;

    @FindBy(xpath = "//div[contains(@data-test-id, 'main-results')]/div/div/ul")
    private WebElement containerResults;

    @FindBy(xpath = "//iframe[@id='iFrameResizer0']")
    private WebElement switchIframe;

    @FindBy(xpath = "//input[contains(@value, 'Готовое')]")
    private WebElement forScroll;


    public MortgageCalculatorPage checkTitle() {
        driverManager.getWebDriver().switchTo().frame(switchIframe);
        waitUntilElementToBeClickable(propertyValues);
        String title = driverManager.getWebDriver().getTitle();
        Assertions.assertEquals(title, "Ипотека на вторичное жилье — СберБанк", "Страница 'Ипотека' не открыта");
        return pageManager.getMortgageCalculatorPage();
    }

    public MortgageCalculatorPage fillFieldPropertyValues(String nameField, String value) {
        WebElement element = null;
        switch (nameField) {
            case "Стоимость недвижимости":
                scrollToElementJs(forScroll);
                fillInputField(propertyValues, value);
                element = propertyValues;
                break;
            case "Первоначальный взнос":
                fillInputField(initialPayment, value);
                element = initialPayment;
                break;
            case "Срок кредита":
                fillInputField(creditPeriod, value);
                element = creditPeriod;
                break;
            default:
                Assertions.fail("Поле с наименованием '" + nameField + "' отсутствует на странице");
        }
        Assertions.assertEquals(element.getAttribute("value").replaceAll("\\D", ""), value, "Поле было заполненно не корректно");
        return this;
    }

    public MortgageCalculatorPage clickCheckboxInsurance() {
        scrollToElementJs(creditPeriod);
        sleep(1000);
        insuranceCheckBox.click();
        return pageManager.getMortgageCalculatorPage();
    }

    public MortgageCalculatorPage checkFieldOnPage(String nameField) {
        WebElement element = containerResults;
        switch (nameField) {
            case "Сумма кредита":
                checkField(element, "./li[contains(@data-e2e-id, 'credit-sum')]/div/span[2]", "2122000");
                break;
            case "Ежемесячный платеж":
                checkField(element, "./li[contains(@data-e2e-id, 'monthly-payment')]/div/span[2]", "19094");
                break;
            case "Необходимый доход":
                checkField(element, "./../../../div[contains(@data-e2e-id, 'bottom')]/div/div/span[2]", "24580");
                break;
            case "Процентная ставка":
                checkField(element, "./li[contains(@data-e2e-id, 'credit-rate')]/div/div/div/div/div/div/span[2]/span", "11%");
                break;
            default:
                Assertions.fail("Не найдено " + nameField);
        }
        return this;
    }
}
