package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA18317 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA18317";
    protected IOSDriver driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "817c13817e7e131bdbb0fe8ce94f944051dd3422");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA18317() {
        driver.executeScript("client:client.deviceAction(\"Recent Apps\")");
        driver.executeScript("client:client.deviceAction(\"Home\")");
        driver.executeScript("client:client.deviceAction(\"Power\")");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}