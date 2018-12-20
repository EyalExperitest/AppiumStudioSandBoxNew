package main.java.issues;

//package <set your test package>;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA24827_SwitchToFrame {

    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA 24391 Switch To Frame";
    protected IOSDriver<IOSElement> driver = null;
//        protected AndroidDriver<AndroidElement> driver = null;

    final static String deviceID="36f0a41a8fca9263c1f977b915dcb5668a0b83fc";
//        final static String deviceID="220990352c057ece";

    final static String authority="http";
    final static String host="localhost";
    final static int port = 4723;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", "eyJ4cC51Ijo1Mjg0MjEsInhwLnAiOjIsInhwLm0iOiJNVFV5TlRZNU9UZ3dOVFkzT0EiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjQ2NzkyOTk4MDYsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.6-qt8k_tX7ulVXwcFJggJkUpKQmZzUiaW72fH7w2Pc4");

        dc.setCapability(MobileCapabilityType.UDID, deviceID);
//            dc.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
        driver = new IOSDriver<>(new URL(authority+"://"+host+":"+port+"/wd/hub"), dc);
//            driver = new AndroidDriver<>(new URL(authority+"://"+host+":"+port+"/wd/hub"), dc);
        //driver.setLogLevel(Level.INFO);
    }

    @Test
    public void test_SA24391() {
        driver.get("http://192.168.4.85:8060/html-tests/RegressionHibridApplication/iFramePage.html");
        sleep(5000);
        // Html page source
        System.out.println("******************* Page Source Default Frame :***************");
        System.out.println(driver.getPageSource());
        driver.switchTo().frame(1);
        // same domain frame source
        System.out.println("******************* Page Source From Frame 1 :***************");
        System.out.println(driver.getPageSource());
        // only same domain frame source should change background color to red
        System.out.println("******************* Execute Script  :***************");
        driver.executeScript("document.body.style.backgroundColor = \"red\"");
        driver.switchTo().defaultContent();
        System.out.println("******************* Page Source Default Frame :***************");
        // Html page source
        System.out.println(driver.getPageSource());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void sleep(int ...millis){
        final int defaultMillis=4000;
        try {
            Thread.sleep(millis.length>0?millis[0]:defaultMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}