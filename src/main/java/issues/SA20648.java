package main.java.issues;

/**
 * Created by eyal.neumann on 11/30/2017.
 */
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.net.MalformedURLException;

public class SA20648 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA20648";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "32049b2612d2b1b9");
        //dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\apk\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA20648() {
        String pageSource1 = driver.getPageSource();


        Object result1 = driver.executeScript("experitest: client.startStepsGroup(\"Steps Group1\")");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("usernameTextField")));
        driver.findElement(By.id("usernameTextField")).sendKeys("company");
        driver.findElement(By.id("passwordTextField")).sendKeys("company");
        driver.executeScript("experitest:client.stopStepsGroup()");

        driver.findElement(By.id("loginButton")).click();
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*@id='logoutButton']")));
          new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='logoutButton']")));
//        driver.findElement(By.xpath("//*[@id='logoutButton']")).click();
          driver.findElement(By.xpath("//*[@id='logoutButton']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}