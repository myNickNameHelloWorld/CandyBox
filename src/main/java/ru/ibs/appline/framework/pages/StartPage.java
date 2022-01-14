package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends BasePage {


    @FindBy(xpath = "//button[@class='btn--text']")
    private WebElement cookiesClose;

    @FindBy(xpath = "//li[@class='item text--second']/a[contains(class, text--second)]")
    List<WebElement> baseMenu;


    public StartPage cookiesClose() {
        try {
            waitUtilVisibilityOfElement(cookiesClose).click();
        } catch (TimeoutException ignore) {

        }

        return pageManager.getStartPage();
    }

    public CompaniesPage selectBaseMenuText(String nameMenu) {
        for (WebElement itemMenu : baseMenu) {
            if (itemMenu.getText().contains(nameMenu)) {
                itemMenu.click();
                return pageManager.getCompaniesPage();
            }
        }
        Assertions.fail("Меню с текстом: " + nameMenu + "не найдено на стартовой странице");
        return pageManager.getCompaniesPage();
    }
}
