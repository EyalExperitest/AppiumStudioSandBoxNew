package main.java.issues.features;

//package <set your test package>;
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA26564_startCaptureNetworkDump {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA26564_startCaptureNetworkDump";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    private SeeTestClient client;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
//        dc.setCapability(MobileCapabilityType.UDID, "090f1875");
        dc.setCapability(MobileCapabilityType.UDID, "32e0d2a20377e920");

        dc.setBrowserName(MobileBrowserType.CHROMIUM);
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
        client= new SeeTestClient(driver);
        System.out.println(client.getVersionWithBuild());

    }

    @Test
    public void testSA26564_startCaptureNetworkDump() {
        client.startCaptureNetworkDump("C:\\Path\\pcap004.pcap");
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.linkText("English")).click();
        for (int i=0;i<10;i++) {
            driver.findElement(By.id("mw-mf-main-menu-button")).click();
            driver.findElement(By.linkText("Random")).click();
        }
        client.stopCaptureNetworkDump();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}