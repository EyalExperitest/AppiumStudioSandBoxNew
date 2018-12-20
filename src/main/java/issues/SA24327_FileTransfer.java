//package main.java.issues;
//
//// Insert your package here
//
//import com.experitest.appium.SeeTestClient;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.AndroidMobileCapabilityType;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class SA24327_FileTransfer {
//    static {
//        //    System.getProperties().setProperty("javax.net.ssl.trustStore","/Users/Mac10/Downloads/truststore.jks");
//        System.getProperties().setProperty("javax.net.ssl.trustStore","C:\\Users\\eyal.neumann\\Documents\\keys3\\truststore.jks");
//        System.getProperties().setProperty("javax.net.ssl.trustStorePassword","");
//
//    }
//    AppiumDriver driver;
//
//    @BeforeMethod
//    public void setUp() throws MalformedURLException {
//        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability("reportDirectory", "reports");
//        dc.setCapability("reportFormat", "xml");
//        dc.setCapability("testName", "SA24327 File Transfer From PC 8");
//        dc.setCapability(MobileCapabilityType.UDID, "2bc6d8279805");
//        dc.setCapability("accessKey","eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVek5EWTNNVFUwTnpBd09RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NTAwMzE1NDcsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.xjzfbudHNhCSguAMYPeSJDfwgKb-H85GmI3OV_Tzxtw");
//        dc.setCapability(MobileCapabilityType.APP, "cloud:com.CameraFlash/.MainActivity");
//        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.CameraFlash");
//        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
//        dc.setCapability("instrumentApp", true);
//        //dc.setCapability(MobileCapabilityType.APP, <PATH TO APPLICATION> ); // If you wish to continue with the app running on the device, comment this line
//        //driver = new AndroidDriver(new URL("https://eilongrodsky-pc/wd/hub"), dc);
//        driver = new AndroidDriver(new URL("https://eyalneumann.experitest.local:8091/wd/hub"), dc);    }
//
//    @Test
//    public void testSA24327_FileTransfer() throws Exception {
//        //Enter your test code here
//        ///Users/Mac10/IdeaProjects/AppiumStudioSandBoxNew/Files
//        String basePath="C:\\Users\\eyal.neumann\\workspace\\AppiumStudioSandBoxNew\\Files";
//
//        String captureFilePath =basePath+"\\capture003.png";
//        String loginPicturePath = basePath+"\\login.png";
//        String zipDestination = basePath+"\\SupportData\\";
//        String monitorDataPath = basePath+"\\MonitorData003.csv";
//        String logPath = basePath+"\\deviceLog002.log";
//        String audioFilePlay = basePath+"\\FFVII_Victory_Fanfare_Ringtone_Dracotonis_.wav";
//        String audioFileRecord =basePath+"\\RecordingMac0003.wav";
//
//        SeeTestClient client=new SeeTestClient(driver);
//        System.out.println(client.getVersionWithBuild());
//        client.startMonitor("com.CameraFlash");
//        client.startLoggingDevice(logPath);
//        System.out.println(client.getVersionWithBuild());
//        String capture = client.capture(captureFilePath,"Capture");
//        System.out.println(capture);
//        client.simulateCapture(loginPicturePath);
//
//        client.report(captureFilePath, "Captured Image",true);
//        client.report(loginPicturePath, "Simulate Image",true);
//        client.stopAudioPlay();
//
//
////        client.startAudioPlay(audioFilePlay);
////        client.waitForAudioPlayEnd(100000);
////
////
////
////        client.startAudioRecording(audioFileRecord);
////        client.sleep(15000);
////        client.stopAudioRecording();
//        System.out.println("Done");
//
//
//        String deviceName = client.getDeviceProperty("device.name");
//        client.getMonitorsData(monitorDataPath);
//        try {
//            client.collectSupportData(zipDestination, "", "", "SupportData", "Expected", "Actual");
////            client.collectSupportData(zipDestination, "", deviceName, "SupportData", "Expected", "Actual");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        client.collectSupportData(zipDestination, "", deviceName, "SupportData", "Expected", "Actual",false,false);
//        client.stopLoggingDevice();
//        System.out.println("Done");
//
//
//
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
//
//}