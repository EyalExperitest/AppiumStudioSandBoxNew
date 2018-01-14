package main.java.testrail.exported.applications;

/**
 * Created by Mac10 on 27/12/2017.
 */
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class InstallOnAndroid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "InstallOnAndroid";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "015d28568f541e0f");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testInstallOnAndroid0() {

        driver.installApp("cloud:com.experitest.ExperiBank/.LoginActivity");
        assert(driver.isAppInstalled("com.experitest.ExperiBank"));

        driver.removeApp("cloud:com.experitest.ExperiBank/.LoginActivity");
        assert(!driver.isAppInstalled("com.experitest.ExperiBank"));

    }
    @Test
    public void testInstallOnAndroid1() {

        driver.removeApp("cloud:com.experitest.ExperiBank/.LoginActivity");
        assert(!driver.isAppInstalled("com.experitest.ExperiBank"));

        driver.installApp("cloud:com.experitest.ExperiBank/.LoginActivity");
        assert(driver.isAppInstalled("com.experitest.ExperiBank"));



    }
    @After
    public void tearDown() {
        driver.quit();
    }
}