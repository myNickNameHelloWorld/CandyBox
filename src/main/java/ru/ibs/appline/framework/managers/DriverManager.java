package ru.ibs.appline.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.ibs.appline.framework.utils.PropsConst;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverManager {
    private static DriverManager INSTANCE = null;
    private WebDriver webDriver;
    TestPropManager testPropManager = TestPropManager.getTestPropManager();

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
//            FirefoxProfile ffp = new FirefoxProfile(new File("C:\\Users\\Admin\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\6gg4lnvq.default-release-1642532833272"));
//            FirefoxOptions opt = new FirefoxOptions();
//            opt.setProfile(ffp);
            webDriver = new FirefoxDriver();
        } else if (testPropManager.getProperty(PropsConst.TYPE_BROWSER).equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", testPropManager.getProperty(PropsConst.PATH_CHROME_DRIVER));
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--user-data-dir=C:\\Users\\Admin\\AppData\\Local\\Google\\Chrome\\User Data");
            webDriver = new ChromeDriver();
        } else if (testPropManager.getProperty(PropsConst.TYPE_BROWSER).equals("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("firefox");
            capabilities.setVersion("66.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);

            try {
                webDriver = new RemoteWebDriver(
                        URI.create("http://selenoid.appline.ru:4445/wd/hub").toURL(),
                        capabilities
                );
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
}
