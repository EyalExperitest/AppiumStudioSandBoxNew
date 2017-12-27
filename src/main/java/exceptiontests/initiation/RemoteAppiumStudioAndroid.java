package main.java.exceptiontests.initiation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.tools.URLReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class RemoteAppiumStudioAndroid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "NoAppInstalled";
    protected AndroidDriver driver = null;


    @Before
    public void setUp() throws IOException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "d0595c1001b9d9d4");
        String appiumStudioURLString ="http://192.168.2.11:4723/wd/hub";
        String urlString = appiumStudioURLString+"/sessions";
        String getStringFromURL = URLReader.getStringFromURL(urlString);
        System.out.println(getStringFromURL);
        driver = new AndroidDriver(new URL(appiumStudioURLString), dc);
/*        Thread.sleep(120000);
        getStringFromURL = URLReader.getStringFromURL(urlString);
        System.out.println(getStringFromURL);
        driver = new AndroidDriver(new URL(appiumStudioURLString), dc);*/


    }

    @Test
    public void testNoAppInstalled() throws InterruptedException {
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}