package main.java.issues;

/**
 * Created by eyal.neumann on 3/25/2018.
 */
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA21249 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA21249";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "b386670b67fa917c2a65a9f2d70470347457678b");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.UICatalog");
        dc.setCapability(MobileCapabilityType.APP, "cloud:uniqueName=Eyal");
        dc.setCapability("instrumentApp", true);

        //dc.setCapability("appVersion", "2306");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.UICatalog");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }
//SA22633
    @Test
    public void testSA21249() {
        String pageSource1 = driver.getPageSource();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}