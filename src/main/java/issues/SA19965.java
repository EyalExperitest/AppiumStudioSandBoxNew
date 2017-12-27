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

public class SA19965 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA19965";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "f759ec5d8343175b2c68f856c9c47559aa1fc0fc");
        //dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\EriBank.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA19965() {
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}