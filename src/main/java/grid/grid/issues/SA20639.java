package main.java.grid.grid.issues;

/**
 * Created by eyal.neumann on 12/7/2017.
 */
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.drivers.ExAndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA20639 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA20639";
    protected ExAndroidDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("username", "eyal");
        dc.setCapability("password", "Experitest2012");
        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "");
        dc.setCapability(MobileCapabilityType.UDID, "dcd3b654");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");

        driver = new ExAndroidDriver(new URL("https://qacloud.experitest.com/wd/hub"), dc);
    }

    @Test
    public void testSA20639() {
        String pageSource1 = driver.getPageSource();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}