package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA18481 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA18481";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "N2K7N16811000808");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA18481() {
        boolean locked = driver.isLocked();
        System.out.println(locked);
        driver.lockDevice();
        locked = driver.isLocked();
        System.out.println("Now Device is locked");
        try{Thread.sleep(10000);} catch(Exception ignore){}
        System.out.println(locked);
        driver.unlockDevice();
        locked = driver.isLocked();
        System.out.println(locked);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}