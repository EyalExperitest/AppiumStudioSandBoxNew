//package main.java.extended;
//
////package <set your test package>;
//import com.experitest.appium.SeeTestClient;
//import io.appium.java_client.remote.AndroidMobileCapabilityType;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.junit.*;
//import java.net.URL;
//import java.net.MalformedURLException;
//import java.util.logging.Level;
//
//public class AppiumReport {
//    private String reportDirectory = "reports";
//    private String reportFormat = "xml";
//    private String testName = "AppiumReport";
//    protected AndroidDriver<AndroidElement> driver = null;
//
//    DesiredCapabilities dc = new DesiredCapabilities();
//
//    @Before
//    public void setUp() throws MalformedURLException {
//        dc.setCapability("reportDirectory", reportDirectory);
//        dc.setCapability("reportFormat", reportFormat);
//        dc.setCapability("testName", testName);
//        dc.setCapability(MobileCapabilityType.UDID, "9a3efe031d62cfc2");
//        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
//        driver.setLogLevel(Level.INFO);
//    }
//
//    @Test
//    public void testAppiumReport2Slashes() {
//        SeeTestClient client = new SeeTestClient(driver);
//        String path = "C:\\Pic\\x.png";
//        client.report(path,"Reporting String :"+ path,true);
//
//
//    }
//    @Test
//    public void testAppiumReport4Slashes() {
//        SeeTestClient client = new SeeTestClient(driver);
//        String path = "C:\\\\Pic\\\\x.png";
//        client.report(path,"Reporting String :"+ path,true);
//    }
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//}