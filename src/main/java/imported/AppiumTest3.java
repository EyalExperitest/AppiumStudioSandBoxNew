package main.java.imported;

// Insert your package here
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumTest3 {

    AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", "reports");
        dc.setCapability("reportFormat", "xml");
        dc.setCapability("testName", "AppiumTest3");
        dc.setCapability(MobileCapabilityType.UDID, "015d28568f541e0f");
        dc.setCapability("user", "eyal");
        // In case your user is assigned to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "");
        dc.setCapability("password", "Experitest2012");
        //dc.setCapability(MobileCapabilityType.APP, <PATH TO APPLICATION> ); // If you wish to continue with the app running on the device, comment this line
        driver = new AndroidDriver(new URL("https://qacloud.experitest.com:5555/wd/hub"), dc);
    }

    @Test
    public void testAppiumTest3(){
        System.out.println(driver.getPageSource());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}