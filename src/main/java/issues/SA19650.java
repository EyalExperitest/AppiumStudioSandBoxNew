package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Set;

import static org.junit.Assert.fail;

public class SA19650 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA19650";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "32049b2612d2b1b9");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.uicatalog");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA19650() throws InterruptedException {
        driver.findElement(By.linkText("WebElements")).click();
        //String str1 = (String)driver.executeScript("client:client.getContextList()");
        Set<String> contextHandles = driver.getContextHandles();
        for (String contextHandle:contextHandles){
            System.out.println(contextHandle);
        }
        //System.out.println(str1);
        driver.context("NATIVE_APP_INSTRUMENTED");
        driver.findElement(By.id("webView"));
        driver.findElement(By.id("webView2"));
/*        String pageSource1 = driver.getPageSource();
        System.out.println("pageSource Native:\n "+pageSource1);*/
        Thread.sleep(3000);

        driver.context("WEBVIEW_1");
        driver.executeScript("client:client.setDefaultWebView(\"id=webView\");");
        driver.findElement(By.id("sb_form_q"));

        try{
            driver.findElement(By.xpath("//*[@class='login-btn']"));
            fail();
        }catch(Exception e){
            System.out.println("Element not in view");
        }

        driver.executeScript("client:client.setDefaultWebView(\"id=webView2\");");
        driver.findElement(By.xpath("//*[@class='login-btn']"));
        try{
            driver.findElement(By.id("sb_form_q"));
            fail();
        }catch(Exception e){
            System.out.println("Element not in view");
        }




    }

    @After
    public void tearDown() {
        driver.quit();
    }
}