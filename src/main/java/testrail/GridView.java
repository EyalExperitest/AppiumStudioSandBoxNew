package main.java.testrail;

// Insert your package here
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GridView {

    AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", "reports");
        dc.setCapability("reportFormat", "xml");
        dc.setCapability("testName", "A Very Long Test Name Example 1234567890 ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        dc.setCapability(MobileCapabilityType.UDID, "04157df474344822");
        dc.setCapability("user", "admin");
        // In case your user is assigned to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "");
        dc.setCapability("password", "Experitest2012");
        //dc.setCapability(MobileCapabilityType.APP, <PATH TO APPLICATION> ); // If you wish to continue with the app running on the device, comment this line
        driver = new AndroidDriver(new URL("http://eyalneumann.experitest.local:8091/wd/hub"), dc);
    }

    @Test
    public void testGridView(){
        //Enter your test code here
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        pageSource = driver.getPageSource();
        System.out.println(pageSource);
        pageSource = driver.getPageSource();
        System.out.println(pageSource);
        pageSource = driver.getPageSource();
        System.out.println(pageSource);
        pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}