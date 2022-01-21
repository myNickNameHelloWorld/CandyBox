package ru.ibs.appline.framework.managers;

import ru.ibs.appline.framework.pages.MortgageCalculatorPage;
import ru.ibs.appline.framework.pages.MortgagePage;
import ru.ibs.appline.framework.pages.StartPage;

public class PageManager {
    private static PageManager INSTANCE;
    private StartPage startPage;
    private MortgagePage mortgagePage;
    private MortgageCalculatorPage mortgageCalculatorPage;


    private PageManager() {

    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public MortgagePage getMortgagePage() {
        if (mortgagePage == null) {
            mortgagePage = new MortgagePage();
        }
        return mortgagePage;
    }

    public MortgageCalculatorPage getMortgageCalculatorPage() {
        if (mortgageCalculatorPage == null) {
            mortgageCalculatorPage = new MortgageCalculatorPage();
        }
        return mortgageCalculatorPage;
    }

}
