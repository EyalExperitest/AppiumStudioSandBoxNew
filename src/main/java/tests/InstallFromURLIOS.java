package main.java.tests;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.drivers.ExIOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class InstallFromURLIOS {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Install From URL to IOS";
    protected ExIOSDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "b5e53830a00a854f3c820869a3feb2f38b4fc7d8");
        dc.setCapability(MobileCapabilityType.APP, "http://192.168.2.72:8181/iOSApps/EriBank.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        //driver = new ExIOSDriver(new URL("http://192.168.2.40:4723/wd/hub"), dc);
        driver = new ExIOSDriver(new URL("http://192.168.2.40:4723/wd/hub"), dc);
    }

    @Test
    public void testInstallFromURLIOS() {
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}