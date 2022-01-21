package ru.ibs.appline.tests;

import org.junit.jupiter.api.Test;
import ru.ibs.appline.tests.base.BaseDnsTests;

public class DnsTest extends BaseDnsTests {

    @Test
    public void test() {
        pageManager.getStartPage()
                .clickCloseCookies()
                .clickMortgageMenu()
                .clickAllMortgageProducts()
                .clickReadyHousing()
                //.checkTitle()
                .fillFieldPropertyValues("Стоимость недвижимости", "5180000")
                .fillFieldPropertyValues("Первоначальный взнос", "3058000")
                .fillFieldPropertyValues("Срок кредита", "30")
                .clickCheckboxInsurance()
                .checkPropertyValues()
                .checkInitialPayment()
                .checkRequiredIncome()
                .checkCreditPercent();


//        pageManager.getStartPage()
//                .searchProduct("nintendo switch")
//                .clickProductInSearch("консоль")
//                .savePrice()
//                .clickWarranty("24")
//                //.savePriceWithWarranty()
//                .clickBuy()
//                .searchFromProductPage("Detroit")
//                .clickProductInSearch("Detroit")
//                .savePrice()
//                .clickBuy()
//                .checkPriceInCart()
//                .goToTheCart()
//                .checkWarrantyPeriod("24")
//                .checkSumPrice()
//                .deleteDetroit("Detroit")
//                .checkPriceAfterDelete()
//                .addProduct(2)
//                .checkPriceAfterAdd(2)
//                .returnProduct("Detroit")
//                .checkSumPriceAfterReturn();
//        for (Product product : Product.list) {
//            System.out.println(product.getName() + " / " + product.getPrice() + " ₽" + " / " + product.getWarranty());
//        }


//        WebElement clickIpoteka = webDriver.findElement(By.xpath("//a[contains(@aria-label, 'Ипотека')]"));
//        wait.until(ExpectedConditions.elementToBeClickable(clickIpoteka));
//        clickIpoteka.click();

//        WebElement clickAllIpoteka = webDriver.findElement(By.xpath("//li[@class='kitt-top-menu__item']/a[contains(@href, 'homenew')]"));
//        wait.until(ExpectedConditions.elementToBeClickable(clickAllIpoteka));
//        clickAllIpoteka.click();

//        WebElement clickGotovoeJile = webDriver.findElement(By.xpath("//a[contains(@class, 'kitt-button') and contains(@data-product, 'Готовое жильё')]"));
//        wait.until(ExpectedConditions.elementToBeClickable(clickGotovoeJile));
//        clickGotovoeJile.click();

//        WebElement zagolovok = webDriver.findElement(By.xpath("//h1[contains(text(), 'калькулятор')]"));
//        wait.until(ExpectedConditions.visibilityOf(zagolovok));

//        WebElement inputPrice = webDriver.findElement(By.xpath("//div[contains(text(), 'Стоимость')]/.."));
//        inputPrice.click();
//        inputPrice.clear();
//        inputPrice.sendKeys("5180000");

//        WebElement perviiVznos = webDriver.findElement(By.xpath("//div[contains(text(), 'Первоначальный')]/.."));
//        perviiVznos.click();
//        perviiVznos.clear();
//        perviiVznos.sendKeys("3058000");

//        WebElement srok = webDriver.findElement(By.xpath("//div[contains(text(), 'Срок')]/.."));
//        srok.click();
//        srok.clear();
//        srok.sendKeys("30");

//        WebElement checkbox = webDriver.findElement(By.xpath("//span[contains(text(), 'Страхование')]/../../span/label/div/input"));
//        checkbox.click();


//        WebElement webElement = webDriver.findElement(By.xpath("//div[contains(@data-test-id, 'main-results')]/div/div/ul"));
//
//        WebElement checkSumma = webElement.findElement(By.xpath("./li[contains(@data-e2e-id, 'credit-sum')]/div/span[contains(@class, 'value')]"));
//        String summ = checkSumma.getText();
//        Assertions.assertEquals(summ, "2 122 000 ₽", "Сумма неверна");

//        WebElement checkEjMesPlat = webElement.findElement(By.xpath("./li[contains(@data-e2e-id, 'monthly-payment')]/div/span[contains(@class, 'value')]"));
//        String checkSummaTextStr = checkEjMesPlat.getText();
//        Assertions.assertEquals(checkSummaTextStr, "19 094 ₽", "Еж.мес.плат. неверен");

//        WebElement neobhodimDohod = webElement.findElement(By.xpath("./../../../div[contains(@class, 'bottomLine')]/div/div/span[contains(@class, 'value')]"));
//        String neobhodimDohodStr = neobhodimDohod.getText();
//        Assertions.assertEquals(neobhodimDohodStr, "24 580 ₽", "Неоходимый доход неверен");

//        WebElement procent = webElement.findElement(By.xpath("./li[contains(@data-e2e-id, 'credit-rate')]/div/div/div/div/div/div/span[contains(@class, 'value')]/span"));
//        String procentStr = procent.getText();
//        Assertions.assertEquals(procentStr, "11%", "Неоходимый доход неверен");


    }
}
