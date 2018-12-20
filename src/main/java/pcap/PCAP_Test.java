package main.java.pcap;

//package <set your test package>;
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class PCAP_Test {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "PCAP Test";
    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2ODIzOTY1OTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.lymE9fDIIlTLsrr-ph6oMlgtpVY7-knj44SIZXc1rMc";

    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);

        //dc.setCapability(MobileCapabilityType.UDID, "f759ec5d8343175b2c68f856c9c47559aa1fc0fc");
        dc.setCapability(MobileCapabilityType.UDID, "f0c8509b4fb35257549154f79b0d62a72f76f02d");
        dc.setBrowserName(MobileBrowserType.SAFARI);

        //driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver = new IOSDriver<>(new URL("https://qacloud.experitest.com/wd/hub"), dc);

        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testPCAP_ExtendedClient() {
        SeeTestClient client = new SeeTestClient(driver);
        System.out.println(client.getVersionWithBuild());
        client.startCaptureNetworkDump("C:\\\\PCAP\\\\my001.pcap");
        driver.get("http://192.168.2.39:8000/Example.html");
        String pageSource1 = driver.getPageSource();
        client.stopCaptureNetworkDump();
        client.collectSupportData("C:\\\\PCAP\\\\SupportData001.zip","","","PCAP","E","A",false,true);
    }
    @Test
    public void testStartLoggingDevice_ExtendedClient() {
        SeeTestClient client = new SeeTestClient(driver);
        System.out.println(client.getVersionWithBuild());
        client.startLoggingDevice("C:\\\\PCAP\\\\DeviceLog4.log");
        //client.startCaptureNetworkDump("C:\\\\PCAP\\\\my001.pcap");
        driver.get("http://192.168.2.39:8000/Example.html");
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
        client.stopLoggingDevice();

        //client.stopCaptureNetworkDump();
        //client.collectSupportData("C:\\\\PCAP\\\\SupportData001.zip","","","PCAP","E","A",false,true);
    }
    @Test
    public void testPCAP_ExecuteScript() {
        //driver.executeScript("client:client.startLoggingDevice(\"C:\\PCAP\\device.log\");");

        driver.executeScript("client:client.startCaptureNetworkDump(\"C:\\\\PCAP\\\\my002.pcap\");");
        driver.get("http://192.168.2.39:8000/Example.html");
        String pageSource1 = driver.getPageSource();
        driver.executeScript("client:client.stopCaptureNetworkDump();");
        //driver.executeScript("client:client.stopLoggingDevice();");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}