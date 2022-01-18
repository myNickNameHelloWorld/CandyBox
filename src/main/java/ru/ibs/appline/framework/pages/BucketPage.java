package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.appline.framework.product.Product;

public class BucketPage extends BasePage {
    @FindBy(xpath = "//span[@class='base-ui-radio-button__icon base-ui-radio-button__icon_checked']")
    private WebElement warrantyPeriod;

    @FindBy(xpath = "//div[contains(@class, 'additionals-item')]/../div/div[contains(@class,'block-amount')]/div/div[@class='price']/div/span")
    private WebElement priceSum;

    @FindBy(xpath = "//a[contains(text(), 'Detroit')]/../../div[contains(@class, 'menu-product')]/div[contains(@class, 'wrapper')]/button[contains(text(), 'Удалить')]")
    private WebElement detroitDelete;

    @FindBy(xpath = "//div[@class='count-buttons']/button[contains(@class, 'plus')]/i")
    WebElement addTwoProduct;

    @FindBy(xpath = "//div[@class = 'buttons']//span[@class = 'cart-link__price']")
    private WebElement priceAfterAddTwo;

    @FindBy(xpath = "//h1[contains(text(), 'Корзина')]")
    private WebElement scrollToElementJs;

    @FindBy(xpath = "//span[contains(@class, 'print')]/span")
    private WebElement clickReturnJs;

    @FindBy(xpath = "//a[contains(text(), 'Detroit')]/../../div[contains(@class, 'product-name')]/a")
    private WebElement nameOfProduct;

    @FindBy(xpath = "//a[contains(text(), 'Detroit')]/../../div[contains(@class, 'product-name')]/a")
    private WebElement priceOfProduct;

    public BucketPage checkWarrantyPeriod() {
        Assertions.assertTrue(warrantyPeriod.getText().contains("24"), "Гарантия не выбрана");
        return pageManager.getBucketPage();
    }

    public BucketPage checkSumPrice() {
        String s = priceSum.getText().replaceAll("[^0-9]","");
        int priceSumInt = Integer.parseInt(s);
        int sumOfProductsInCart = Product.list.get(1).getPrice() + Product.list.get(2).getPrice();
        Assertions.assertEquals(priceSumInt, sumOfProductsInCart, "Сумма не совпадает");
        return pageManager.getBucketPage();
    }
    public BucketPage deleteDetroit() {
        detroitDelete.click();
        return pageManager.getBucketPage();
//        Product.list.remove(Product.list.size() - 1);
    }

    public BucketPage checkPriceAfterDelete() {
        String s = priceSum.getText().replaceAll("[^0-9]","");
        int priceSumInt = Integer.parseInt(s);
        Assertions.assertEquals(priceSumInt, Product.list.get(1).getPrice(), "Сумма не совпадает");
        return pageManager.getBucketPage();
    }

    public BucketPage addProduct(int value) {
        scrollToElementJs(scrollToElementJs);
        for (int i = 0; i > value; i++) {
            addTwoProduct.click();
            //WAIIT
        }
        return pageManager.getBucketPage();
    }

    public BucketPage checkPriceAfterAddTwo(int value) {
        String s = priceAfterAddTwo.getText().replaceAll("[^0-9]","");
        int priceAfterAddTwoInt = Integer.parseInt(s);
        Assertions.assertEquals(priceAfterAddTwoInt, (Product.list.get(1).getPrice() * value), "Сумма не совпадает");
        return pageManager.getBucketPage();
    }

    public BucketPage returnDetroit() {
        clickElementJs(clickReturnJs);
        return pageManager.getBucketPage();
    }
}
