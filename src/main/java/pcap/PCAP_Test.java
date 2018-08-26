//package main.java.pcap;
//
////package <set your test package>;
//import com.experitest.appium.SeeTestClient;
//import io.appium.java_client.remote.IOSMobileCapabilityType;
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.IOSElement;
//import io.appium.java_client.remote.MobileBrowserType;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.junit.*;
//import java.net.URL;
//import java.net.MalformedURLException;
//import java.util.logging.Level;
//
//public class PCAP_Test {
//    private String reportDirectory = "reports";
//    private String reportFormat = "xml";
//    private String testName = "PCAP Test";
//    private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTUEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4Mzk5MTMxMjEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NDxf8DjL1TrXuFw6RpbLOBxTn0hVVPUCo3xc7xWknEw";
//
//    protected IOSDriver<IOSElement> driver = null;
//
//    DesiredCapabilities dc = new DesiredCapabilities();
//
//    @Before
//    public void setUp() throws MalformedURLException {
//        dc.setCapability("reportDirectory", reportDirectory);
//        dc.setCapability("reportFormat", reportFormat);
//        dc.setCapability("testName", testName);
//        dc.setCapability("accessKey", accessKey);
//
//        //dc.setCapability(MobileCapabilityType.UDID, "f759ec5d8343175b2c68f856c9c47559aa1fc0fc");
//        dc.setCapability(MobileCapabilityType.UDID, "b5e53830a00a854f3c820869a3feb2f38b4fc7d8");
//        dc.setBrowserName(MobileBrowserType.SAFARI);
//
//        //driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
//        driver = new IOSDriver<>(new URL("http://mastercloud:80/wd/hub"), dc);
//
//        driver.setLogLevel(Level.INFO);
//    }
//
//    @Test
//    public void testPCAP_ExtendedClient() {
//        SeeTestClient client = new SeeTestClient(driver);
//        client.startCaptureNetworkDump("C:\\\\PCAP\\\\my001.pcap");
//        driver.get("http://192.168.2.39:8000/Example.html");
//        String pageSource1 = driver.getPageSource();
//        client.stopCaptureNetworkDump();
//    }
//    @Test
//    public void testPCAP_ExecuteScript() {
//        //driver.executeScript("client:client.startLoggingDevice(\"C:\\PCAP\\device.log\");");
//
//        driver.executeScript("client:client.startCaptureNetworkDump(\"C:\\\\PCAP\\\\my002.pcap\");");
//        driver.get("http://192.168.2.39:8000/Example.html");
//        String pageSource1 = driver.getPageSource();
//        driver.executeScript("client:client.stopCaptureNetworkDump();");
//        //driver.executeScript("client:client.stopLoggingDevice();");
//
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//}