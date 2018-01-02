package main.java.testrail.exported.applications;

/**
 * Created by Mac10 on 27/12/2017.
 */
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class InstalIOnIOS {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "InstalIOnIOS";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "25da8511aef7ea8331fdd0da3ed9ebca19d5da8d");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testInstalIOnIOS0() {

        driver.installApp("cloud:com.experitest.UICatalogTest");
        assert(driver.isAppInstalled("com.experitest.UICatalogTest"));

        driver.removeApp("cloud:com.experitest.UICatalogTest");
        assert(!driver.isAppInstalled("com.experitest.UICatalogTest"));

    }
    @Test
    public void testInstalIOnIOS1() {

        driver.removeApp("cloud:com.experitest.UICatalogTest");
        assert(!driver.isAppInstalled("com.experitest.UICatalogTest"));
        driver.installApp("cloud:com.experitest.UICatalogTest");
        assert(driver.isAppInstalled("com.experitest.UICatalogTest"));

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
