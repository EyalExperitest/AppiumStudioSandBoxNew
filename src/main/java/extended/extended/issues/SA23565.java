//package main.java.extended.extended.issues;
////package <set your test package>;
//
//import com.experitest.appium.SeeTestClient;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.remote.MobileBrowserType;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.logging.Level;
//
//public class SA23565 {
//    private String reportDirectory = "reports";
//    private String reportFormat = "xml";
//    private String testName = "SA23565";
//    protected AndroidDriver<AndroidElement> driver = null;
//
//    DesiredCapabilities dc = new DesiredCapabilities();
//
//    @Before
//    public void setUp() throws MalformedURLException {
//        dc.setCapability("reportDirectory", reportDirectory);
//        dc.setCapability("reportFormat", reportFormat);
//        dc.setCapability("testName", testName);
//        dc.setCapability(MobileCapabilityType.UDID, "dcd3b654");
//        dc.setBrowserName(MobileBrowserType.CHROMIUM);
//
//        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
//        driver.setLogLevel(Level.INFO);
//    }
//
//    @Test
//    public void testSA23565() {
//        SeeTestClient client = new SeeTestClient(driver);
//        client.hybridClearCache();
//        driver.get("https://en.wikipedia.org/wiki/Jerusalem");
//
//
//
//    }
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//}