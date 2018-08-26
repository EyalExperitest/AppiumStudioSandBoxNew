package main.java.imported;

// Insert your package here
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumTest {
    static {
        System.getProperties().setProperty("javax.net.ssl.trustStore","C:\\Users\\eyal.neumann\\Documents\\keys3\\truststore.jks");
        System.getProperties().setProperty("javax.net.ssl.trustStorePassword","");

    }
    AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", "reports");
        dc.setCapability("reportFormat", "xml");
        dc.setCapability("testName", "dontGoHomeOnQuit issue");
        //dc.setCapability(MobileCapabilityType.UDID, "1115fb3c0e5f3c03");
        dc.setCapability("user", "admin");
        // In case your user is assigned to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "");
        dc.setCapability("password","Experitest2012");
        //dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.eribank/com.experitest.ExperiBank.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.eribank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.experitest.ExperiBank.LoginActivity");
        dc.setCapability("instrumentApp", false);
//        dc.setCapability(MobileCapabilityType.UDID, "1115fb3c0e5f3c03");
        dc.setCapability(MobileCapabilityType.UDID, "14bdd0fd9904");

        dc.setCapability("dontGoHomeOnQuit", true);


        driver = new AndroidDriver(new URL("https://eyalneumann.experitest.local:8091/wd/hub"), dc);
        //       driver = new AndroidDriver(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
    }

    @Test
    public void testUntitled(){
        //Enter your test code here
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}