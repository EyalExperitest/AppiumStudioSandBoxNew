package main.java.testrail.exported;

/**
 * Created by eyal.neumann on 12/19/2017.
 */
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.drivers.ExIOSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class IOCUICatalogTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "IOCUICatalogTest";
    protected ExIOSDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "8a81b1e32471f53ac99a741bcc14bd6b84991fff");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.UICatalog");
        dc.setCapability("instrumentApp", true);
        driver = new ExIOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testIOCUICatalogTest() {
        driver.findElement(By.xpath("//*[@accessibilityLabel='TextFields']")).click();
        driver.findElement(By.xpath("(//*[@class='UIATable']/*/*[@placeholder='<enter text>'])[1]")).sendKeys("Text0001");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@text='TextFields']/*[@text='Back'])[1]")));
        driver.findElement(By.xpath("(//*[@text='TextFields']/*[@text='Back'])[1]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@accessibilityLabel='Images']")));
        driver.findElement(By.xpath("//*[@accessibilityLabel='Images']")).click();
        driver.findElement(By.xpath("(//*[@accessibilityLabel='Images']/*[@text='Back'])[1]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Controls' and @class='UIAStaticText']")));
        driver.findElement(By.xpath("//*[@text='Controls' and @class='UIAStaticText']")).click();
        driver.findElement(By.xpath("//*[@text='Category : Mirron']")).click();
        driver.findElement(By.xpath("//*[@text='Tinted']")).click();
        driver.findElement(By.xpath("//*[@text='Category : Mirron']")).click();
        driver.findElement(By.xpath("(//*[@text='Controls']/*[@text='Back'])[1]")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}