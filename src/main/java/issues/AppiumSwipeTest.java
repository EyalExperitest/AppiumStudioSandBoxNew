package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.OutputType;
import java.io.File;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.net.MalformedURLException;

public class AppiumSwipeTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AppiumSwipeTest";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "e323acec7ba4322be383a7c431d8a7d8739b581b");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\EriBank.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        dc.setCapability("instrumentApp", true);
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testAppiumSwipeTest() {
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Password']")));
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@accessibilityLabel='loginButton']")).click();
        driver.findElement(By.xpath("//*[@accessibilityLabel='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Phone']")).sendKeys("789");
        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("hadar");
        driver.findElement(By.xpath("//*[@placeholder='Amount']")).sendKeys("5");
        driver.findElement(By.xpath("//*[@accessibilityLabel='countryButton']")).click();
        //driver.swipe(272, 907, 272, 600, 50);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@accessibilityLabel='Brazil']")));
        driver.findElement(By.xpath("//*[@accessibilityLabel='Brazil']")).click();
        driver.findElement(By.xpath("//*[@accessibilityLabel='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='Yes']")).click();
        driver.findElement(By.xpath("//*[@accessibilityLabel='logoutButton']")).click();
        driver.executeScript("client:client.deviceAction(\"Home\")");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}