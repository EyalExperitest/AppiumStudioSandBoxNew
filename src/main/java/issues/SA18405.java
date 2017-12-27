package main.java.issues;
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.junit.*;
import java.net.URL;
import java.io.File;
import java.net.MalformedURLException;

public class SA18405 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA18405";
    protected AndroidDriver driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "N2K7N16811000417");
    /*  dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "cloud:com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");*/

        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");


        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA18405() {
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
        File screenshotFile1 = driver.getScreenshotAs(OutputType.FILE);
        System.out.println(screenshotFile1.getAbsolutePath());
        String pageSource2 = driver.getPageSource();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}