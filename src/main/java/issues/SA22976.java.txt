package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

import static org.testng.Assert.assertEquals;

public class SA22976 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA22976";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
//        dc.setCapability("reportDirectory", reportDirectory);
//        dc.setCapability("reportFormat", reportFormat);
//        dc.setCapability("testName", testName);
//        dc.setCapability(MobileCapabilityType.UDID, "3801a15c53ba3300");
//        //dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\apk\\com.compass.rewards.MainActivity.2.apk");
////        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.compass.rewards");
////        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
////        dc.setCapability("instrumentApp", true);
//        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        //driver.setLogLevel(Level.INFO);


        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "220990352c057ece");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);

    }

    @Test
    public void testSA22976() {
        String pageSource1 = driver.getPageSource();
        //ystem.out.println(pageSource1);
        //driver.context("NATIVE_APP");
        // driver.findElement(By.id("btnAgree"));
        // driver.findElement(By.linkText("同意並開始使用"));
        // driver.findElement(By.linkText("多謝下載 COMPASS VISA android 應用程式。使用前必須同意以下條款。"));
        // driver.findElement(By.id("btnDisagree"));
        //driver.findElement(By.id("message"));
        //driver.findElement(By.xpath("//*[@id='message']"));

        String text1 = driver.findElement(By.id("message")).getText();
        //String text1 = driver.findElement(By.xpath("//*[@id='message']")).getText();
        System.out.println(text1+"\n");
        String expected = "無法連接伺服器，請檢查網路連接。";
        assertEquals(text1,expected);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}