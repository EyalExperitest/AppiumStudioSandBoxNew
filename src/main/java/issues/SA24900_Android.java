package main.java.issues;

//package <set your test package>;
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.OutputType;
import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA24900_Android {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA24900_Android";
    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2ODIzOTY1OTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.lymE9fDIIlTLsrr-ph6oMlgtpVY7-knj44SIZXc1rMc";
    protected AndroidDriver<AndroidElement> driver = null;
    protected  SeeTestClient client;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        //dc.setCapability(MobileCapabilityType.UDID, "ZX1C229MVT");
//        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\apk\\com.experitest.ExperiBank.LoginActivity.2.apk");
//        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
//        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver<>(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testSA24900_Android() {
        File screenshotFile1 = driver.getScreenshotAs(OutputType.FILE);
        System.out.println("File : "+screenshotFile1.getAbsolutePath());
        client= new SeeTestClient(driver);
        String capture_line = client.capture("C:\\Path\\capture3.png", "Capture Line");
        System.out.println("Capture Line :"+capture_line);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}