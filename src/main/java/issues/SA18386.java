package main.java.issues;

//package <set your test package>;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA18386 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA18386";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "17b3dcc17d43");
        dc.setBrowserName(MobileBrowserType.CHROMIUM);
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA18386() {
        driver.get("https://www.wikipedia.org/");
        String pageSource1 = driver.getPageSource();
        driver.pressKeyCode(AndroidKeyCode.HOME);
        driver.closeApp();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}