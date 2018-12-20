package main.java.manager;

import com.experitest.reporter.junit4.AfterWithSeeTestReporter;
import com.experitest.reporter.junit4.ReporterRule;
import com.experitest.reporter.junit4.ReporterRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

//@RunWith(ReporterRunner.class)
public class SA26036_JUnit4_Android_Rule {

    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2ODIzOTY1OTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.lymE9fDIIlTLsrr-ph6oMlgtpVY7-knj44SIZXc1rMc";
    protected AndroidDriver<AndroidElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();



    @Rule
    public ReporterRule reporterRule = new ReporterRule(this);



    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", "Android Native Junit4 with Rule ,Failure");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
//        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
//        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
//        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
       driver = new AndroidDriver<>(new URL("https://qacloud.experitest.com/wd/hub"), dc);
        //driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);

    }

    @Test
    public void quickStartAndroidNativeDemo() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        Assert.fail("Random Failure");

        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
        driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
        driver.findElement(By.xpath("//*[@id='countryButton']")).click();
        driver.findElement(By.xpath("//*[@text='Switzerland']")).click();
        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='Yes']")).click();
    }

    //@After
    @AfterWithSeeTestReporter
    public void tearDown() {
        driver.quit();
    }
}