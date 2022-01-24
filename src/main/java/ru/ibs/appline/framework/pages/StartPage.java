package ru.ibs.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(xpath = "//a[contains(@aria-label, 'Ипотека')]")
    private WebElement clickMortgage;

    @FindBy(xpath = "//li[@class='kitt-top-menu__item']/a[contains(@href, 'homenew')]")
    private WebElement clickAllMortgage;

    @FindBy(xpath = "//button[@class='kitt-cookie-warning__close']")
    private WebElement closeCookies;


    public StartPage clickCloseCookies() {
        waitUntilElementToBeClickable(closeCookies).click();
        return pageManager.getStartPage();
    }

    public StartPage clickMortgageMenu() {
        ;
        clickMortgage.click();
        return pageManager.getStartPage();
    }

    public MortgagePage clickAllMortgageProducts() {
        waitUntilElementToBeClickable(clickAllMortgage).click();
        return pageManager.getMortgagePage();
    }

}
