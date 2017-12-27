package main.java.exceptiontests.initiation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.tools.URLReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SessionBussyAndroid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "NoAppInstalled";
    //protected AndroidDriver driver = null;
    protected IOSDriver driver = null;


    @Before
    public void setUp() throws IOException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "2ef16f1e7b475b9e6aa09392efb67735b1b57b08");
        String appiumStudioURLString ="http://localhost:4723/wd/hub";
        String urlString = appiumStudioURLString+"/sessions";
        String getStringFromURL = URLReader.getStringFromURL(urlString);
        System.out.println(getStringFromURL);
        //driver = new AndroidDriver(new URL(appiumStudioURLString), dc);
        driver = new IOSDriver(new URL(appiumStudioURLString), dc);
/*        Thread.sleep(120000);
        getStringFromURL = URLReader.getStringFromURL(urlString);
        System.out.println(getStringFromURL);
        driver = new AndroidDriver(new URL(appiumStudioURLString), dc);*/


    }

    @Test
    public void testNoAppInstalled() throws InterruptedException {
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
        Thread.sleep(10000);

    }

    @After
    public void tearDown() {

       // driver.quit();
    }
}