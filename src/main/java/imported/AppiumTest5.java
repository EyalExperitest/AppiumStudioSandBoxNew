package main.java.imported;

/**
 * Created by eyal.neumann on 12/17/2017.
 */
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumTest5 {

    AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", "reports");
        dc.setCapability("reportFormat", "xml");
        dc.setCapability("testName", "Untitled");
        dc.setCapability(MobileCapabilityType.UDID, "25da8511aef7ea8331fdd0da3ed9ebca19d5da8d");
        dc.setCapability("user", "eyal");
        // In case your user is assigned to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "");
        dc.setCapability("password","Experitest2012");
        //dc.setCapability(MobileCapabilityType.APP, <PATH TO APPLICATION> ); // If you wish to continue with the app running on the device, comment this line
        driver = new IOSDriver(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
    }

    @Test
    public void testUntitled(){
        System.out.println(driver.getPageSource());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}