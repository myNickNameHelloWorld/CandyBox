//package ru.ibs.appline.framework.utils;
//
//import io.qameta.allure.Attachment;
//import io.qameta.allure.junit5.AllureJunit5;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.TestWatcher;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import ru.ibs.appline.framework.managers.DriverManager;
//
//public class MyAllureListener extends AllureJunit5 implements TestWatcher {
//    protected DriverManager driverManager = DriverManager.getInstance();
//
//    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
//    public byte[] getScreenshot() {
//        return ((TakesScreenshot) driverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
//    }
//
//
//    @Override
//    public void testFailed(ExtensionContext context, Throwable cause) {
//        getScreenshot();
//    }
//}
