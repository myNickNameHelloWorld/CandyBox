package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.ibs.appline.framework.product.Product;

import java.util.List;

public class BucketPage extends BasePage {

    @FindBy(xpath = "//span[@class='base-ui-radio-button__icon base-ui-radio-button__icon_checked']")
    private WebElement warrantyPeriod;

    @FindBy(xpath = "//div[@class='count-buttons']/button[contains(@class, 'plus')]/i")
    private WebElement addTwoProduct;

    @FindBy(xpath = "//div[@class = 'buttons']//span[@class = 'cart-link__price']")
    private WebElement priceAfterAddTwo;

    @FindBy(xpath = "//span[contains(@class, 'print')]/span")
    private WebElement clickReturnJs;

    @FindBy(xpath = "//a[@class='cart-items__product-name-link']")
    private List<WebElement> products;



    public BucketPage checkWarrantyPeriod(String month) {
        Assertions.assertTrue(warrantyPeriod.getText().contains(month), "Гарантия не выбрана");
        return pageManager.getBucketPage();
    }

    public BucketPage checkSumPrice() {
        String s = priceAfterAddTwo.getText();
        int priceSumInt = strToInt(s);
        int sumOfProductsInCart = Product.list.get(1).getPrice() + Product.list.get(2).getPrice();
        Assertions.assertEquals(priceSumInt, sumOfProductsInCart, "Сумма не совпадает");
        return pageManager.getBucketPage();
    }

    public BucketPage deleteDetroit(String name) {
        for (WebElement element : products) {
            if (element.getText().toLowerCase().contains(name.toLowerCase())) {
                WebElement element1 = element.findElement(By.xpath("./../../div/div[contains(@class, 'product-wrapper')]/button[contains(text(), 'Удалить')]"));
                Product.list.remove(Product.list.size() - 1);
                waitUntilElementToBeClickable(element1);
                element1.click();
                waitUntilInvisibilityOf(element1);
                return pageManager.getBucketPage();
            }
        }
        Assertions.fail("Ввели некорректное имя продукта");
        return pageManager.getBucketPage();
    }

    public BucketPage checkPriceAfterDelete() {
        String s = priceAfterAddTwo.getText();
        int priceSumInt = strToInt(s);
        Assertions.assertEquals(priceSumInt, Product.list.get(1).getPrice(), "Сумма не совпадает");
        return pageManager.getBucketPage();
    }

    public BucketPage addProduct(int value) {
        for (int i = 0; i < value; i++) {
            addTwoProduct.click();
            Product.list.add(Product.list.get(1));
            sleep(2000);
        }
        return pageManager.getBucketPage();
    }

    public BucketPage checkPriceAfterAdd(int value) {
        waitUntilVisibilityOf(priceAfterAddTwo);
        String s = priceAfterAddTwo.getText();
        int priceAfterAddTwoInt = strToInt(s);
        Assertions.assertEquals(priceAfterAddTwoInt, (Product.list.get(2).getPrice() * (value + 1)), "Сумма после добавления " + value + " элементов неккоректна");
        return pageManager.getBucketPage();
    }

    public BucketPage returnProduct(String name) {
        scrollToElementJs(clickReturnJs);
        waitUntilElementToBeClickable(clickReturnJs);
        clickElementJs(clickReturnJs);
        sleep(1000);
        for (WebElement element : products) {
            if (element.getText().toLowerCase().contains(name.toLowerCase())) {
                waitUntilElementToBeClickable(element);
                WebElement elemnt1 = element.findElement(By.xpath("./../../../../../div[contains(@class, 'block-amount')]/div[contains(@class, 'product-price')]/div"));
                String str1 = elemnt1.getText();
                int str1Int = strToInt(str1);
                Product.list.add(new Product(element.getText(), str1Int));
                return pageManager.getBucketPage();
            }
        }
        Assertions.fail("Ввели некорректное имя продукта");
        return pageManager.getBucketPage();
    }

    public BucketPage checkSumPriceAfterReturn() {
        waitUntilElementToBeClickable(priceAfterAddTwo);
        String s = priceAfterAddTwo.getText();
        int priceSumInt = strToInt(s);
        int sumOfProductsInCart = (Product.list.get(1).getPrice() * (Product.list.size() - 2)) + Product.list.get(Product.list.size() - 1).getPrice();
        Assertions.assertEquals(priceSumInt, sumOfProductsInCart, "Сумма не совпадает");
        return pageManager.getBucketPage();
    }
}
