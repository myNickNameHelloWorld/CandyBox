package ru.ibs.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.appline.framework.product.Product;

import java.util.List;

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

    @FindBy(xpath = "//button[@class='buy-button']/../../div/div[contains(@class, 'info-block')]/div/div[@class='price']/div/span[@class='price__current']")
    private WebElement forSearch;

    @FindBy(xpath = "//a[@class='cart-items__product-name-link']")
    private List<WebElement> products;

    public BucketPage checkWarrantyPeriod(String month) {
        Assertions.assertTrue(warrantyPeriod.getText().contains(month), "Гарантия не выбрана");
        return pageManager.getBucketPage();
    }

    public BucketPage checkSumPrice() {
        String s = priceAfterAddTwo.getText();
        int priceSumInt = strToInt(s);
        int sumOfProductsInCart = Product.list.get(2).getPrice() + Product.list.get(4).getPrice();
        Assertions.assertEquals(priceSumInt, sumOfProductsInCart, "Сумма не совпадает");
        return pageManager.getBucketPage();
    }

    public BucketPage deleteDetroit(String name) {
        for (WebElement element : products) {
            if (element.getText().toLowerCase().contains(name.toLowerCase())) {
                WebElement element1 = element.findElement(By.xpath("./../../div/div[contains(@class, 'product-wrapper')]/button[contains(text(), 'Удалить')]"));
                Product.list.remove(Product.list.size() - 1);
                element1.click();
                return pageManager.getBucketPage().checkPriceAfterDelete();
            }
        }
        Assertions.fail("Ввели некорректное имя продукта");
        return pageManager.getBucketPage();
    }

    public BucketPage checkPriceAfterDelete() {
        sleep(1000);
        String s = priceAfterAddTwo.getText();
        int priceSumInt = strToInt(s);
        Assertions.assertEquals(priceSumInt, Product.list.get(2).getPrice(), "Сумма не совпадает");
        return pageManager.getBucketPage();
    }

    public BucketPage addProduct(int value) {
        for (int i = 0; i < value; i++) {
            addTwoProduct.click();
            Product.list.add(Product.list.get(2));
            sleep(2000);
        }
        return pageManager.getBucketPage();
    }

    public BucketPage checkPriceAfterAddTwo(int value) {
        waitUntilVisibilityOf(priceAfterAddTwo);
        String s = priceAfterAddTwo.getText();
        int priceAfterAddTwoInt = strToInt(s);
        Assertions.assertEquals(priceAfterAddTwoInt, (Product.list.get(2).getPrice() * (value + 1)), "Сумма после добавления " + value + " элементов неккоректна");
        return pageManager.getBucketPage();
    }

    public BucketPage returnDetroit(String name) {
        scrollToElementJs(clickReturnJs);
        waitUntilElementToBeClickable(clickReturnJs);
        clickElementJs(clickReturnJs);
        sleep(1000);

        for (WebElement element : products) {
            if (element.getText().toLowerCase().contains(name.toLowerCase())) {
                WebElement elemnt1 = element.findElement(By.xpath("./../../../../../div[contains(@class, 'block-amount')]/div[contains(@class, 'product-price')]/div"));
                String str1 = elemnt1.getText();
                int str1Int = strToInt(str1);
                Product.list.add(new Product(name, str1Int));
                return pageManager.getBucketPage().checkSumPriceAfterReturn();
            }
        }
        Assertions.fail("Ввели некорректное имя продукта");
        return pageManager.getBucketPage();
    }

    public BucketPage checkSumPriceAfterReturn() {
        waitUntilElementToBeClickable(priceAfterAddTwo);
        String s = priceAfterAddTwo.getText();
        int priceSumInt = strToInt(s);
        int sumOfProductsInCart = (Product.list.get(2).getPrice() * (Product.list.size() - 5)) + Product.list.get(Product.list.size() - 1).getPrice();
        Assertions.assertEquals(priceSumInt, sumOfProductsInCart, "Сумма не совпадает");
        return pageManager.getBucketPage();
    }
}
