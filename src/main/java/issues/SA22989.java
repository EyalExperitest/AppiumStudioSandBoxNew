package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

import static org.testng.Assert.assertEquals;

public class SA22989 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA22989";
    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2NzIxMzI4NTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.na315fDIXdpqkRVem7V1vbiHnST4I7Ee3vYMIpBb11A";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, "CB5A2BSDEE");
//        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\apk\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");

        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability(MobileCapabilityType.NO_RESET, true);
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver<>(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
        //driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testSA22989() {
        driver.executeScript("seetest:client.deviceAction(\"Enter\")");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Username']")));
        driver.findElement(By.xpath("//*[@hint='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@hint='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Login']")).click();

        driver.context("WEBVIEW_1");
        AndroidElement balance = driver.findElement(By.xpath("//*[@nodeName='H1']"));
        driver.context("NATIVE_APP_INSTRUMENTED");

        String balanceText = balance.getText();
        //assertEquals("Your balance is: 100.00$",balanceText);
        System.out.println("Balance Text :"+balanceText);


        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Make Payment']")));
        driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
        driver.findElement(By.xpath("//*[@hint='Phone']")).sendKeys("098765");
        driver.findElement(By.xpath("//*[@hint='Name']")).sendKeys("Eyal");
        driver.findElement(By.xpath("//*[@hint='Amount']")).sendKeys("50");
        driver.findElement(By.xpath("//*[@text='Select']")).click();
        driver.findElement(By.xpath("//*[@text='Greece']")).click();
        driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
        driver.findElement(By.xpath("//*[@text='Yes']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}