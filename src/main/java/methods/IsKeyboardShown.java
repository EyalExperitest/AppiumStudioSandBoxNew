package main.java.methods;

/**
 * Created by eyal.neumann on 1/17/2018.
 */
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.drivers.ExAndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

import static org.junit.Assert.*;

public class IsKeyboardShown {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "IsKeyboardShown";
    protected ExAndroidDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "090f1875");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new ExAndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testIsKeyboardShown() {
        String pageSource1 = driver.getPageSource();
        assertFalse(driver.isKeyboardShown());
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).click();
        assertTrue(driver.isKeyboardShown());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}