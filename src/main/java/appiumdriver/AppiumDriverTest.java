package main.java.appiumdriver;

/**
 * Created by eyal.neumann on 2/25/2018.
 */
//package <set your test package>;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class AppiumDriverTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AppiumDriverTest";
    protected AppiumDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        //dc.setCapability(MobileCapabilityType.DEVICE_NAME, "adb:A0001");
        dc.setCapability("deviceQuery", "@os='android'");
        driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test(invocationCount = 10,alwaysRun = true)
    public void testAppiumDriverTest() {
        Object result1 = driver.executeScript("client:client.getDeviceProperty(\"device.name\")");
        System.out.println(result1.toString());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}