package main.java.issues;

//package <set your test package>;
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA20200 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA20200";
    protected IOSDriver<IOSElement> driver = null;
    private SeeTestClient client;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "e323acec7ba4322be383a7c431d8a7d8739b581b");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.UICatalog");
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
        client = new SeeTestClient(driver);

    }

    @Test
    public void testSA20200() {
        driver.findElement(By.xpath("//*[@accessibilityLabel='TextFields']")).click();
        driver.findElement(By.xpath("(//*[@class='UIATable']/*/*[@placeholder='<enter text>'])[1]")).sendKeys("Text");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@text='TextFields']/*[@text='Back'])[1]")));
        driver.findElement(By.xpath("(//*[@text='TextFields']/*[@text='Back'])[1]")).click();
        driver.executeScript("client:client.deviceAction(\"Home\")");
        System.out.println("Please Find The Clock");

        client.sleep(5000);

        driver.findElement(By.xpath("//*[@text='Clock']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Stopwatch']")));
        driver.findElement(By.xpath("//*[@text='Stopwatch']")).click();
        driver.findElement(By.xpath("//*[@text='Start']")).click();
        long t0 = System.currentTimeMillis();
        client.sleep(5000);
        long t1 = System.currentTimeMillis();
        driver.findElement(By.xpath("//*[@text='Stop']")).click();
        System.out.println(t1-t0);

        t0 = System.currentTimeMillis();
        client.sleep(5000);
        t1 = System.currentTimeMillis();
        System.out.println(t1-t0);

        t0 = System.currentTimeMillis();
        client.sleep(5000);
        t1 = System.currentTimeMillis();
        System.out.println(t1-t0);

        t0 = System.currentTimeMillis();
        client.sleep(5000);
        t1 = System.currentTimeMillis();
        System.out.println(t1-t0);

        t0 = System.currentTimeMillis();
        client.sleep(5000);
        t1 = System.currentTimeMillis();
        System.out.println(t1-t0);

        t0 = System.currentTimeMillis();
        client.sleep(5000);
        t1 = System.currentTimeMillis();
        System.out.println(t1-t0);

        t0 = System.currentTimeMillis();
        client.sleep(5000);
        t1 = System.currentTimeMillis();
        System.out.println(t1-t0);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}