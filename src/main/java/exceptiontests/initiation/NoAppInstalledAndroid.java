package main.java.exceptiontests.initiation;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;


import java.net.MalformedURLException;
import java.net.URL;

public class NoAppInstalledAndroid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "NoAppInstalled";
    protected AndroidDriver driver = null;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "d0595c1001b9d9d4");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.CameraFlash");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);

    }

    @Test
    public void testNoAppInstalled() {
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}