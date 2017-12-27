package main.java.issues;

//package <set your test package>;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA18682 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA18682";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "60ab9979d3fbef1c2692ac9b2b0aa766cb3efb44");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\UICatalog.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.UICatalog");
        dc.setCapability("instrumentApp", true);
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA18682A() {
        String pageSource1 = driver.getPageSource();
        driver.executeScript("client:client.report(\"This is a custom message inserted into the test report.\", false)", "");

    }
    @Test
    public void testSA18682B() {
        String pageSource1 = driver.getPageSource();
        driver.executeScript("client:client.report(\"This is a custom message inserted into the test report.\", true)", "");

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}