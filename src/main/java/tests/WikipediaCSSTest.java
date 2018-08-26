package main.java.tests;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

public class WikipediaCSSTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Wikipedia CSS Test";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2NzIxMzI4NTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.na315fDIXdpqkRVem7V1vbiHnST4I7Ee3vYMIpBb11A";

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "N2K7N16811000417");
        //dc.setCapability(MobileCapabilityType.UDID, "668bbfe5");
        dc.setCapability("accessKey", accessKey);

        //dc.setBrowserName(MobileBrowserType.CHROMIUM);
        dc.setBrowserName("chrome");
        //driver = new AndroidDriver<>(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        //driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testWikipedia_SCCTest() {
        driver.get("https://www.wikipedia.org");
        driver.context("WEBVIEW_1");
        //driver.findElement(By.xpath("//*[@text='English' and @nodeName='STRONG']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@nodeName='STRONG' and @text='English']")));
        driver.findElement(By.xpath("//*[@nodeName='STRONG' and @text='English']")).click();
        List<AndroidElement> elements = driver.findElements(By.xpath("//*[@css]"));
        System.out.println("Elements Found :"+elements.size());
        for(AndroidElement element:elements){
            System.out.println("Text:"+element.getText());
            //System.out.println("Text css:"+element.getCssValue("text"));
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}