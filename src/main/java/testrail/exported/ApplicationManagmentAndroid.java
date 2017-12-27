package main.java.testrail.exported;

/**
 * Created by eyal.neumann on 12/21/2017.
 */
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.drivers.ExAndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class ApplicationManagmentAndroid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "ApplicationManagmentAndroid";
    protected ExAndroidDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "CB5A25AM17");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\com.tiennt.android.simcardmgr.MainActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.tiennt.android.simcardmgr");
        driver = new ExAndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testApplicationManagmentAndroid() {
        driver.installApp("com.tiennt.android.simcardmgr/.MainActivity");
        boolean appInstalled = driver.isAppInstalled("com.tiennt.android.simcardmgr");
        System.out.println("appInstalled = "+appInstalled);
        driver.removeApp("com.tiennt.android.simcardmgr");
        appInstalled = driver.isAppInstalled("com.tiennt.android.simcardmgr");
        System.out.println("appInstalled = "+appInstalled);

    }
    @Test
    public void testApplicationManagmentAndroid2() {
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        driver.closeApp();
        pageSource = driver.getPageSource();
        System.out.println(pageSource);
        driver.launchApp();
        pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}