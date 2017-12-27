package main.java.grid;

//package <set your test package>;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import static org.testng.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class AndroidGrid2 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AndroidGrid";
    protected AndroidDriver driver = null;
    private static final int ITERATIONS_NUM = 1;
    private int number;
    private String sessionID;
    private String headlessPath = "C:\\Windows\\Temp\\headless";

    public AndroidGrid2(int number) {
        this.number = number;

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        for (int i = 0; i < ITERATIONS_NUM; i++) {
            //Thread.currentThread().setName("main : Iteration : "+i);
/*			if(stop){
                break;
			}*/
            Object[] e = {i};
            data.add(e);
        }
        return data;
    }

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("user", "eyal");
        dc.setCapability("password", "Experitest2012");
        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("projectName", "Default");
        dc.setCapability(MobileCapabilityType.UDID, "4d006b344ea021ed");
        driver = new AndroidDriver(new URL("http://qacloud.experitest.com/wd/hub"), dc);
    }

    @Test
    public void testAndroidGrid() {
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
        sessionID = driver.getSessionId().toString();
        System.out.println(sessionID);/* */
        //sessionID = (String)driver.executeScript("client:client.getSessionID()");

    }

    @After
    public void tearDown() {



        driver.quit();

    }
}