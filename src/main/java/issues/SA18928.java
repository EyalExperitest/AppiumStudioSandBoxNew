package main.java.issues;

// Insert your package here
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

//import static org.jboss.netty.handler.codec.spdy.SpdyHeaders.HttpNames.PATH;

public class SA18928 {

    AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", "reports");
        dc.setCapability("reportFormat", "xml");
        dc.setCapability("testName", "SA18928");
        dc.setCapability(MobileCapabilityType.UDID, "74ee108a3e08509f1e8056aa1623d6a1a01dcb1fa");
        dc.setCapability("newSessionWaitTimeout", 120);
        dc.setCapability("user", "eyal");
        // In case your user is assigned to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "");
        dc.setCapability("password","Experitest2012");
        //dc.setCapability(MobileCapabilityType.APP, <PATH TO APPLICATION> ); // If you wish to continue with the app running on the device, comment this line
        long currentTimeMillis0 = System.currentTimeMillis();
        try{
            driver = new IOSDriver(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
        }catch(Exception e){
            long currentTimeMillis1 = System.currentTimeMillis();
            long dt=currentTimeMillis1-currentTimeMillis0;
            System.out.println("Time: "+dt);
            throw e;

        }

    }

    @Test
    public void testSA18928(){
        //Enter your test code here
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}