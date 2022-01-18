package ru.ibs.appline.tests;

import org.junit.jupiter.api.Test;
import ru.ibs.appline.tests.base.BaseDnsTests;

public class DnsTest extends BaseDnsTests {


    @Test
    public void test() {
        pageManager.getStartPage()
                .searchProduct("nintendo switch")
                .clickProductInSearch("консоль")
                .savePrice()
                .clickWarranty()
                .savePriceWithWarranty()
                .clickBuy()
                .searchFromProductPage("Detroit")
                .clickProductInSearch("Detroit")
                .savePrice()
                .clickBuy()
                .checkPriceInCart()
                .goToTheCart()
                .checkWarrantyPeriod()
                .checkSumPrice()
                .deleteDetroit()
                .checkPriceAfterDelete()
                .addProduct(2)
                .checkPriceAfterAddTwo(2)
                .returnDetroit()
                .checkSumPrice();
////        WebElement searchProduct = webDriver.findElement(By.xpath("//form[@class='presearch']/div/input"));
////        searchProduct.sendKeys("nintendo switch", Keys.ENTER);
//
//        //Vibor PS
//        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-code='1391816']/a")));
//        searchPage.clickProductInSearch("Игровая консоль Nintendo Switch 32 GB Neon Red/Blue [32 ГБ, геймпад - 2 шт, Bluetooth, Wi-Fi, красный-синий]");
////        WebElement clickXbox = webDriver.findElement(By.xpath("//div[@data-code='1391816']/a"));
////        clickXbox.click();
//
//        //Zapomnit' ceny
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-card-top__buy']/div/div/div[@class='product-buy__price']")));
//        productPage.savePrice();
////        WebElement savePrice = webDriver.findElement(By.xpath("//div[@class='product-card-top__buy']/div/div/div[@class='product-buy__price']"));
////        String p1 = savePrice.getText();
////        String p2 = p1.replaceAll("[^0-9]","");
////        int p1int = Integer.parseInt(p2);
//
//        //click garanriya
////        WebElement clickWarranty = webDriver.findElement(By.xpath("//div[@class='additional-sales-tabs__title']"));
////        clickWarranty.click();
////        WebElement twoYears = webDriver.findElement(By.xpath("//input[@type='radio' and @value='1']/.."));
////        twoYears.click();
//        productPage.clickWarranty();
//
//        //zapomni ceny
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-card-top__buy']/div/div/div[@class='product-buy__price product-buy__price_active']")));
//        productPage.savePriceWithWarranty();
////        WebElement priceNew = webDriver.findElement(By.xpath("//div[@class='product-card-top__buy']/div/div/div[@class='product-buy__price product-buy__price_active']"));
////        String p11 = priceNew.getText();
////        p11 = p11.replaceAll("[^0-9]","");
////        int p2int = Integer.parseInt(p11);
//
//        //click kupit'
////        WebElement buy = webDriver.findElement(By.xpath("//div[@class='product-card-top__buy']/div/div/div[contains(class, product)]/../../button[contains(class, ui)][2]"));
////        buy.click();
//        productPage.clickBuy();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='header__login']/../div[@class='buttons']/a[@href='/order/begin/']/span[@class='cart-link__lbl']/span[@class='cart-link__price']")));
//
//        //Detroit
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button-ui buy-btn button-ui_brand button-ui_passive-done']")));
////        WebElement searchProductDetroit = webDriver.findElement(By.xpath("//nav[@id=\"header-search\"]/div/div/form/div/input"));
////        searchProductDetroit.sendKeys("Detroit", Keys.ENTER);
//        productPage.searchProduct("Detroit");
//
//        //clickDetroit
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-code='1225442']/a")));
////        WebElement clickDetroit = webDriver.findElement(By.xpath("//div[@data-code='1225442']/a"));
////        clickDetroit.click();
//        searchPage.clickProductInSearch("Игра Detroit");
//
//        //save price
////        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-card-top__buy']/div/div/div[contains(class, product)]/../../button[contains(class, ui)][2]")));
////        WebElement priceDetroit = webDriver.findElement(By.xpath("//div[@class='product-card-top__buy']/div/div/div[@class='product-buy__price']"));
////        String priceDetroitSum =  priceDetroit.getText();
////        String priceDetroitSum1 = priceDetroitSum.replaceAll("[^0-9]","");
////        int priceInt = Integer.parseInt(priceDetroitSum1);
//        productPage.savePrice();
//
//        //click kupit'
////        WebElement clickSubmitDetroit = webDriver.findElement(By.xpath("//div[@class='product-card-top__buy']/div/div/div[contains(class, product)]/../../button[contains(class, ui)][2]"));
////        String err = clickSubmitDetroit.getText();
////        clickSubmitDetroit.click();
////        WebElement cenaIzKorzini = webDriver.findElement(By.xpath("//div[@class='header__login']/../div[@class='buttons']/a[@href='/order/begin/']/span[@class='cart-link__lbl']/span[@class='cart-link__price']"));
////        String cenaKorzini = cenaIzKorzini.getText();
//        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='header__login']/../div[@class='buttons']/a[@href='/order/begin/']/span[@class='cart-link__lbl']/span[@class='cart-link__price']"), cenaKorzini)));
//
//
//        // проверка корзины;
////        WebElement cena = webDriver.findElement(By.xpath("//div[@class='header__login']/../div[@class='buttons']/a[@href='/order/begin/']/span[@class='cart-link__lbl']/span[@class='cart-link__price']"));
////        String asf = cena.getText();
////        asf = asf.replaceAll("[^0-9]","");
////        int auf = Integer.parseInt(asf);
////        int summ = p2int + priceInt;
////        Assertions.assertTrue((summ == auf), "Цена корзины не соответствует выбранным товарам");
//        productPage.checkPriceInCart();
//
//        //pereiti v korzinu
////        cena.click();
//        productPage.goToTheCart();
//
//        //proverka garantii
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='buy-button']")));
//        bucketPage.checkWarrantyPeriod();
////        WebElement garantia = webDriver.findElement(By.xpath("//span[@class='base-ui-radio-button__icon base-ui-radio-button__icon_checked']"));
////        Assertions.assertTrue((garantia.getAttribute("class")).contains("icon_checked"), "Гарантия не выбрана");
//
////        //proverka ceni nintendo
////        WebElement cenaPs = webDriver.findElement(By.xpath("//div[@class='additional-warranties-row cart-items__additionals-item']/../div/div[@class='cart-items__product-block-amount']/div[2]/div[@class='price']/div/span"));
////        Assertions.assertEquals((cenaPs.getText()), p1, "цена консоли не соответствует");
////
////        //proverka ditroit ceni
////        WebElement cenaDetroit = webDriver.findElement(By.xpath("//div[@class='cart-items__product'][2]/div/div/div/div/div[@class='cart-items__product-price']/div[1]/div/span"));
////        Assertions.assertEquals((cenaDetroit.getText()), priceDetroitSum, "цена игры не соответствует");
////
////        //proverka summi
////        WebElement summaPokupok = webDriver.findElement(By.xpath("//div[@id='total-amount']/div/div/div[contains(@class, info)][2]/div/div[contains(@class, price)][2]/div/span[2]"));
////        String summaPok = summaPokupok.getText().replaceAll("[^0-9]","");
////        int intSummaPok = Integer.parseInt(summaPok);
////        Assertions.assertTrue(summ == intSummaPok, "Сумма покупок отличается");
//        bucketPage.checkSumPrice();
//
//        //delite Detroit
////        WebElement deleteDetroit = webDriver.findElement(By.xpath("//a[contains(text(), 'Detroit')]/../../div[contains(@class, 'menu-product')]/div[contains(@class, 'wrapper')]/button[contains(text(), 'Удалить')]"));
////        deleteDetroit.click();
//        bucketPage.deleteDetroit();
//        //wait.until(ExpectedConditions.invisibilityOf(deleteDetroit));
//
////        WebElement summaPokupok2 = webDriver.findElement(By.xpath("//div[@id='total-amount']/div/div/div[contains(@class, info)][2]/div/div[contains(@class, price)][2]/div/span[2]"));
////        String summaPok2 = summaPokupok2.getText();
////        String summaPok3 = summaPok2.replaceAll("[^0-9]","");
////        int intSummaPok4 = Integer.parseInt(summaPok3);
////        Assertions.assertTrue(((summ - priceInt) == intSummaPok4), "Сумма покупок отличается");
//        bucketPage.checkPriceAfterDelete();
//
//        //+2 klika na pristavku
////
////        WebElement scrollTo = webDriver.findElement(By.xpath("//h1[contains(text(), 'Корзина')]"));
////        JavascriptExecutor js = (JavascriptExecutor) webDriver;
////        js.executeScript("arguments[0].scrollIntoView();", scrollTo);
////        WebElement nintendoPlus2 = webDriver.findElement(By.xpath("//div[@class='count-buttons']/button[contains(@class, 'plus')]/i"));
////        nintendoPlus2.click();
//        bucketPage.addProduct(2);
////        WebElement zzzz = webDriver.findElement(By.xpath("//div[@id='total-amount']/div/div/div[contains(@class, 'info')]/div/div[contains(@class, 'price')]/div/span[contains(text(), '₽')]"));
////        String zzuuu = zzzz.getText();
////        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(summaPokupok2, summaPok2)));
////        nintendoPlus2.click();
////        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(zzzz, zzuuu)));
////        try {
////            Thread.sleep(2000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//
//        //proverka summi
////        WebElement plus2pristavki = webDriver.findElement(By.xpath("//div[@id='total-amount']/div/div/div[contains(@class, 'info')]/div/div[contains(@class, 'price')]/div/span[contains(text(), '₽')]"));
////        String plus2pristavkiSum = summaPokupok.getText().replaceAll("[^0-9]","");
////        int plus2pristavkiSumInt = Integer.parseInt(plus2pristavkiSum);
////        System.out.println((p2int * 3));
////        Assertions.assertTrue((p2int * 3) == plus2pristavkiSumInt, "Сумма отличается");
//        bucketPage.checkPriceAfterAddTwo(2);
//
//        //vernut' detroit
////        WebElement backDetroit = webDriver.findElement(By.xpath("//span[contains(@class, 'print')]/span"));
////        JavascriptExecutor jsrt = (JavascriptExecutor) webDriver;
////        jsrt.executeScript("arguments[0].click();", backDetroit);
//        //backDetroit.click();
//        bucketPage.returnDetroit();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        //proverka vozvrata
////        WebElement back = webDriver.findElement(By.xpath("//a[contains(text(), 'Detroit')]"));
////        Assertions.assertTrue(back.getText().contains("Detroit"), "Игра не появилась");
////        WebElement aaaa = webDriver.findElement(By.xpath("//a[@data-role='cart-modal-position']/span[contains(@class, 'lbl')]/span[contains(@class, 'price')]"));
////        String bbbb = aaaa.getText().replaceAll("[^0-9]","");
////        int ssss = Integer.parseInt(bbbb);
////
////        Assertions.assertTrue((plus2pristavkiSumInt + priceInt) == ssss, "Detroit не добавлена");
//        bucketPage.checkSumPrice();
//
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
