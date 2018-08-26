//package main.java.extended.extended.issues;
//
////package <set your test package>;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import com.experitest.appium.SeeTestClient;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//
//public class SA22433 {
//
//    AppiumDriver driver;
//
//    @BeforeMethod
//    public void setUp() throws MalformedURLException {
//        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability("reportDirectory", "reports");
//        dc.setCapability("reportFormat", "xml");
//        dc.setCapability("testName", "Test Execute Script");
//
//   /*     dc.setCapability(MobileCapabilityType.UDID, "CB5A25AM17");
//        dc.setCapability("user", "eyal");
//        dc.setCapability("projectName", "");
//        dc.setCapability("password", "Experitest2012");
//        driver = new AndroidDriver(new URL("http://mastercloud:80/wd/hub"), dc);*/
//        // driver = new AndroidDriver(new URL("https://qacloud.experitest.com/wd/hub"), dc);
//
//
//        dc.setCapability(MobileCapabilityType.UDID, "9a3efe031d62cfc2");
//        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
//        //driver.setLogLevel(Level.INFO);
//
//
//    }
//
//    @Test
//    public void testExecuteScript(){
//        //driver.executeScript("client:client.report(\"Passed\", true);");
//        SeeTestClient client = new SeeTestClient(driver);
//        //driver.executeScript("client:client.report(\"C:\\\\Pic\\\\x.png\",\"Passed Script\", true);");
//        //driver.executeScript("client:client.report(\"https://qacloud.experitest.com/theme/images/logo.png\",\"Passed Script\", true);");
//        //driver.executeScript("client:client.report(\"\\\\\\\\LONG-RUN-PC\\\\Users\\\\user\\\\Desktop\\\\files\\\\Eyal\\\\X.png\",\"Passed Script\", true);");
//        driver.getPageSource();
//        String versionWithBuild = client.getVersionWithBuild();
//        System.out.println("Version :"+versionWithBuild);
//        client.report("C:\\\\Pic\\\\x.png","Passed Command",true);
//        //client.report("C:\\Pic\\x.png","Passed Command",true);
//
//        //client.report("https://qacloud.experitest.com/theme/images/logo.png","Passed Command",true);
//        //client.report("\\\\\\\\LONG-RUN-PC\\\\Users\\\\user\\\\Desktop\\\\files\\\\Eyal\\\\X.png","Passed Command",true);
////        client.report("\\\\\\\\\\\\\\\\LONG-RUN-PC\\\\\\\\Users\\\\\\\\user\\\\\\\\Desktop\\\\\\\\files\\\\\\\\Eyal\\\\\\\\X.png","Passed Command",true);
////        client.report("\\\\\\\\LONG-RUN-PC\\\\Users\\\\user\\\\Desktop\\\\files\\\\Eyal\\\\X.png","Passed Command",true);
//        //client.report("\\\\LONG-RUN-PC\\Users\\user\\Desktop\\files\\Eyal\\X.png","Passed Command",true);
//
//        String deviceProperty = client.getDeviceProperty("device.name");
//        System.out.println("Device Name :"+deviceProperty);
//        //client.report("/Pic/x.png","Passed Command",true);
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
//
//}