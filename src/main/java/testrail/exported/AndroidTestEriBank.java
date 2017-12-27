package main.java.testrail.exported;

/**
 * Created by eyal.neumann on 12/20/2017.
 */
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.drivers.ExAndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class AndroidTestEriBank {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AndroidTestEriBank";
    //protected AndroidDriver<AndroidElement> driver = null;
    protected ExAndroidDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "CB5A25AM17");
        //dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        driver = new ExAndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testAndroidTestEriBank() {
        driver.context("NATIVE_APP");
        driver.findElement(By.id("usernameTextField")).sendKeys("company");
        driver.findElement(By.id("passwordTextField")).sendKeys("company");
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("makePaymentButton")).click();
        driver.findElement(By.id("phoneTextField")).sendKeys("908678");
        driver.findElement(By.id("nameTextField")).sendKeys("Name");
        driver.findElement(By.id("amountTextField")).sendKeys("-1000");
        driver.findElement(By.linkText("Select")).click();
        driver.findElement(By.linkText("Canada")).click();
        driver.findElement(By.id("sendPaymentButton")).click();
        driver.findElement(By.linkText("Yes")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}