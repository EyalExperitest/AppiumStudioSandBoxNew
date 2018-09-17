package main.java.tests.screenshot;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class IOSSafariClickTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "IOSSafariClickTest";
    private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTUEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4Mzk5MTMxMjEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NDxf8DjL1TrXuFw6RpbLOBxTn0hVVPUCo3xc7xWknEw";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {

        boolean takeScreenShots = false;
        //***********************************************************************




        String takeScreenShotsString = takeScreenShots ? "With ScreenShots" : "Without ScreenShots";
        dc.setCapability("testName", testName+" "+ takeScreenShotsString);
        dc.setCapability("takeScreenshots", takeScreenShots);

        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, "1c18924584f05c3594d431229a7ceb2c5897b769");
        dc.setBrowserName(MobileBrowserType.SAFARI);
        driver = new IOSDriver<>(new URL("https://mastercloud.experitest.com:443/wd/hub"), dc);
        //driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);

        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testIOSSafariClickTest() {
        driver.get("http://192.168.4.85:8060/html-tests/htmlpages/clickcounter.html");
        driver.context("WEBVIEW_1");


        Long[] clickTiming = new Long[30];
        long v0,v1;
        long avgClickTiming=0;
        long sumClickTiming=0;
        for (int i=0;i<clickTiming.length;i++) {
            v0 =System.currentTimeMillis();

            driver.findElement(By.id("add-button")).click();

            v1 =System.currentTimeMillis();
            clickTiming[i]=v1-v0;
            sumClickTiming+=clickTiming[i];
            System.out.println(i+":"+clickTiming[i]+"\n");

        }

        avgClickTiming =sumClickTiming/clickTiming.length;

        System.out.println("Average Click Timing :"+avgClickTiming);
        for (int i=0;i<clickTiming.length;i++) {
            System.out.println(clickTiming[i]);
        }






    }

    @After
    public void tearDown() {
        driver.quit();
    }
}