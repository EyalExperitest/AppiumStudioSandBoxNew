package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA19304 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA19304";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "e323acec7ba4322be383a7c431d8a7d8739b581b");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.BrowserO");
        dc.setCapability("instrumentApp", true);
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA19304() {
        String pageSource1 = driver.getPageSource();
        //driver.swipe(500, 1000, 500, 200, 1000);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}