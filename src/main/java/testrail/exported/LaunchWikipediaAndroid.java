package main.java.testrail.exported;

/**
 * Created by eyal.neumann on 12/21/2017.
 */
//package <set your test package>;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.drivers.ExAndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class LaunchWikipediaAndroid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "LaunchWikipediaAndroid";
    protected ExAndroidDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "CB5A25AM17");
        dc.setBrowserName(MobileBrowserType.CHROMIUM);
        driver = new ExAndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testLaunchWikipediaAndroid() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}