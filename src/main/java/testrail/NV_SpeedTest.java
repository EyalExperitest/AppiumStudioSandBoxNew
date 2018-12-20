package main.java.testrail;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class NV_SpeedTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "NV_SpeedTest";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "ENU7N15A28004898");
        dc.setCapability(MobileCapabilityType.APP, "cloud:org.zwanoo.android.speedtest/com.ookla.speedtest.softfacade.MainActivity");
        dc.setCapability("appVersion", "3.2.16");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.zwanoo.android.speedtest");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.ookla.speedtest.softfacade.MainActivity");
        dc.setCapability("instrumentApp", true);
        dc.setCapability("nvProfile", "10M");

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testNV_SpeedTest() {
        driver.context("NATIVE_APP");
        new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Begin Test")));

        driver.findElement(By.linkText("Begin Test")).click();
        new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Test Again")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}