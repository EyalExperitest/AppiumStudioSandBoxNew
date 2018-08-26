//package main.java.extended.extended.issues;
//
////package <set your test package>;
//import com.experitest.appium.SeeTestClient;
//import io.appium.java_client.remote.IOSMobileCapabilityType;
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.IOSElement;
//import io.appium.java_client.remote.MobileBrowserType;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.OutputType;
//import java.io.File;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.junit.*;
//import java.net.URL;
//import java.net.MalformedURLException;
//import java.util.logging.Level;
//
//public class SA23565IOS {
//    private String reportDirectory = "reports";
//    private String reportFormat = "xml";
//    private String testName = "SA23565IOS";
//    protected IOSDriver<IOSElement> driver = null;
//
//    DesiredCapabilities dc = new DesiredCapabilities();
//
//    @Before
//    public void setUp() throws MalformedURLException {
//        dc.setCapability("reportDirectory", reportDirectory);
//        dc.setCapability("reportFormat", reportFormat);
//        dc.setCapability("testName", testName);
//        dc.setCapability(MobileCapabilityType.UDID, "ed4c083e3c574b90171f8bdeadec07d0e1985ec9");
//        dc.setBrowserName(MobileBrowserType.SAFARI);
//        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
//        driver.setLogLevel(Level.INFO);
//    }
//
//    @Test
//    public void testSA23565IOS() {
//        SeeTestClient client = new SeeTestClient(driver);
//        driver.get("https://www.wikipedia.org/");
//        driver.get("https://en.wikipedia.org/wiki/Jerusalem");
//        client.hybridClearCache();
//
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//}