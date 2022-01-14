package ru.ibs.appline.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.ibs.appline.framework.utils.PropsConst;

public class DriverManager {
    private static DriverManager INSTANCE = null;
    private WebDriver webDriver;
    TestPropManager testPropManager = TestPropManager.getInstance();

    private DriverManager() {

    }

    public static DriverManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            initDriver();
        }
        return webDriver;
    }

    public void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    private void initDriver() {

        if (testPropManager.getProperty(PropsConst.TYPE_BROWSER).equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", testPropManager.getProperty(PropsConst.PATH_GECKO_DRIVER));
            webDriver = new FirefoxDriver();
        } else if (testPropManager.getProperty(PropsConst.TYPE_BROWSER).equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", testPropManager.getProperty(PropsConst.PATH_CHROME_DRIVER));
            webDriver = new ChromeDriver();
        }
//        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
