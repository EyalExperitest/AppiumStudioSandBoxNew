package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA24007 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA24007";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "32049b2612d2b1b9");
        //driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver = new AndroidDriver<>(new URL("http://192.168.2.81:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testSA24007() {
        String pageSource1 = driver.getPageSource();
        String pageSource2 = driver.getPageSource();
        String pageSource3 = driver.getPageSource();
        String pageSource4 = driver.getPageSource();
        String pageSource5 = driver.getPageSource();
        String pageSource6 = driver.getPageSource();
        String pageSource7 = driver.getPageSource();
        String pageSource8 = driver.getPageSource();
        for (int i=0;i<1000;i++) {
            System.out.println(i);
            String pageSource9 = driver.getPageSource();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}