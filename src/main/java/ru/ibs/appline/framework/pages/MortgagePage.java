package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MortgagePage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Готовое')]/..")
    private WebElement clickReadyHousing;

    public MortgageCalculatorPage clickReadyHousing() {
        String title = driverManager.getWebDriver().getTitle();
        Assertions.assertEquals(title, "Ипотека — СберБанк", "Страница 'Ипотека' не открыта");
        waitUntilElementToBeClickable(clickReadyHousing);
        clickElementJs(clickReadyHousing);

        return pageManager.getMortgageCalculatorPage();
    }
}
