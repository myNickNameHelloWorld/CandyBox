package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MortgageCalculatorPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Стоимость')]/../input")
    private WebElement propertyValues;

    @FindBy(xpath = "//div[contains(text(), 'Первоначальный')]/../input")
    private WebElement initialPayment;

    @FindBy(xpath = "//div[contains(text(), 'Срок')]/../input")
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
        Assertions.assertEquals(element.getAttribute("value"), value, "Поле было заполненно не корректно");
        return this;
    }

    public MortgageCalculatorPage clickCheckboxInsurance() {
        scrollToElementJs(creditPeriod);
        sleep(1000);
        insuranceCheckBox.click();
        return pageManager.getMortgageCalculatorPage();
    }

    public MortgageCalculatorPage checkPropertyValues() {
        scrollToElementJs(forScroll);
        sleep(1000);
        WebElement checkProperty = containerResults.findElement(By.xpath("./li[contains(@data-e2e-id, 'credit-sum')]/div/span[2]"));
        String checkPropertyStr = checkProperty.getText();
        Assertions.assertEquals(checkPropertyStr, "2 122 000 ₽", "Сумма отличается");
        return pageManager.getMortgageCalculatorPage();
    }

    public MortgageCalculatorPage checkInitialPayment() {
        WebElement checkInitialPaymentEl = containerResults.findElement(By.xpath("./li[contains(@data-e2e-id, 'monthly-payment')]/div/span[2]"));
        String checkInitialPaymentStr = checkInitialPaymentEl.getText();
        Assertions.assertEquals(checkInitialPaymentStr, "19 094 ₽", "Сумма ежемесечного платежа отличается");
        return pageManager.getMortgageCalculatorPage();
    }

    public MortgageCalculatorPage checkRequiredIncome() {
        WebElement checkRequiredIncomeEl = containerResults.findElement(By.xpath("./../../../div[contains(@data-e2e-id, 'bottom')]/div/div/span[2]"));
        String checkRequiredIncomeElStr = checkRequiredIncomeEl.getText();
        Assertions.assertEquals(checkRequiredIncomeElStr, "24 580 ₽", "Сумма необходимого дохода неверена");
        return pageManager.getMortgageCalculatorPage();
    }

    public MortgageCalculatorPage checkCreditPercent() {
        WebElement checkCreditPercentEl = containerResults.findElement(By.xpath("./li[contains(@data-e2e-id, 'credit-rate')]/div/div/div/div/div/div/span[2]/span"));
        String checkCreditPercentElStr = checkCreditPercentEl.getText();
        Assertions.assertEquals(checkCreditPercentElStr, "11%", "Процент по кредиту неверен");
        return pageManager.getMortgageCalculatorPage();
    }
}
