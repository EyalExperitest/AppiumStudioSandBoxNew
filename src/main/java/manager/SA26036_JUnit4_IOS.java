package main.java.manager;

import com.experitest.reporter.junit4.ReporterRunner;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.SkipException;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(ReporterRunner.class)
public class SA26036_JUnit4_IOS {

    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2ODIzOTY1OTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.lymE9fDIIlTLsrr-ph6oMlgtpVY7-knj44SIZXc1rMc";
    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "iOS Native JUnit4 with Skip");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<>(new URL("https://qacloud.experitest.com/wd/hub"), dc);
    }

    @Test
    public void quickStartiOSNativeDemo() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        throw (new SkipException("Skiped"));
        //Assert.fail("Random Failure");

//        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
//        driver.hideKeyboard();
//        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
//        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
//        driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
//        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
//        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
//        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
//        driver.findElement(By.xpath("//*[@id='countryButton']")).click();
//        driver.findElement(By.xpath("//*[@id='Switzerland']")).click();
//        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
//        driver.findElement(By.xpath("//*[@id='Yes']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}