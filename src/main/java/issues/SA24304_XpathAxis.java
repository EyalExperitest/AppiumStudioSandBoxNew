package main.java.issues;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class SA24304_XpathAxis {

    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2ODIzOTY1OTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.lymE9fDIIlTLsrr-ph6oMlgtpVY7-knj44SIZXc1rMc";
    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Quick Start iOS Browser Demo");
        dc.setCapability("accessKey", accessKey);
        //dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
        dc.setCapability(MobileCapabilityType.UDID, "74ee108a3e08509f1e8056aa1623d6a1a01dcb1f");
        dc.setBrowserName(MobileBrowserType.SAFARI);
        //dc.setCapability(MobileCapabilityType.UDID, "cbc20b1088c65f4a27dca70b158843f69f249a64");
        //driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);

        driver = new IOSDriver<>(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);

    }

    @Test
    public void quickStartiOSBrowserDemo() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.get("https://www.apple.com");
        driver.findElement(By.xpath("//*[@text='Say hello to the future.']/parent::DIV"));
        driver.findElement(By.xpath("//*[@text='Say hello to the future.']/parent::DIV/following-sibling::DIV"));
        driver.findElement(By.xpath("//*[@text='Say hello to the future.']/ancestor::DIV[@class]/DIV/DIV[@class='unit-copy-wrapper']"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}