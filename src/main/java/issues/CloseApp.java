package main.java.issues;
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
import java.util.logging.Level;

public class CloseApp {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "CloseApp";
    protected IOSDriver driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "e323acec7ba4322be383a7c431d8a7d8739b581b");
        dc.setBrowserName(MobileBrowserType.SAFARI);
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);

    }

    @Test
    public void testCloseApp() {
        driver.get("https://www.wikipedia.org/");
        //driver.executeScript("client:client.deviceAction(\"HOME\");");

        driver.closeApp();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}