package main.java.tests;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class ShortTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "ShortTest";
    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2NzIxMzI4NTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.na315fDIXdpqkRVem7V1vbiHnST4I7Ee3vYMIpBb11A";
    protected AndroidDriver<AndroidElement> driver = null;


    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        //dc.setCapability(MobileCapabilityType.UDID, "CB5A2BSDEE");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\apk\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        dc.setCapability("waitForDeviceTimeout", 1000);
        //dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 11);


        long t0=System.currentTimeMillis();
        try {
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        } catch (Exception e) {
            long t1=System.currentTimeMillis();
            long dt=t1-t0;
            System.out.println("Time :"+dt);
            throw e;

        }


        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testShortTest() throws InterruptedException {
        String pageSource1 = driver.getPageSource();
        driver.context("NATIVE_APP");
        for (int time=50000;time<100000;time+=10000) {
            System.out.println("Time to try :"+time+" mS");
            Thread.sleep(time);
            pageSource1 = driver.getPageSource();
            System.out.println(time+" mS Passed");



        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}