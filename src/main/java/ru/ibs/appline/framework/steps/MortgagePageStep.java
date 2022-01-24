package ru.ibs.appline.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.appline.framework.managers.PageManager;

public class MortgagePageStep {
    PageManager pageManager = PageManager.getPageManager();

    @И("^Кликнуть на заголовок 'Готовое жилье'$")
    public void clickReadyHousing() {
        pageManager.getMortgagePage().clickReadyHousing();
    }
}
