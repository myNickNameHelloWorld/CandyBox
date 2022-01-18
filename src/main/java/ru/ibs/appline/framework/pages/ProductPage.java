package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.ibs.appline.framework.product.Product;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//h1")
    WebElement nameProduct;

    @FindBy(xpath = "//div[@class='product-card-top__buy']/div/div/div[contains(@class,'buy__price')]")
    private WebElement savePrice;

    @FindBy(xpath = "//div[@class='additional-sales-tabs__title']")
    private WebElement warrantyMenu;

    @FindBy(xpath = "//input[@type='radio' and @value='1']/..")
    private WebElement warrantyTwoYearsClick;

    @FindBy(xpath = "//div[contains(@class,'top__buy')]/div/div/div[contains(@class, 'price_active')]")
    private WebElement priceWithWarranty;

    @FindBy(xpath = "//div[@class='product-card-top__code']/../div[contains(@class, 'top__buy')]/div/button[contains(text(), 'Купить')]")
    private WebElement clickBuy;

    @FindBy(xpath = "//nav[@id='header-search']/div/div/form/div/input")
    private WebElement search;
    @FindBy(xpath = "//div[@class='header__login']/../div[@class='buttons']/a[@href='/order/begin/']/span[@class='cart-link__lbl']/span[@class='cart-link__price']")
    private WebElement forWaitXpath;
    @FindBy(xpath = "//div[@class = 'buttons']//span[@class = 'cart-link__price']")
    private WebElement priceCart;




    public ProductPage savePrice() {
        waitUntilElementToBeClickable(clickBuy);
        String price1 = savePrice.getText();
        int priceInt = strToInt(price1);
        String name = nameProduct.getText();
        Product.list.add(new Product(name, priceInt));
        return pageManager.getProductPage();
    }

    public ProductPage clickWarranty() {
        waitUntilElementToBeClickable(warrantyMenu);
        warrantyMenu.click();
        waitUntilElementToBeClickable(warrantyTwoYearsClick);
        warrantyTwoYearsClick.click();
        return pageManager.getProductPage();
    }

    public ProductPage savePriceWithWarranty() {
        waitUntilVisibilityOf(priceWithWarranty);
        savePrice();
        return pageManager.getProductPage();
    }

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
        int sumOfProducts = Product.list.get(0).getPrice();
        Assertions.assertEquals(sumCartInt, sumOfProducts, "Цена не совпадает");
        return pageManager.getProductPage();
    }

    public BucketPage goToTheCart() {
        priceCart.click();
        return pageManager.getBucketPage();
    }

}
