package main.java.issues;

/**
 * Created by eyal.neumann on 1/11/2018.
 */
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

public class SA20513 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA20513";
    private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTVRVd09UVXlPVEl3TWpreE53IiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MjQ4OTIwNzAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.icG-vUduTupsyGxjkOqK82j3yEa5f6311NZo6gHnmDM";

    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        //dc.setCapability("accessKey", accessKey);
        dc.setCapability("username", "eyal");
        dc.setCapability("password", "Experitest2012");

        //dc.setCapability(MobileCapabilityType.UDID, "HGAFJ9TG");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.eribank/com.experitest.ExperiBank.LoginActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.eribank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.experitest.ExperiBank.LoginActivity");

        driver = new AndroidDriver<>(new URL("http://mastercloud.experitest.local:80/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);

    }

    @Test
    public void testSA20513() {
        driver.context("NATIVE_APP");
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
        String name = driver.findElement(By.className("android.view.View")).getAttribute("name");
        System.out.println("Name:"+name);
        boolean contains = name.contains("$");
        System.out.println("contains:"+contains);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}