package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA17040 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA17040";
    protected AndroidDriver driver = null;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "d0595c1001b9d9d4");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudio\\apk\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA17040() {
        driver.context("NATIVE_APP");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("usernameTextField")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("passwordTextField")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("loginButton")));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}