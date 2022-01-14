package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompaniesPage extends BasePage {

    @FindBy(xpath = "//li[@class='item text--second' and span[@class='padding']]")
    List<WebElement> subMenu;

    @FindBy(xpath = "//a[contains(@href, 'for-companies')]")
    List<WebElement> subHealthMenu;


    public CompaniesPage selectSubMenuText(String nameSubMenu) {
        for (WebElement itemMenu : subMenu) {
            if (itemMenu.getText().contains(nameSubMenu)) {
                itemMenu.click();
                return pageManager.getCompaniesPage();
            }
        }
        Assertions.fail("Меню с текстом: " + nameSubMenu + "не найдено на странице");
        return pageManager.getCompaniesPage();
    }

    public HealthInsurancePage selectSubHealthMenuText(String nameSubHealthMenu) {
        for (WebElement itemMenu : subHealthMenu) {
            if (itemMenu.getText().contains(nameSubHealthMenu)) {
                itemMenu.click();
                waitUtilInvisibilityOfElement(itemMenu);
                return pageManager.getHealthInsurancePage();
            }
        }
        Assertions.fail("Подменю с текстом: " + nameSubHealthMenu + "не найдено на странице");
        return pageManager.getHealthInsurancePage();
    }


}
