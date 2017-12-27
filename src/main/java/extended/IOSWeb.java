package main.java.extended;

//package <set your test package>;
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class IOSWeb {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "IOSWeb";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "7dab622e4213cc503ccca3fa4a213645d7f9e5da");
        dc.setBrowserName(MobileBrowserType.SAFARI);
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testIOSWebClickCounter() {
        SeeTestClient client = new SeeTestClient(driver);
        driver.get("http://192.168.4.85:8060/html-tests/WebPageTests/WebPageTests.html");
        String pageSource1 = driver.getPageSource();
        driver.context("WEBVIEW_1");
        driver.findElement(By.xpath("//*[@text='Click Counter']")).click();
        int clickCount = 10;
        client.setProperty("clicks.time.gap","1000");
        client.click("WEB","//*[@id='add_button']",0, clickCount);
        String counter = client.elementGetProperty("WEB", "//*[@id='counter']", 0, "text");
        System.out.println(counter);
        counter = client.elementGetProperty("WEB", "//*[@id='counter']", 0, "text");
        System.out.println(counter);
        counter = client.elementGetProperty("WEB", "//*[@id='counter']", 0, "text");
        System.out.println(counter);
        counter = client.elementGetProperty("WEB", "//*[@id='counter']", 0, "text");
        System.out.println(counter);
        assertEquals(counter,clickCount);

    }
    @Test
    public void testIOSWebSelectList() {
        SeeTestClient client = new SeeTestClient(driver);
        driver.get("http://192.168.4.85:8060/html-tests/WebPageTests/WebPageTests.html");




    }
    @After
    public void tearDown() {
        driver.quit();
    }
}