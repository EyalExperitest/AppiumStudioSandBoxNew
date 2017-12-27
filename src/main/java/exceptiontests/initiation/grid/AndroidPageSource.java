package main.java.exceptiontests.initiation.grid;
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.tools.URLReader;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;

import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

public class AndroidPageSource {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AndroidPageSource";
    protected AndroidDriver driver = null;

    @Before
    public void setUp() throws IOException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("user", "eyal");
        dc.setCapability("password", "Experitest2012");
        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "Default");
        dc.setCapability(MobileCapabilityType.UDID, "d0595c1001b9d9d4");
        String getStringFromURL = URLReader.getStringFromURL("http://eyalneumann.experitest.local:8091/wd/hub/sessions");
        System.out.println(getStringFromURL);
        driver = new AndroidDriver(new URL("http://eyalneumann.experitest.local:8091/wd/hub"), dc);
    }

    @Test
    public void testAndroidPageSource() throws InterruptedException {
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
        Thread.sleep(5000);
        String pageSource2 = driver.getPageSource();
        System.out.println(pageSource2);
        Thread.sleep(5000);
        String pageSource3 = driver.getPageSource();
        System.out.println(pageSource3);
        Thread.sleep(5000);
        pageSource3 = driver.getPageSource();
        System.out.println(pageSource3);
        Thread.sleep(5000);
        pageSource3 = driver.getPageSource();
        System.out.println(pageSource3);
        Thread.sleep(5000);
        pageSource3 = driver.getPageSource();
        System.out.println(pageSource3);
        Thread.sleep(5000);
        pageSource3 = driver.getPageSource();
        System.out.println(pageSource3);
        Thread.sleep(5000);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
