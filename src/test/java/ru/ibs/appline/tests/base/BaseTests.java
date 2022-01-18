//package ru.ibs.appline.tests.base;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import ru.ibs.appline.framework.managers.DriverManager;
//import ru.ibs.appline.framework.managers.InitManager;
//import ru.ibs.appline.framework.managers.PageManager;
//import ru.ibs.appline.framework.managers.TestPropManager;
//import ru.ibs.appline.framework.utils.PropsConst;
//
//public class BaseTests {
//    private final DriverManager driverManager = DriverManager.getInstance();
//    private final TestPropManager testPropManager = TestPropManager.getInstance();
//    protected PageManager pageManager = PageManager.getInstance();
//
//
//    @BeforeAll
//    public static void beforeAll() {
//        InitManager.initFramework();
//    }
//
//
//    @BeforeEach
//    public void before() {
//        driverManager.getWebDriver().get(testPropManager.getProperty(PropsConst.BASE_URL));
//    }
////    @AfterEach
////    public void afterEach() {
////        driverManager.getWebDriver().quit();
////    }
//
//
//    @AfterAll
//    public static void after() {
//        InitManager.quitFramework();
//    }
//
//
//}
