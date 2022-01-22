package ru.ibs.appline.tests;

import org.junit.jupiter.api.Test;
import ru.ibs.appline.tests.base.BaseTests;


public class SberTest extends BaseTests {

    @Test
    public void test() {
        pageManager.getStartPage()
                .clickCloseCookies()
                .clickMortgageMenu()
                .clickAllMortgageProducts()
                .clickReadyHousing()
                .checkTitle()
                .fillFieldPropertyValues("Стоимость недвижимости", "5 180 000")
                .fillFieldPropertyValues("Первоначальный взнос", "3 058 000")
                .fillFieldPropertyValues("Срок кредита", "30")
                .clickCheckboxInsurance()
                .checkPropertyValues()
                .checkInitialPayment()
                .checkRequiredIncome()
                .checkCreditPercent();
    }
}
