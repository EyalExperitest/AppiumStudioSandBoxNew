package main.java.export;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class AppiumDriverBasic {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AppiumDriverBasic";
    protected AndroidDriver driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "N2K7N16811000808");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudio\\original-apks\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testAppiumDriverBasic() throws InterruptedException {

        Thread.sleep(5000);
        boolean locked = driver.isLocked();
        System.out.println(locked);
        driver.lockDevice();
        locked = driver.isLocked();
        System.out.println(locked);
        driver.unlockDevice();
        locked = driver.isLocked();
        System.out.println(locked);
/*
        ScreenOrientation orientation = driver.getOrientation();
        System.out.println(orientation);
        driver.rotate(ScreenOrientation.LANDSCAPE);
        orientation = driver.getOrientation();
        System.out.println(orientation);

        driver.rotate(ScreenOrientation.PORTRAIT);
        orientation = driver.getOrientation();
        System.out.println(orientation);

        driver.openNotifications();
        String pageSource1 = driver.getPageSource();
*/

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}