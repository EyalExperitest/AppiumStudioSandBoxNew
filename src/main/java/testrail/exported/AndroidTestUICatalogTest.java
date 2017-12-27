package main.java.testrail.exported;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidKeyCode;
import main.java.drivers.ExAndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class AndroidTestUICatalogTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AndroidTestUICatalogTest";
    protected ExAndroidDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "015d28568f541e0f");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.uicatalog/.MainActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.uicatalog");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        dc.setCapability("instrumentApp", true);
        driver = new ExAndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testAndroidTestUICatalogTest() {
        driver.findElement(By.xpath("//*[@text='Buttons']")).click();
        driver.findElement(By.xpath("//*[@text='Long Click Button']")).click();
        driver.findElement(By.xpath("//*[@text='CheckBox']")).click();
        driver.findElement(By.xpath("//*[@text='One']")).click();
        driver.findElement(By.xpath("//*[@text='Two']")).click();
        driver.findElement(By.xpath("//*[@text='Three']")).click();
        driver.findElement(By.xpath("//*[@text='Radio button three pressed']")).click();
        driver.findElement(By.xpath("//*[@id='imageButton']")).click();
        driver.findElement(By.xpath("//*[@text='Image button pressed']")).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElement(By.xpath("//*[@text='Text Fields']")).click();
        driver.findElement(By.xpath("//*[@hint='Normal Text field']")).sendKeys("Normal");
        driver.findElement(By.xpath("//*[@hint='Name']")).sendKeys("Name");
        driver.findElement(By.xpath("//*[@hint='Password']")).sendKeys("123456");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='MultiLine Text']")));
        driver.findElement(By.xpath("//*[@hint='MultiLine Text']")).sendKeys("Line000");
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}