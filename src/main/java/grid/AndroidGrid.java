package main.java.grid;

//package <set your test package>;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;

import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;

import static org.testng.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class AndroidGrid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AndroidGrid 005";
    protected AndroidDriver driver = null;
    private static final int ITERATIONS_NUM = 10;
    private int number;
    private String sessionID;
    private String headlessPath = "C:\\Windows\\Temp\\headless";

    public AndroidGrid(int number) {
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
        dc.setCapability("user", "admin");
        dc.setCapability("password", "Experitest2012");
        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "Default");
        dc.setCapability(MobileCapabilityType.UDID, "ce051605686c683b03");
        driver = new AndroidDriver(new URL("http://eyalneumann.experitest.local:8091/wd/hub"), dc);
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
/* */       String reportFolder = sessionID.replace("clientID:Java:version=11.0:", "").replace(":", "_");
        File reporterFile = new File(headlessPath + "\\" + reportFolder);
        System.out.println(reporterFile.getAbsolutePath() + " : " + reporterFile.exists());


        driver.quit();
       String absolutePath = reporterFile.getAbsolutePath();
        System.out.println(absolutePath);
        boolean folderDeleted = !reporterFile.exists();
        assertTrue(folderDeleted, absolutePath + " is not deleted");
        System.out.println("folderDeleted :"+folderDeleted);

    }
}