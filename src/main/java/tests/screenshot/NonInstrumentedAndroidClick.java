package main.java.tests.screenshot;
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

public class NonInstrumentedAndroidClick {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "NonInstrumentedAndroidClick";

    private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTUEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4Mzk5MTMxMjEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NDxf8DjL1TrXuFw6RpbLOBxTn0hVVPUCo3xc7xWknEw";



    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        boolean takeScreenShots = false;
        String takeScreenShotsString = takeScreenShots ? "With ScreenShots" : "Without ScreenShots";
        dc.setCapability("testName", testName+" "+ takeScreenShotsString);
        dc.setCapability("takeScreenshots", takeScreenShots);

        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
//        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "EP73258JAB");

//        dc.setCapability(MobileCapabilityType.UDID, "32e0d2a20377e920");

//        dc.setCapability(MobileCapabilityType.UDID, "FA77L0301164");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.uicatalog");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        dc.setCapability("instrumentApp", false);
        driver = new AndroidDriver<>(new URL("https://mastercloud.experitest.com:443/wd/hub"), dc);

        //driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testNonInstrumentedAndroidClick() {
        driver.context("NATIVE_APP");
        driver.findElement(By.xpath("//*[@text='Buttons']")).click();



        Long[] clickTiming = new Long[100];
        long v0,v1;
        long avgClickTiming=0;
        long sumClickTiming=0;
        for (int i=0;i<clickTiming.length;i++) {
            System.out.println(i);
            v0 =System.currentTimeMillis();
            driver.findElement(By.xpath("//*[@id='button']")).click();
            v1 =System.currentTimeMillis();
            clickTiming[i]=v1-v0;
            sumClickTiming+=clickTiming[i];
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