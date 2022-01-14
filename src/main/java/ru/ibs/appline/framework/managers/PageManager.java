package ru.ibs.appline.framework.managers;

import ru.ibs.appline.framework.pages.CompaniesPage;
import ru.ibs.appline.framework.pages.HealthInsurancePage;
import ru.ibs.appline.framework.pages.StartPage;

public class PageManager {
    private static PageManager INSTANCE;
    private StartPage startPage;
    private CompaniesPage companiesPage;
    private HealthInsurancePage healthInsurancePage;


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

    public CompaniesPage getCompaniesPage() {
        if (companiesPage == null) {
            companiesPage = new CompaniesPage();
        }
        return companiesPage;
    }

    public HealthInsurancePage getHealthInsurancePage() {
        if (healthInsurancePage == null) {
            healthInsurancePage = new HealthInsurancePage();
        }
        return healthInsurancePage;
    }
}
