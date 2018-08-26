package main.java.issues.sa22871;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA22871Appium {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA22871 Appium";
    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2NzgwNjY4OTYsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.nG6BiQ2fswkSxWQDnTkIVEDKw0v0f-rYYffcSQdPsGE";

    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        //dc.setCapability("waitForDeviceTimeout", 100000);
        dc.setCapability("newSessionWaitTimeout", 1000);
        dc.setCapability("accessKey", accessKey);

        dc.setCapability(MobileCapabilityType.UDID, "25da8511aef7ea8331fdd0da3ed9ebca19d5da8d 00000000000000000");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\EriBank.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        long t0=System.currentTimeMillis();
        try {
            driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
            //           driver = new IOSDriver<>(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);

        } catch (Exception e) {
            long t1=System.currentTimeMillis();
            long dt=t1-t0;
            System.out.println("Time :"+dt);
            throw e;
        }
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testSA22871Appium() {
        String pageSource1 = driver.getPageSource();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}