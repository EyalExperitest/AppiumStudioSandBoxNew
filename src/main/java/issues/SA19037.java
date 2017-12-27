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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.net.MalformedURLException;

public class SA19037 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA19037";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "1a82ed68650af0aeacfed141bab6bfb8e8662d29");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
//      dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "cloud:com.experitest.ExperiBank");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");

        dc.setCapability("instrumentApp", true);
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);

    }

    @Test
    public void testSA19037() {
        driver.context("NATIVE_APP");
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        String className = "UIAScrollView";
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
        driver.findElement(By.className(className));
        String attribute1 = driver.findElement(By.className(className)).getAttribute("Type");
        System.out.println("Type : "+attribute1);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}