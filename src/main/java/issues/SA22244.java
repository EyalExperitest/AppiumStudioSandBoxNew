package main.java.issues;

/**
 * Created by eyal.neumann on 3/25/2018.
 */
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA22244 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA22244";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        //dc.setCapability(MobileCapabilityType.UDID, "N2K7N16811000417");
        //dc.setCapability(MobileCapabilityType.UDID, "MWS0216817004401");
        //dc.setCapability(MobileCapabilityType.UDID, "CB5A25AM17");
        dc.setCapability(MobileCapabilityType.UDID, "N2K7N16811000417");

        //dc.setBrowserName(MobileBrowserType.CHROMIUM);
        dc.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testSA22244() {
        driver.get("https://www.wikipedia.org/");
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}