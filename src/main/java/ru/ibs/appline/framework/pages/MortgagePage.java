package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MortgagePage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'kitt-button') and contains(@data-product, 'Готовое жильё')]")
    private WebElement buttonReadyHousing;

    public MortgageCalculatorPage clickReadyHousing() {
        waitUntilElementToBeClickable(buttonReadyHousing);
//        String title = driverManager.getWebDriver().getTitle();
//        Assertions.assertEquals(title, "Ипотека — СберБанк", "Страница 'Ипотека' не открыта");
        buttonReadyHousing.click();
        return pageManager.getMortgageCalculatorPage();
    }
}
