package main.java.issues;
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileBrowserType;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class AndroidTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AndroidTest";
    protected AndroidDriver driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "N2K7N16811000808");
        //dc.setBrowserName(MobileBrowserType.CHROMIUM);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);

        driver.setLogLevel(Level.INFO);

    }

    @Test
    public void testAndroidTest() {
        driver.get("https://www.wikipedia.org/");
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
        driver.pressKeyCode(AndroidKeyCode.HOME);

        driver.closeApp();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}