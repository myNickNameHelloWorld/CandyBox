package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {


    @FindBy(xpath = "//a[@class='catalog-product__name ui-link ui-link_black']")
    private List<WebElement> searchProductsList;

    public ProductPage clickProductInSearch(String nameProductForSearch) {
        for (WebElement element : searchProductsList) {
            if (element.getText().toLowerCase().contains(nameProductForSearch.toLowerCase())) {
                waitUntilElementToBeClickable(element);
                actionsActions(element);
                //element.click();
                return pageManager.getProductPage();
            }
        }
        Assertions.fail("Товар с названием \"" + nameProductForSearch + "\" не найден.");
        return pageManager.getProductPage();
    }
}
