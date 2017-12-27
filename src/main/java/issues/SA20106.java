package main.java.issues;

// Insert your package here
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SA20106 {

    AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", "reports");
        dc.setCapability("reportFormat", "xml");
        dc.setCapability("testName", "Untitled");
        dc.setCapability(MobileCapabilityType.UDID, "17b3dcc17d43");
        dc.setCapability("user", "eyal");
        // In case your user is assigned to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "");
        dc.setCapability("password", "Experitest2012");
        //dc.setCapability(MobileCapabilityType.APP, <PATH TO APPLICATION> ); // If you wish to continue with the app running on the device, comment this line
        driver = new AndroidDriver(new URL("http://192.168.2.114:80/wd/hub"), dc);
    }

    @Test
    public void testSA20106(){
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        pageSource = driver.getPageSource();
        System.out.println(pageSource);
        pageSource = driver.getPageSource();
        System.out.println(pageSource);
        pageSource = driver.getPageSource();
        System.out.println(pageSource);
        pageSource = driver.getPageSource();
        System.out.println(pageSource);    }

    @After
    public void tearDown(){
        driver.quit();
    }

}