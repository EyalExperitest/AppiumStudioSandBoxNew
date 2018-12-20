package main.java.issues;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.experitest.appium.SeeTestClient;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class SA26228_WebElementFindElement_Android {

    AppiumDriver driver;
    SeeTestClient client;
    public String os = "Android";

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", "reports");
        dc.setCapability("reportFormat", "xml");
        dc.setCapability("testName", "SA26228");
 /*       dc.setCapability(MobileCapabilityType.UDID, "ce09171919cb28a00c7e");
        dc.setCapability("accessKey","eyJ4cC51IjoxMDkwMDYsInhwLnAiOjIsInhwLm0iOiJNVFV6T1RJME1qVXhNelV3TkEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4NTQ2MDI1MTMsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.p_lUpL9jmNKHDanpbnnrqr2430f44F11m0iZj5m15FQ");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.amfam.myamfam");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ActivityMain");
        driver = new AndroidDriver(new URL("https://uscloud.experitest.com:443/wd/hub"), dc);*/
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi Note 4");
        dc.setCapability(MobileCapabilityType.UDID, "14bdd0fd9904");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\com.amfam.myamfam.ActivityMain.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.amfam.myamfam");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ActivityMain");
        dc.setCapability(MobileCapabilityType.NO_RESET, true);

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);


    }

    @Test
    public void testSA26228() throws InterruptedException {


        Thread.sleep(5000);
        //System.out.println(driver.getPageSource());
          driver.findElement(By.xpath("//*[@id='tv_more_tools']")).click();
        //driver.findElement(By.xpath("//*[@resource-id='com.amfam.myamfam:id/tv_more_tools']")).click();
        //System.out.println(driver.getPageSource());
        //verifyOptions("//*[@resource-id='com.amfam.myamfam:id/dashboardMainMenu']/child::*/child::*",5);
          verifyOptions("//*[@id='dashboardMainMenu']/child::*/child::*",5);
//        verifyOptions2("//*[@id='dashboardMainMenu']/child::*/child::*",5);



    }

    public void verifyOptions (String xpath, int numOfpages) {

        List<WebElement> pages = driver.findElements(By.xpath(xpath));
        int size = pages.size();
        System.out.println("Size:"+size);
        if (size != 0) {
            String [] option = new String[size];
            String options = "";
            int i = 0;
            for (WebElement e : pages) {
                if(!os.equals("IOS"))
                    option[i] = e.findElement(By.xpath("descendant::android.widget.TextView")).getText().trim();
                else {
                    try{
                        option[i] = e.findElement(By.xpath("descendant::UIAStaticText[1]")).getText().trim();
                        if(option[i].equals(""))
                            option[i] = e.findElement(By.xpath("descendant::UIAStaticText[2]")).getText().trim();
                    } catch (NoSuchElementException d) {
                        option[i] = "";
                    }
                }
                if (i != size - 1) {
                    options += option[i++] + ", ";
                } else {
                    options += option[i];
                }
            }
            if (size == numOfpages) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        } else {
            System.out.println("TOTAL FAILURE");
        }
    }
    public void verifyOptions2 (String xpath, int numOfpages) {

        List<WebElement> pages = driver.findElements(By.xpath(xpath));
        int size = pages.size();
        if (size != 0) {
            String [] option = new String[size];
            String options = "";
            int i = 0;
            for (WebElement e : pages) {
                if(!os.equals("IOS"))
                    option[i] = driver.findElement(By.xpath("descendant::android.widget.TextView")).getText().trim();
                else {
                    try{
                        option[i] = driver.findElement(By.xpath("descendant::UIAStaticText[1]")).getText().trim();
                        if(option[i].equals(""))
                            option[i] = driver.findElement(By.xpath("descendant::UIAStaticText[2]")).getText().trim();
                    } catch (NoSuchElementException d) {
                        option[i] = "";
                    }
                }
                if (i != size - 1) {
                    options += option[i++] + ", ";
                } else {
                    options += option[i];
                }
            }
            if (size == numOfpages) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        } else {
            System.out.println("TOTAL FAILURE");
        }
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}