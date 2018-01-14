package main.java.testrail.exported.applications;

/**
 * Created by Mac10 on 27/12/2017.
 */

//package <set your test package>;
import io.appium.java_client.android.Activity;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class LaunchApplicationsOnAndroid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "LaunchApplicationsOnAndroid";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "3801a15c53ba3300");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testLaunchApplicationsOnAndroid1() {
        driver.closeApp();
        System.out.println(driver.getPageSource());
        driver.startActivity(new Activity("com.experitest.ExperiBank", ".LoginActivity"));
        //driver.startActivity("com.experitest.ExperiBank", ".LoginActivity");
        System.out.println(driver.getPageSource());
        driver.closeApp();
        System.out.println(driver.getPageSource());
    }

    @Test
    public void testLaunchApplicationsOnAndroid2() {
        driver.closeApp();
        System.out.println(driver.getPageSource());
        driver.startActivity(new Activity("cloud:com.experitest.ExperiBank", ".LoginActivity"));
        //driver.startActivity("com.experitest.ExperiBank", ".LoginActivity");
        System.out.println(driver.getPageSource());
        driver.closeApp();
        System.out.println(driver.getPageSource());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}