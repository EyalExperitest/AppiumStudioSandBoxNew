package main.java.multitouch;

//package <set your test package>;
import io.appium.java_client.TouchAction;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.OutputType;
import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.junit.*;

import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import main.java.tools.CopyFilesNew;

public class MultiTouch {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "MultiTouch";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "cbc20b1088c65f4a27dca70b158843f69f249a64");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.ferretking.testtouch");
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testMultiTouch() throws IOException, InterruptedException {
        Thread.sleep(5000);
        File screenshotFile1 = driver.getScreenshotAs(OutputType.FILE);
        String absolutePath = screenshotFile1.getAbsolutePath();
        System.out.println(absolutePath);
        //CopyFilesNew.copy(absolutePath,"C:\\Users\\eyal.neumann\\workspace\\AppiumStudioSandBoxNew\\screenshoots\\MultiTouch0.png");
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);

        TouchAction touchAction1 =new TouchAction(driver);
        touchAction1.press(200,200);
        //touchAction1.waitAction(5000);
        touchAction1.moveTo(400,400);
        //touchAction1.waitAction(5000);
        touchAction1.release();
        touchAction1.perform();

       TouchAction touchAction2 =new TouchAction(driver);
        touchAction2.moveTo(400,400);
        //touchAction2.waitAction(5000);
        touchAction2.release();
        touchAction2.perform();
/*

        MultiTouchAction multiTouchAction =new MultiTouchAction(driver);
        multiTouchAction.add(touchAction1);
        multiTouchAction.add(touchAction2);
        multiTouchAction.perform();*/






    }

    @After
    public void tearDown() {
        driver.quit();
    }
}