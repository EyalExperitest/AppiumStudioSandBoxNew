package main.java.testrail.exported.rotate;

/**
 * Created by eyal.neumann on 12/21/2017.
 */
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class RotateIOSTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "RotateIOSTest";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "8a81b1e32471f53ac99a741bcc14bd6b84991fff");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        //dc.setBrowserName(MobileBrowserType.SAFARI);

        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testRotateIOSTest() {
        driver.launchApp();
        driver.rotate(ScreenOrientation.LANDSCAPE);
        ScreenOrientation orientation = driver.getOrientation();
        System.out.println("orientation : "+orientation);
        assertEquals(orientation,ScreenOrientation.LANDSCAPE);
        driver.getPageSource();

        driver.rotate(ScreenOrientation.PORTRAIT);
        orientation = driver.getOrientation();
        System.out.println("orientation : "+orientation);
        assertEquals(orientation,ScreenOrientation.PORTRAIT);
        driver.getPageSource();

        driver.get("https://www.wikipedia.org/");
        driver.rotate(ScreenOrientation.LANDSCAPE);
        orientation = driver.getOrientation();
        System.out.println("orientation : "+orientation);
        assertEquals(orientation,ScreenOrientation.LANDSCAPE);
        driver.getPageSource();

        driver.rotate(ScreenOrientation.PORTRAIT);
        orientation = driver.getOrientation();
        System.out.println("orientation : "+orientation);
        assertEquals(orientation,ScreenOrientation.PORTRAIT);
        driver.getPageSource();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}