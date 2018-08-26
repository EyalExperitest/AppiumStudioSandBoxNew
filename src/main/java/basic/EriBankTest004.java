package main.java.basic;

/**
 * Created by eyal.neumann on 1/16/2018.
 */
//package <set your test package>;
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class EriBankTest004 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "EriBankTest004";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "b386670b67fa917c2a65a9f2d70470347457678b");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        dc.setCapability("instrumentApp", true);
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testEriBankTest004() {
        //driver.context("NATIVE_APP");
        System.out.println("Page source 1:");
        System.out.println(driver.getPageSource());

        driver.findElement(By.linkText("Username")).sendKeys("company");
        driver.findElement(By.linkText("Password")).sendKeys("company");
        //driver.findElement(By.linkText("Login")).click();
        try {
            driver.findElement(By.xpath("//*[@text='Login']")).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Page source 2:");
            System.out.println(driver.getPageSource());
        }


    }


    @Test
    public void testEriBankTest004B() {
        //driver.context("NATIVE_APP");
        driver.findElement(By.xpath("//*[@accessibilityLabel='Password']")).sendKeys("company");
        driver.findElement(By.linkText("Login")).click();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}