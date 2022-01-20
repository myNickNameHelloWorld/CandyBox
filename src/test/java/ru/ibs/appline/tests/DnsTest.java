package ru.ibs.appline.tests;

import org.junit.jupiter.api.Test;
import ru.ibs.appline.framework.product.Product;
import ru.ibs.appline.tests.base.BaseDnsTests;

public class DnsTest extends BaseDnsTests {


    @Test
    public void test() {
        pageManager.getStartPage()
                .searchProduct("nintendo switch")
                .clickProductInSearch("Консоль")
                .savePrice()
                .clickWarranty("24")
                .savePriceWithWarranty()
                .clickBuy()
                .searchFromProductPage("Detroit")
                .clickProductInSearch("Detroit")
                .savePrice()
                .clickBuy()
                .checkPriceInCart()
                .goToTheCart()
                .checkWarrantyPeriod("24")
                .checkSumPrice()
                .deleteDetroit("Detroit")
                .checkPriceAfterDelete()
                .addProduct(2)
                .checkPriceAfterAdd(2)
                .returnDetroit("Detroit")
                .checkSumPriceAfterReturn();

        for (Product product: Product.list) {
            System.out.println(product.getName() + " " + product.getPrice());

        }
    }
}
