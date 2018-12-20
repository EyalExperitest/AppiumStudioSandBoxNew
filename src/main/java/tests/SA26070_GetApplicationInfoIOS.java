/*
package main.java.tests;
//package <set your test package>;
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;


public class SA26070_GetApplicationInfoIOS {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA26070_GetApplicationInfoIOS";
    protected IOSDriver<IOSElement> driver = null;
    protected SeeTestClient client ;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "1c18924584f05c3594d431229a7ceb2c5897b769");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        //driver.setLogLevel(Level.INFO);
        client = new SeeTestClient(driver);
        System.out.println(client);
        client.report("Start",true);
    }


    @Test
    public void testSA26070_getApplicationInfoIOSAllApps(){
        System.out.println(client);
        String installedApplications = client.getInstalledApplications();
        System.out.println(installedApplications);
        String[] splitinstalledApplications = installedApplications.replaceAll(";","").split("\n");
//        System.out.println(installedApplications);
        for(String split: splitinstalledApplications){
            System.out.println("*****************************************************");
            System.out.println(split+":");
            try {
                String str0 = client.getApplicationInfo(split.trim(), "CFBundleVersion");
                String str1 = client.getApplicationInfo(split.trim(), "CFBundleShortVersionString");
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
    public void testSA26070_getApplicationInfoIOS(){
        String str0 = client.getApplicationInfo("com.experitest.ExperiBank", "CFBundleVersion");
        String str1 = client.getApplicationInfo("com.experitest.ExperiBank", "CFBundleShortVersionString");
        System.out.println(str0);
        System.out.println(str1);

    }
    @Test
    public void testSA26070_getApplicationInfoIOS2(){
        String str0 = client.getApplicationInfo("com.apple.videos", "CFBundleVersion");
        String str1 = client.getApplicationInfo("com.apple.videos", "CFBundleShortVersionString");
        System.out.println(str0);
        System.out.println(str1);

    }
    @Test
    public void testSA26070_getApplicationInfoIOSNoApp(){
        if(client.uninstall("com.experitest.ExperiBank")){
            // If statement
        }
        try {
            String str0 = client.getApplicationInfo("com.experitest.ExperiBank", "CFBundleVersion");
            String str1 = client.getApplicationInfo("com.experitest.ExperiBank", "CFBundleShortVersionString");
            System.out.println(str0);
            System.out.println(str1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        client.report("Client Survived ",true);


    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}*/
