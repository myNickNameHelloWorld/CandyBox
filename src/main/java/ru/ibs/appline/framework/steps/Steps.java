package ru.ibs.appline.framework.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import ru.ibs.appline.framework.managers.PageManager;

public class Steps {
    private static final Logger logger = LoggerFactory.getLogger(Steps.class);
    PageManager pageManager = PageManager.getPageManager();

    @И("^Загружена стартовая страница$")
    public void getStartPage() {
        pageManager.getStartPage();
        logger.info("Загружена стартовая страница");
    }

    @И("^Закрытие окна куки$")
    public void clickCloseCookies() {
        pageManager.getStartPage().clickCloseCookies();
        logger.info("Закрытие окна куки");
    }

    @И("^Нажать на меню 'Ипотека'$")
    public void clickMortgageMenu() {
        pageManager.getStartPage().clickMortgageMenu();
        logger.info("Нажать на меню 'Ипотека'");
    }

    @И("^Нажать на подменю 'Все ипотечные кредиты'$")
    public void clickAllMortgageProducts() {
        pageManager.getStartPage().clickAllMortgageProducts();
        logger.info("Нажать на подменю 'Все ипотечные кредиты'");
    }

    @И("^Кликнуть на заголовок 'Готовое жилье'$")
    public void clickReadyHousing() {
        pageManager.getMortgagePage().clickReadyHousing();
        logger.info("Кликнуть на заголовок 'Готовое жилье'");
    }

    @И("^Проверка заголовка открывшейся страницы$")
    public void checkTitle() {
        pageManager.getMortgageCalculatorPage().checkTitle();
        logger.info("Проверка заголовка открывшейся страницы");
    }

    @И("^Заполнение формы поле/значение$")
    public void fillField(DataTable dataTable) {
        dataTable.asMap(String.class, String.class)
                .forEach((key, value) -> {
                    pageManager.getMortgageCalculatorPage().fillFieldPropertyValues((String) key, (String) value);
                    logger.info("Заполняем форму: поле - '{}', значение - '{}'", key, value);
                });
    }

    @И("^Кликнуть по кнопке 'Страхование жизни'$")
    public void clickCheckboxInsurance() {
        pageManager.getMortgageCalculatorPage().clickCheckboxInsurance();
        logger.info("Проверка заголовка открывшейся страницы");
    }

    @И("^Проверка поля '(.*)'$")
    public void checkSum(String nameField) {
        pageManager.getMortgageCalculatorPage().checkFieldOnPage(nameField);
        logger.info("Проверка поля '{}'", nameField);
    }


}
