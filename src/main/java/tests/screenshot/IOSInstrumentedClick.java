package main.java.tests.screenshot;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class IOSInstrumentedClick {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "IOS Instrumented Click";
    private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTUEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4Mzk5MTMxMjEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NDxf8DjL1TrXuFw6RpbLOBxTn0hVVPUCo3xc7xWknEw";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {


        boolean takeScreenShots = false;
        String takeScreenShotsString = takeScreenShots ? "With ScreenShots" : "Without ScreenShots";
        dc.setCapability("testName", testName+" "+ takeScreenShotsString);
        dc.setCapability("takeScreenshots", takeScreenShots);

        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        //dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, "1c18924584f05c3594d431229a7ceb2c5897b769");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.UICatalog");
        dc.setCapability("appVersion", "1294");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.UICatalog");
        dc.setCapability("instrumentApp", true);
        driver = new IOSDriver<>(new URL("https://mastercloud.experitest.com:443/wd/hub"), dc);
        //driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);

        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testIOSInstrumentedClick() {
        driver.findElement(By.xpath("//*[@text='Various uses of UIButton']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='UITableView']/*/*[@class='_UITableViewHeaderFooterContentView' and ./*[@text='UIBUTTON']])[1]")));
        driver.findElement(By.xpath("(//*[@class='UITableView']/*/*[@class='_UITableViewHeaderFooterContentView' and ./*[@text='UIBUTTON']])[1]")).click();
        driver.context("NATIVE_APP");

        Long[] clickTiming = new Long[100];
        long v0,v1;
        long avgClickTiming=0;
        long sumClickTiming=0;
        for (int i=0;i<clickTiming.length;i++) {
            System.out.println(i+"\n");
            v0 =System.currentTimeMillis();
            driver.findElement(By.linkText("Gray")).click();
            v1 =System.currentTimeMillis();
            clickTiming[i]=v1-v0;
            sumClickTiming+=clickTiming[i];
        }
        avgClickTiming =sumClickTiming/clickTiming.length;

        System.out.println("Average Click Timing :"+avgClickTiming);
        for (int i=0;i<clickTiming.length;i++) {
            System.out.println(clickTiming[i]);
        }






    }

    @After
    public void tearDown() {
        driver.quit();
    }
}