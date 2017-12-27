package main.java.grid;

//package <set your test package>;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSGrid2 {
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
        dc.setCapability("user", "eyal");
        dc.setCapability("password", "Experitest2012");
        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "");
        dc.setCapability(MobileCapabilityType.UDID, "9d859c70b91377a49293858ac66dd89fec6653f8");
        //dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBankO");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBankO");
        driver = new IOSDriver(new URL("http://qacloud.experitest.com/wd/hub"), dc);
    }

    @Test
    public void testIOSGrid() throws InterruptedException {
        String pageSource1 = driver.getPageSource();
        Thread.sleep(5000);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}