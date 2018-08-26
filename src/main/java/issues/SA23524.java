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

public class SA23524 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA23524";
    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2ODIzOTY1OTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.lymE9fDIIlTLsrr-ph6oMlgtpVY7-knj44SIZXc1rMc";
//    private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTUEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4Mzk5MTMxMjEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NDxf8DjL1TrXuFw6RpbLOBxTn0hVVPUCo3xc7xWknEw";
//    private String accessKey = "eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVeU56VXhOamd6T0RFNE1BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NDI4NzY4MzgsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.yhHS7uUs8O9vGPpDuZuXMI2alNX3uffI4nxdt6FvrbM";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, "016fd8f1dd4f22bd");
        dc.setCapability("newSessionWaitTimeout", "20");
        long t0=System.currentTimeMillis();

        try {

            driver = new AndroidDriver<>(new URL("https://qacloud.experitest.com/wd/hub"), dc);
//            driver = new AndroidDriver<>(new URL("http://mastercloud/wd/hub"), dc);
//            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
//            driver = new AndroidDriver<>(new URL("http://eyalneumann.experitest.local:8091/wd/hub"), dc);

        } catch (Exception e) {

            e.printStackTrace();
            long t1=System.currentTimeMillis();
            long dt =t1-t0;
            System.out.println("Time : "+dt);
            throw e;


        }
        driver.setLogLevel(Level.INFO);

    }

    @Test
    public void testSA23524() {
        String pageSource1 = driver.getPageSource();



    }

    @After
    public void tearDown() {
        driver.quit();
    }
}