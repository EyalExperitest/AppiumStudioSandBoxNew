package main.java.manager;

//package <set your test package>;
import com.experitest.appium.SeeTestClient;
import com.experitest.reporter.junit5.SeeTestReporterExceptionExtension;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.jupiter.api.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

@ExtendWith(SeeTestReporterExceptionExtension.class)
public class SA26036_JUnit5_Android {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Test JUnit5 Appium Driver Reporter Runner";
    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2ODIzOTY1OTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.lymE9fDIIlTLsrr-ph6oMlgtpVY7-knj44SIZXc1rMc";

    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeEach
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        //dc.setCapability(MobileCapabilityType.UDID, "91df46f3");
        dc.setCapability("accessKey", accessKey);
        driver = new AndroidDriver<>(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testUntitled() throws Exception {
        SeeTestClient client = new SeeTestClient(driver);
        String versionWithBuild = client.getVersionWithBuild();
        System.out.println(versionWithBuild);
        client.sleep(1000);
        Exception a_random_exception_ = new Exception("A Random Exception ");

//        client.setReportStatus("Failed","A Random Exception", String.valueOf(a_random_exception_.getStackTrace()));

        client.getVisualDump("Native");
        throw a_random_exception_;

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}