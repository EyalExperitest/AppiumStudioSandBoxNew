package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA18385 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA18385";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "00d064b580b7e36184819a9ce668f8c9f1d2413f");
        dc.setBrowserName(MobileBrowserType.SAFARI);
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testSA18385() throws InterruptedException {
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println(title);
        driver.executeScript("client:client.deviceAction(\"Home\")");

        driver.closeApp();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}