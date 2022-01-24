package ru.ibs.appline.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.appline.framework.managers.PageManager;

public class StartPageStep {
    PageManager pageManager = PageManager.getPageManager();

    @И("^Загружена стартовая страница$")
    public void getStartPage() {
        pageManager.getStartPage();
    }

    @И("^Закрытие окна куки$")
    public void clickCloseCookies() {
        pageManager.getStartPage().clickCloseCookies();
    }

    @И("^Нажать на меню 'Ипотека'$")
    public void clickMortgageMenu() {
        pageManager.getStartPage().clickMortgageMenu();
    }

    @И("^Нажать на подменю 'Все ипотечные кредиты'$")
    public void clickAllMortgageProducts() {
        pageManager.getStartPage().clickAllMortgageProducts();
    }


}
