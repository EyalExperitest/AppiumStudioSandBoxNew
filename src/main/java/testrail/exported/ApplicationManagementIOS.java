package main.java.testrail.exported;

/**
 * Created by eyal.neumann on 12/21/2017.
 */
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.drivers.ExIOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class ApplicationManagementIOS {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "ApplicationManagementIOS";
    protected ExIOSDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "8a81b1e32471f53ac99a741bcc14bd6b84991fff");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.UICatalog");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\UICatalog.ipa");

        driver = new ExIOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testApplicationManagementIOS() {
/*        driver.installApp("com.experitest.UICatalog");
        boolean appInstalled = driver.isAppInstalled("com.experitest.UICatalog");
        System.out.println("appInstalled = "+appInstalled);
        driver.removeApp("com.experitest.UICatalog");
        appInstalled = driver.isAppInstalled("com.experitest.UICatalog");
        System.out.println("appInstalled = "+appInstalled);*/

    }
    @Test
    public void testApplicationManagementIOS2() {
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