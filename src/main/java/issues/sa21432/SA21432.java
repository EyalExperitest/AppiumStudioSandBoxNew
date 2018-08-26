package main.java.issues.sa21432;

/**
 * Created by eyal.neumann on 1/29/2018.
 */
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA21432 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA21432";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "ENU7N15A28004898");
        dc.setBrowserName(MobileBrowserType.CHROMIUM);
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        //driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testSA21432A() {
        driver.get("https://output.jsbin.com/disoruq/quiet");
        String pageSource1 = driver.getPageSource();
        WebElement webElement =   driver.findElement(By.xpath("//*[@nodeName='MY-ELEMENT']"));
        AndroidElement element = driver.findElement(By.xpath("//*[@text='Hello from inside the Shadow DOM!']"));
        element.click();
        String width = element.getAttribute("width");
        System.out.println(width);
    }
    @Test
    public void testSA21432B() {
        driver.get("https://output.jsbin.com/nalaros");
        driver.context("WEBVIEW_1");
        AndroidElement element = driver.findElement(By.xpath("//*[@text='Click me!']"));
        element.click();
        String width = element.getAttribute("width");
        System.out.println(width);


    }

    @After
    public void tearDown() {
        driver.quit();
    }
}