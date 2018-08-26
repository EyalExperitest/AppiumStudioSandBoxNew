//package main.java.extended;
//
//// Insert your package here
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
//public class AppiumTest {
//
//    AppiumDriver driver;
//
//    @BeforeMethod
//    public void setUp() throws MalformedURLException {
//        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability("reportDirectory", "reports");
//        dc.setCapability("reportFormat", "xml");
//        dc.setCapability("testName", "Test Execute Script");
//        dc.setCapability(MobileCapabilityType.UDID, "d0595c1001b9d9d4");
//        dc.setCapability("user", "eyal");
//        // In case your user is assigned to a single project leave empty, otherwise please specify the project name
//        dc.setCapability("projectName", "");
//        dc.setCapability("password", "Experitest2012");
//        //dc.setCapability(MobileCapabilityType.APP, <PATH TO APPLICATION> ); // If you wish to continue with the app running on the device, comment this line
//        driver = new AndroidDriver(new URL("http://mastercloud:80/wd/hub"), dc);
//    }
//
//    @Test
//    public void testExecuteScript(){
//        //driver.executeScript("client:client.report(\"Passed\", true);");
//        SeeTestClient client = new SeeTestClient(driver);
//        driver.executeScript("client:client.report(\"C:\\\\Pic\\\\x.png\",\"Passed Script\", true);");
//        client.report("C:\\Pic\\x.png","Passed Command",true);
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
//
//}