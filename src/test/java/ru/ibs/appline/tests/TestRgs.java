package ru.ibs.appline.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.ibs.appline.tests.base.BaseTests;

public class TestRgs extends BaseTests {

    @ParameterizedTest
    @CsvSource(value = {"Гомер Симпсон, Спрингфилд", "Джоджо Бинкс, Набу", "Безумны Макс, Земля"})
    public void test(String s, String st) {
        pageManager.getStartPage().cookiesClose()
                .selectBaseMenuText("Компаниям")
                .selectSubMenuText("Здоровье")
                .selectSubHealthMenuText("Добровольное")
                .clickSendRequest()
                .checkOpenPage()
                .checkInputFieldPage()
                .fillField("ФИО", s)
                .fillField("Номер телефона", "9997775533")
                .fillField("Почта", "qwertyqwerty")
                .fillField("Адрес", st)
                .clickCheckBox()
                .clickSubmitMe()
                .checkEmailError();
    }
}
