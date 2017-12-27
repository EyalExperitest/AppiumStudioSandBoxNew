package main.java.sanity;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class AndroidSanity {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AndroidSanity";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "85b65151454a4f54");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "cloud:com.experitest.uicatalog");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testAndroidSanity() {
        driver.findElement(By.xpath("//*[@text='Buttons']")).click();
        driver.findElement(By.xpath("//*[@text='LONG CLICK BUTTON']")).click();
        driver.findElement(By.xpath("//*[@text='CheckBox']")).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElement(By.xpath("//*[@text='Text Fields']")).click();
        driver.findElement(By.xpath("//*[@id='editText']")).sendKeys("Test 1");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}