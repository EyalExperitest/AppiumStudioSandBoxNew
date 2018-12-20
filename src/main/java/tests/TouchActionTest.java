package main.java.tests;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.TouchAction;
import java.time.Duration;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.OutputType;
import java.io.File;

import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;


public class TouchActionTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "TouchActionTest";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "14bdd0fd9904");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 4");
        //dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\apk\\com.experitest.uicatalog.MainActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.uicatalog");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testTouchActionTestSwipe() {
        driver.context("NATIVE_APP");
//        driver.findElement(By.linkText("Dragging Elements")).click();
        driver.findElement(By.xpath("//*[@text='Dragging Elements']")).click();
//        AndroidElement myimage1 = driver.findElement(By.id("myimage1"));
        try {Thread.sleep(10000); } catch (InterruptedException e) {e.printStackTrace(); }
        String pageSource = driver.getPageSource();
        System.out.println("************************************************");
        System.out.println(pageSource);
        System.out.println("************************************************");

        // AndroidElement myimage1 = driver.findElement(By.xpath("//*[@id='myimage1']"));// For APSE
              AndroidElement myimage1 = driver.findElement(By.xpath("//*[@resource-id='com.experitest.uicatalog:id/myimage1']")); // For Appium Server
        // AndroidElement bottomright = driver.findElement(By.id("bottomright"));// For APSE
       AndroidElement bottomright = driver.findElement(By.xpath("//*[@resource-id='com.experitest.uicatalog:id/bottomright']")); // For Appium Server
        //     new TouchAction(driver).press(myimage1).waitAction(Duration.ofMillis(2000)).moveTo(bottomright).release().perform();

        new TouchAction(driver).press((RemoteWebElement)myimage1).waitAction(Duration.ofMillis(2000)).moveTo((RemoteWebElement)bottomright).release().perform();
        //new TouchAction(driver).press(100, 150).waitAction(Duration.ofMillis(2000)).moveTo(1200, 1200).release().perform();

        File screenshotFile1 = driver.getScreenshotAs(OutputType.FILE);

    }

    @Test

    public void testTouchActionTestTap() {
        driver.findElement(By.xpath("//*[@text='Buttons']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Long Click Button")));

        AndroidElement long_click_button = driver.findElement(By.linkText("Long Click Button"));
        Point location = long_click_button.getLocation();
        System.out.println("X:"+location.x+" Y:"+location.y);

        new TouchAction(driver).press(location.x, location.y).waitAction(Duration.ofMillis(5000)).release().perform();
        //driver.findElement(By.xpath("//*[@resource-id='com.experitest.uicatalog:id/textView' and @text='Long Button Click']"));
        File screenshotFile1 = driver.getScreenshotAs(OutputType.FILE);
        new TouchAction(driver).tap(location.x, location.y).perform();
        //driver.findElement(By.xpath("//*[@resource-id='com.experitest.uicatalog:id/textView' and @text='button Pressed']"));
        File screenshotFile2 = driver.getScreenshotAs(OutputType.FILE);


    }
    @Test
    public void testTouchActionTestPinch() {
        driver.context("NATIVE_APP");
        driver.findElement(By.xpath("//*[@text='Dragging Elements']")).click();
//        AndroidElement pinchElement = driver.findElement(By.xpath("//*[@id='txtForPinch']"));
        AndroidElement pinchElement = driver.findElement(By.xpath("//*[@resource-id='com.experitest.uicatalog:id/txtForPinch']"));
        Point pinchLocation = pinchElement.getLocation();
        File screenshotFile1 = driver.getScreenshotAs(OutputType.FILE);

        System.out.println(pinchLocation);
        int x0 = pinchLocation.getX();
        int x1 = x0+50;
        int y = pinchLocation.getY();
        TouchAction touchAction0 = new TouchAction((MobileDriver)driver).press(x0, y).waitAction(Duration.ofMillis(2000)).moveTo(x0 - 400, y+100).release();
        TouchAction touchAction1 = new TouchAction((MobileDriver)driver).press(x1, y).waitAction(Duration.ofMillis(2000)).moveTo(x0 + 400, y-100).release();

        MultiTouchAction multiTouchAction = new MultiTouchAction((MobileDriver)driver);
        multiTouchAction.add(touchAction0).add(touchAction1).perform();
        File screenshotFile2 = driver.getScreenshotAs(OutputType.FILE);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}