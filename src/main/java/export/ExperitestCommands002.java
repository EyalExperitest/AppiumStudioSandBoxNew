package main.java.export;
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

public class ExperitestCommands002 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "ExperitestCommands002";
    protected IOSDriver driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "e323acec7ba4322be383a7c431d8a7d8739b581b");
        //dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudio\\original-apks\\EriBank.ipa");
        //dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testExperitestCommands002() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
        driver.executeScript("client:client.deviceAction(\"Home\")");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}