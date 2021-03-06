package main.java.exceptiontests.initiation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class NotInstrumentedAppIOS {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "NoAppInstalled";
    protected IOSDriver driver = null;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "817c13817e7e131bdbb0fe8ce94f944051dd3422");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.apple.mobiletimer");
        dc.setCapability("instrumentApp", true);
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testNoAppInstalled() {
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}