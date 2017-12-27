package main.java.issues;
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA18837 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA18837";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "17b3dcc17d43");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA18837() {
        driver.pressKeyCode(AndroidKeyCode.HOME);
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_WAKEUP);
        driver.rotate(ScreenOrientation.LANDSCAPE);
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.executeScript("client:client.deviceAction(\"Change Orientation\")");
        driver.pressKeyCode(AndroidKeyCode.MENU);
        driver.unlockDevice();
        driver.executeScript("client:client.deviceAction(\"Paste\")");
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}