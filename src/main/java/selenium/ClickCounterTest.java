package main.java.selenium;

// Insert your package here
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import static org.junit.Assert.assertEquals;

public class ClickCounterTest {

    AppiumDriver driver;
    private String baseUrl;
    public static final int CLICKS = 30;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", "reports");
        dc.setCapability("reportFormat", "xml");
        dc.setCapability("testName", "ClickCounterTest");
        dc.setCapability(MobileCapabilityType.UDID, "632904b9fa80589a2d3edd5993ec6d30accf0701");
        dc.setCapability("user", "admin");
        // In case your user is assigned to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "");
        dc.setCapability("password", "Experitest2012");
        baseUrl = "http://192.168.4.85:8060/";
        //dc.setCapability(MobileCapabilityType.APP, <PATH TO APPLICATION> ); // If you wish to continue with the app running on the device, comment this line
        driver = new IOSDriver(new URL("http://eyalneumann.experitest.local:8091/wd/hub"), dc);
    }

    @Test
    public void testClickCounterTest(){
        //Enter your test code here
        driver.get(baseUrl + "/html-tests/htmlpages/clickcounter.html");
        WebElement counter = driver.findElement(By.id("counter"));
        WebElement addButton = driver.findElement(By.id("add-button"));

        // ERROR: Caught exception [unknown command []]
        long t0 = System.currentTimeMillis();
        for(int i = 0; i< CLICKS; i++){
            String counterTest = counter.getText();
            assertEquals(i+"",counterTest);
            System.out.println(counterTest);
            //takeScreenShot("C:\\Users\\eyal.neumann\\workspace\\WebUITest\\screenshots\\ScreenshotB" + i + ".png");
            addButton.click();
            //takeScreenShot("C:\\Users\\eyal.neumann\\workspace\\WebUITest\\screenshots\\ScreenshotA" + i + ".png");
        }
        long t1 = System.currentTimeMillis();
        long dt =t1-t0;
        System.out.println("Time : "+dt);

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}