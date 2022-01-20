package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.appline.framework.product.Product;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//h1")
    WebElement nameProduct;

    @FindBy(xpath = "//div[@class='product-card-top__buy']/div/div/div[contains(@class,'buy__price')]")
    private WebElement savePrice;

    @FindBy(xpath = "//label[contains(@class, 'ui-radio__item')]")
    private List<WebElement> selectWarranty;

    @FindBy(xpath = "//div[contains(@class,'top__buy')]/div/div/div[contains(@class, 'price_active')]")
    private WebElement priceWithWarranty;

    @FindBy(xpath = "//div[@class='product-card-top__code']/../div[contains(@class, 'top__buy')]/div/button[contains(text(), 'Купить')]")
    private WebElement clickBuy;

    @FindBy(xpath = "//nav[@id='header-search']/div/div/form/div/input")
    private WebElement search;

    @FindBy(xpath = "//div[@class = 'buttons']//span[@class = 'cart-link__price']")
    private WebElement priceCart;

    @FindBy(xpath = "//a[contains(@class, 'button-ui button-ui_white')]")
    private WebElement checkOnWarranty;

    @FindBy(xpath = "//div[@class='additional-sales-tabs__titles-wrap']")
    private WebElement warrantyAndOtherMenu;


    public ProductPage savePrice() {
        waitUntilElementToBeClickable(clickBuy);
        String price1 = savePrice.getText();
        int priceInt = strToInt(price1);
        String name = nameProduct.getText();
        Product.list.add(new Product(name, priceInt));
        return pageManager.getProductPage();
    }


    public ProductPage clickWarranty(String month) {
        waitUntilElementToBeClickable(checkOnWarranty);
        Assertions.assertTrue(warrantyAndOtherMenu.getText().contains("Гарантия"), "Гарантия на товар не предусмотрена");
        WebElement warrantyMenuClick = checkOnWarranty.findElement(By.xpath("./../../../../div/div[contains(text(), 'Гарантия')]"));
        warrantyMenuClick.click();
        for (WebElement warranty : selectWarranty) {
            if (warranty.getText().toLowerCase().contains(month)) {
                waitUntilElementToBeClickable(warranty);
                warranty.click();
                waitUntilVisibilityOf(priceWithWarranty);
                String price1 = savePrice.getText();
                int priceInt = strToInt(price1);
                String name = nameProduct.getText();
                Product.list.add(new Product(name, priceInt, warranty.getText()));
                return pageManager.getProductPage();
            }
        }
        Assertions.fail("Гарантия в " + month + "мес. отсутствует");
        return pageManager.getProductPage();
    }

//    public ProductPage savePriceWithWarranty() {
//        waitUntilVisibilityOf(priceWithWarranty);
//        savePrice();
//        return pageManager.getProductPage();
//    }

    public ProductPage clickBuy() {

        waitUntilElementToBeClickable(clickBuy);
        clickBuy.click();
        return pageManager.getProductPage();
    }

    public SearchPage searchFromProductPage(String nameProduct) {
        waitUntilElementToBeClickable(search);
        search.sendKeys(nameProduct, Keys.ENTER);
        Assertions.assertEquals(nameProduct, search.getAttribute("value"), "Наименование продукта " + nameProduct + " в графе поиск заполнено некорректно");
        return pageManager.getSearchPage();
    }

    public ProductPage checkPriceInCart() {
        waitUntilSwitchText(priceCart);
        String sumCart = priceCart.getText();
        int sumCartInt = strToInt(sumCart);
        int sumOfProducts = Product.list.get(1).getPrice() + Product.list.get(2).getPrice();
        Assertions.assertEquals(sumCartInt, sumOfProducts, "Цена не совпадает");
        return pageManager.getProductPage();
    }

    public BucketPage goToTheCart() {
        waitUntilElementToBeClickable(priceCart);
        priceCart.click();
        return pageManager.getBucketPage();
    }

}
