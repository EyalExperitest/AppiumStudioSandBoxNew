package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;
import com.experitest.appium.SeeTestClient;

public class SA26027GetMonitorData {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA26027GetMonitorData";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "825a2e3c7bffb22a936f1b5c09a5a0612dd597cf");
        //dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\EriBank.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        dc.setCapability("instrumentApp", true);
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testSA26027GetMonitorData() {
//        Object result1 = driver.executeScript("client:client.startMonitor(\"com.experitest.ExperiBank\");");
        SeeTestClient c = new SeeTestClient(driver);
        c.startMonitor("com.experitest.ExperiBank");

        try{Thread.sleep(10000);} catch(Exception ignore){}

        //Object result2 = driver.executeScript("client:client.getMonitorsData(\"c:\\\\path\\\\1234.csv\");");
        c.getMonitorsData("c:\\path\\12345678.csv");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}