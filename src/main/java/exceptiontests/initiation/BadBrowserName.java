package main.java.exceptiontests.initiation;
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class BadBrowserName {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "BadBrowserName";
    protected IOSDriver driver = null;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "817c13817e7e131bdbb0fe8ce94f944051dd3422");
        //dc.setBrowserName(MobileBrowserType.SAFARI);
        dc.setBrowserName(MobileBrowserType.SAFARI);
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testBadBrowserName() {
        driver.get("http://");
        String pageSource1 = driver.getPageSource();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}