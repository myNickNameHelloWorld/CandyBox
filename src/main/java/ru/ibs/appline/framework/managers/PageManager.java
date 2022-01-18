package ru.ibs.appline.framework.managers;

import ru.ibs.appline.framework.pages.BucketPage;
import ru.ibs.appline.framework.pages.ProductPage;
import ru.ibs.appline.framework.pages.SearchPage;
import ru.ibs.appline.framework.pages.StartPage;

public class PageManager {
    private static PageManager INSTANCE;
    private StartPage startPage;
    private ProductPage productPage;
    private SearchPage searchPage;
    private BucketPage bucketPage;


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

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }

    public BucketPage getBucketPage() {
        if (bucketPage == null) {
            bucketPage = new BucketPage();
        }
        return bucketPage;
    }
}
