/*
package main.java.tests;

//package <set your test package>;
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;


public class SA26070_GetApplicationInfoAndroid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA26070_GetApplicationInfoAndroid";
    protected AndroidDriver<AndroidElement> driver = null;
    private SeeTestClient client ;
    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "14bdd0fd9904");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
        client = new SeeTestClient(driver);
    }

    @Test
    public void testSA26070_getApplicationInfoAndroid(){
        String str0 = client.getApplicationInfo("com.experitest.ExperiBank", "versionCode");
        String str1 = client.getApplicationInfo("com.experitest.ExperiBank", "versionName");
        System.out.println(str0);
        System.out.println(str1);
    }

    @Test
    public void testSA26070_getApplicationInfoAndroidNoApp(){
        if(client.uninstall("com.experitest.ExperiBank")){
            // If statement
        }
        try {
            String str0 = client.getApplicationInfo("com.experitest.ExperiBank", "versionCode");
            String str1 = client.getApplicationInfo("com.experitest.ExperiBank", "versionName");
            System.out.println(str0);
            System.out.println(str1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSA26070_getApplicationInfoAndroid2Apps(){
        client.setDevice("adb:Redmi Note 4");


        try {
            String str0 = client.getApplicationInfo("com.experitest.unlock", "versionCode");
            String str1 = client.getApplicationInfo("com.experitest.unlock", "versionName");
            System.out.println(str0);
            System.out.println(str1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSA26070_getApplicationInfoAndroidAllApps(){
        String installedApplications = client.getInstalledApplications();
        String[] splitinstalledApplications = installedApplications.replaceAll(";","").split("\n");
        for(String split: splitinstalledApplications){
            System.out.println("*****************************************************");
            System.out.println(split+":");
            try {
                String str0 = client.getApplicationInfo(split, "versionCode");
                String str1 = client.getApplicationInfo(split, "versionName");
                System.out.println("versionCode : "+str0);
                System.out.println("versionName : "+str1);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed To Get Info for App: "+split);

            }
            System.out.println("*****************************************************");
        }



    }
    @Test
    public void testSA26070_getApplicationWrong(){
        String str0 = null;
        try {
            str0 = client.getApplicationInfo("com", "versionCode");
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
/*        String str1 = null;
        try {
            str1 = client.getApplicationInfo("com.apple.videos", "versionCode");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            client.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String aNative = client.getVisualDump("Native");
        } catch (Exception e) {
            e.printStackTrace();
        }*//*

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}*/
