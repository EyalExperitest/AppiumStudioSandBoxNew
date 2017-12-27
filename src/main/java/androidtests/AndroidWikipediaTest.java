package main.java.androidtests;
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.drivers.ExAndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class AndroidWikipediaTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AndroidWikipediaTest";
    protected AndroidDriver driver = null;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "d0595c1001b9d9d4");
        dc.setBrowserName(MobileBrowserType.CHROMIUM);
        driver = new ExAndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testAndroidWikipediaTest() {
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.linkText("English")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("mw-mf-main-menu-button")));
        driver.findElement(By.id("mw-mf-main-menu-button")).click();
        driver.findElement(By.linkText("Random")).click();
        driver.findElement(By.id("mw-mf-main-menu-button")).click();
        driver.findElement(By.linkText("Random")).click();
        driver.findElement(By.id("mw-mf-main-menu-button")).click();
        driver.findElement(By.linkText("Random")).click();
        driver.findElement(By.id("mw-mf-main-menu-button")).click();
        driver.findElement(By.linkText("Random")).click();
        driver.findElement(By.id("mw-mf-main-menu-button")).click();
        driver.findElement(By.linkText("Random")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}