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

public class SA24900_IOS {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA24900 IOS Capture Test";
    protected IOSDriver<IOSElement> driver = null;
    protected  SeeTestClient client;
    private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTUEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4Mzk5MTMxMjEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NDxf8DjL1TrXuFw6RpbLOBxTn0hVVPUCo3xc7xWknEw";
    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);

//        dc.setCapability(MobileCapabilityType.UDID, "f0c8509b4fb35257549154f79b0d62a72f76f02d");
//        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\fileFromUrl2585983432580620014UICatalog.ipa");
//        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.UICatalog");
//        dc.setCapability("instrumentApp", true);
//        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
//        driver = new IOSDriver<>(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
        driver = new IOSDriver<>(new URL("https://mastercloud.experitest.com/wd/hub"), dc);

        driver.setLogLevel(Level.INFO);

    }

    @Test
    public void testSA24900_IOS() {
        client= new SeeTestClient(driver);
        String pageSource1 = driver.getPageSource();
        //client.capture();
        String aNative = client.getVisualDump("Native");
        System.out.println(aNative);
        String versionWithBuild = client.getVersionWithBuild();
        System.out.println("Version:"+versionWithBuild);
        String capture_line = client.capture("C:\\Path\\capture2.png", "Capture Line");
        System.out.println("Capture Line :"+capture_line);


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}