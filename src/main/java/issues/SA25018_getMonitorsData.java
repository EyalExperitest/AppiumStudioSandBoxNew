//package main.java.issues;
//import com.experitest.appium.SeeTestClient;
//import io.appium.java_client.remote.IOSMobileCapabilityType;
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.IOSElement;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.junit.*;
//import java.net.URL;
//import java.net.MalformedURLException;
//import java.util.logging.Level;
//
//public class SA25018_getMonitorsData {
//    private String reportDirectory = "reports";
//    private String reportFormat = "xml";
//    private String testName = "Untitled";
//    protected IOSDriver<IOSElement> driver = null;
//
//    DesiredCapabilities dc = new DesiredCapabilities();
//
//    @Before
//    public void setUp() throws MalformedURLException {
//        dc.setCapability("reportDirectory", reportDirectory);
//        dc.setCapability("reportFormat", reportFormat);
//        dc.setCapability("testName", testName);
//        dc.setCapability(MobileCapabilityType.UDID, "cbc20b1088c65f4a27dca70b158843f69f249a64");
//        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.UICatalog");
//        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
//        driver.setLogLevel(Level.INFO);
//    }
//
//
//    @Test
//    public void testUntitled() {
//        SeeTestClient client=new SeeTestClient(driver);
//        //client.launch("com.experitest.UICatalog", true, false);
////        String pageSource = driver.getPageSource();
////        System.out.println(pageSource);
//        System.out.println("Start");
//        System.out.println(client.getVersionWithBuild());
//
//        client.startMonitor("com.experitest.UICatalog");
//        client.click("NATIVE", "//*[@text='GLKit' and @class='UIAStaticText']", 0, 1);
//        client.sleep(10000);
//        String str0 = client.getMonitorsData();
//        System.out.println(str0);
//        System.out.println("Done");
//
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//}