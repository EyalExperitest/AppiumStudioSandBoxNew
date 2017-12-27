package main.java.grid;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class IOSGrid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "IOSGrid";
    protected IOSDriver driver = null;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("user", "admin");
        dc.setCapability("password", "Experitest2012");
        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "");
        dc.setCapability(MobileCapabilityType.UDID, "e323acec7ba4322be383a7c431d8a7d8739b581b");
        //dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "cloud:com.experitest.ExperiBank");
        driver = new IOSDriver(new URL("https://eyalneumann.experitest.local:8091/wd/hub"), dc);
    }

    @Test
    public void testIOSGrid() {
        String pageSource1 = driver.getPageSource();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}