package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(xpath = "//form[@class='presearch']/div/input[contains(@placeholder, 'Поиск')]")
    private WebElement searchInput;


    public SearchPage searchProduct(String nameProduct) {
        searchInput.sendKeys(nameProduct, Keys.ENTER);
        Assertions.assertEquals(nameProduct, searchInput.getAttribute("value"), "Наименование продукта " + nameProduct + " в графе поиск заполнено некорректно");
        return pageManager.getSearchPage();
    }

}
