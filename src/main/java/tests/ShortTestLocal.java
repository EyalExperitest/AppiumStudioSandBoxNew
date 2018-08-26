package main.java.tests;

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

public class ShortTestLocal {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "ShortTest";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("waitForDeviceTimeout", 100);

        dc.setCapability(MobileCapabilityType.UDID, "7dab622e4213cc503ccca3fa4a213645d7f9e5da 0000");
        long t0=System.currentTimeMillis();
        try {
            driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        } catch (Exception e) {
            long t1=System.currentTimeMillis();
            long dt=t1-t0;
            System.out.println("Time :"+dt);
            throw e;
        }
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testShortTest() {
        String pageSource1 = driver.getPageSource();
        driver.context("NATIVE_APP");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}