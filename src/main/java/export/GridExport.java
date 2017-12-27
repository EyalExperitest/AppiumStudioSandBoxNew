package main.java.export;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;

import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;

public class GridExport {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "GridExport001";
    protected IOSDriver driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", new File(reportDirectory).getAbsolutePath());
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("user", "eyal");
        dc.setCapability("password", "Experitest2012");
        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "Default");
        dc.setCapability(MobileCapabilityType.UDID, "1a82ed68650af0aeacfed141bab6bfb8e8662d29");
        //dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "cloud:com.experitest.ExperiBank");
        driver = new IOSDriver(new URL("http://qacloud.experitest.com/wd/hub"), dc);
    }

    @Test
    public void testGridExport001() {
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}