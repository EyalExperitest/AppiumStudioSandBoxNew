package main.java.tests.screenshot;

//package <set your test package>;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class ChromeClickTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Electric Sheep Test";
    protected AndroidDriver<AndroidElement> driver = null;
    private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTUEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4Mzk5MTMxMjEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NDxf8DjL1TrXuFw6RpbLOBxTn0hVVPUCo3xc7xWknEw";

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {

        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);

        boolean takeScreenShots = true;
        //**************************************************************

        String takeScreenShotsString = takeScreenShots ? "With ScreenShots" : "Without ScreenShots";
        dc.setCapability("testName", testName+" "+ takeScreenShotsString);
        //dc.setCapability(MobileCapabilityType.UDID, "FA77L0301164");
        dc.setCapability("accessKey", accessKey);

        dc.setCapability(MobileCapabilityType.UDID, "EP73258JAB");

        dc.setCapability("takeScreenshots", takeScreenShots);
        dc.setBrowserName(MobileBrowserType.CHROMIUM);
        //driver = new AndroidDriver<>(new URL("https://mastercloud.experitest.com:443/wd/hub"), dc);

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testElectricSheepTest() {
        driver.get("http://192.168.4.85:8060/html-tests/htmlpages/clickcounter.html");
        Long[] clickTiming = new Long[50];
        long v0,v1;
        long avgClickTiming=0;
        long sumClickTiming=0;
        for (int i=0;i<clickTiming.length;i++) {
            v0 =System.currentTimeMillis();
            driver.findElement(By.id("add-button")).click();
            v1 =System.currentTimeMillis();
            clickTiming[i]=v1-v0;
            sumClickTiming +=clickTiming[i];
            System.out.println(i+":Time:"+clickTiming[i]+"\n");
            System.out.println(i+":Average:"+sumClickTiming/(i+1)+"\n");


        }
        avgClickTiming =sumClickTiming/clickTiming.length;

        System.out.println("Average Click Timing :"+avgClickTiming);



//        File screenshotFile1 = driver.getScreenshotAs(OutputType.FILE);
//        driver.context("WEBVIEW_1");

        driver.executeScript("seetest:client.deviceAction(\"Change Orientation\")");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}