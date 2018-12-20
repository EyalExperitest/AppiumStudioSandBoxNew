package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA26228_WebElementFindElement {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA26228_WebElementFindElement";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "14bdd0fd9904");
        dc.setBrowserName(MobileBrowserType.CHROMIUM);
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testSA26228_WebElementFindElement() {
        driver.get("https://www.google.com");
        driver.context("WEBVIEW_1");
        WebElement html = driver.findElement(By.xpath("//*[@nodeName='HTML']"));
        WebElement divn0tgWb = html.findElement(By.xpath("//*[@nodeName='DIV' and @id='n0tgWb']"));
        WebElement q = divn0tgWb.findElement(By.xpath("//*[@name='q']"));



        ////*[@name='q']

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}