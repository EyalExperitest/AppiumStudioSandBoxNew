package main.java.issues;

//package <set your test package>;
import io.appium.java_client.android.Activity;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA23018 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA23018";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "CB5A2BSDEE");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        //driver.setLogLevel(Level.INFO);

    }

    @Test
    public void testSA23018() {
        String currentActivity = driver.currentActivity();
        System.out.println(currentActivity.toString());
        driver.startActivity(new Activity("io.appium.android.apis", ".view.Controls1"));
        String pageSource1 = driver.getPageSource();
        currentActivity = driver.currentActivity();
        System.out.println(currentActivity.toString());



    }

    @After
    public void tearDown() {
        driver.quit();
    }
}