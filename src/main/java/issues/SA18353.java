package main.java.issues;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class SA18353 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA18353";
    protected IOSDriver driver = null;
    protected DesiredCapabilities dc = new DesiredCapabilities();
    @Before
    public void setUp() throws MalformedURLException {

        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "e323acec7ba4322be383a7c431d8a7d8739b581b");

    }

    @Test
    public void testSA18353_1() throws MalformedURLException {
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        dc.setCapability("instrumentApp", true);

        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
        driver.findElement(By.className("UIScrollView"));
        String attribute1 = driver.findElement(By.className("UIScrollView")).getAttribute("type");
        System.out.println("Type : ["+attribute1+"]");
    }
    @Test
    public void testSA18353_2() throws Exception {
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBankO");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), dc);

        WebElement login = driver.findElement(By.xpath("//*[@text='loginButton']"));
        //WebElement login = driver.findElement(By.xpath("//*[@text='Login']"));
        String type = login.getAttribute("type");
        System.out.println(type);
        assertEquals("XCUIElementTypeButton", type);

        String attribute = driver.findElement(By.className("UIAScrollView")).getAttribute("Type");
        System.out.println(attribute);
        assertTrue("Didn't return XCUIElementTypeScrollView ", "XCUIElementTypeScrollView".equals(attribute));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}