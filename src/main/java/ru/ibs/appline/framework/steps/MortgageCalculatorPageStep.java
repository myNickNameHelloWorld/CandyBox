package ru.ibs.appline.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import ru.ibs.appline.framework.managers.PageManager;

public class MortgageCalculatorPageStep {
    PageManager pageManager = PageManager.getPageManager();

    @И("^Проверка заголовка открывшейся страницы$")
    public void checkTitle() {
        pageManager.getMortgageCalculatorPage().checkTitle();
    }

    @И("^Заполнение формы поле/значение$")
    public void fillField(DataTable dataTable) {
        dataTable.asMap(String.class, String.class)
                .forEach((key, value) -> {
                    pageManager.getMortgageCalculatorPage().fillFieldPropertyValues((String) key, (String) value);
                });
    }

    @И("^Кликнуть по кнопке 'Страхование жизни'$")
    public void clickCheckboxInsurance() {
        pageManager.getMortgageCalculatorPage().clickCheckboxInsurance();
    }

    @И("^Проверка поля '(.*)'$")
    public void checkSum(String nameField) {
        pageManager.getMortgageCalculatorPage().checkFieldOnPage(nameField);
    }
}
