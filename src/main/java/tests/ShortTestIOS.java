package main.java.tests;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class ShortTestIOS {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "ShortTest";
    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2NzIxMzI4NTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.na315fDIXdpqkRVem7V1vbiHnST4I7Ee3vYMIpBb11A";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, "7dab622e4213cc503ccca3fa4a213645d7f9e5da");
        dc.setCapability("waitForDeviceTimeout", 100000);
        //dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 9);

        long t0=System.currentTimeMillis();
        try {
            driver = new IOSDriver<>(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
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

        for (int time=55000;time<100000;time+=1000) {
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