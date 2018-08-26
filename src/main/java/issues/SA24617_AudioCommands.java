package main.java.issues;

// Insert your package here
import java.net.MalformedURLException;
import java.net.URL;

import com.experitest.appium.SeeTestClient;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SA24617_AudioCommands {
    static {
        System.getProperties().setProperty("javax.net.ssl.trustStore","C:\\Users\\eyal.neumann\\Documents\\keys3\\truststore.jks");
        System.getProperties().setProperty("javax.net.ssl.trustStorePassword","");

    }
    AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", "reports");
        dc.setCapability("reportFormat", "xml");
        dc.setCapability("testName", "SA24617 Audio Commands");
        dc.setCapability(MobileCapabilityType.UDID, "32049b2612d2b1b9");
        dc.setCapability("accessKey","eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVek5EWTNNVFUwTnpBd09RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NTAwMzE1NDcsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.xjzfbudHNhCSguAMYPeSJDfwgKb-H85GmI3OV_Tzxtw");
        //dc.setCapability(MobileCapabilityType.APP, <PATH TO APPLICATION> ); // If you wish to continue with the app running on the device, comment this line
        //driver = new AndroidDriver(new URL("https://eilongrodsky-pc/wd/hub"), dc);
        driver = new AndroidDriver(new URL("https://eyalneumann.experitest.local:8091/wd/hub"), dc);    }

    @Test
    public void testAudioCommands() throws Exception {
        //Enter your test code here
        SeeTestClient client=new SeeTestClient(driver);
        System.out.println(client.getVersionWithBuild());
        client.launch("com.sec.android.app.voicenote/.main.VNMainActivity", false, false);
//        client.click("NATIVE", "//*[@id='recorder_control_record_button']", 0, 1);
        client.click("NATIVE", "xpath=//*[@contentDescription='Record']", 0, 1);
        //client.startAudioPlay("C:\\\\Users\\\\eilon.grodsky\\\\Downloads\\\\FFVII_Victory_Fanfare_Ringtone_Dracotonis_.wav");
        client.startAudioPlay("C:\\Users\\eyal.neumann\\Music\\FFVII_Victory_Fanfare_Ringtone_Dracotonis_.wav");
        //client.waitForAudioPlayEnd();
        client.sleep(10000);
        client.click("NATIVE", "xpath=//*[@id='recorder_control_stop_button']", 0, 1);
        client.click("NATIVE", "xpath=//*[@id='listrow_voiceclip']", 0, 1);
        //String uploadFile = client.uploadFile("C:\\Users\\eyal.neumann\\Music\\Recording001.wav");
//        System.out.println("uploadFile:"+uploadFile);
          client.startAudioRecording("C:\\Users\\eyal.neumann\\Music\\Recording00025.wav");
        //client.startAudioRecording("C:\\\\Users\\\\eilon.grodsky\\\\Downloads\\\\Recording0022.wav");
//        if(client.waitForElement("NATIVE", "xpath=//*[@id='player_duration']", 0, 10000)){
//            // If statement
//        }
//        if(client.waitForElementToVanish("NATIVE", "xpath=//*[@id='player_duration']", 0, 10000)){
//            // If statement
//        }
        client.sleep(12000);

        client.stopAudioRecording();
        System.out.println("Done");



    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}