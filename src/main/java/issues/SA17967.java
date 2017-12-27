package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA17967 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA17967";
    protected IOSDriver driver = null;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "60ab9979d3fbef1c2692ac9b2b0aa766cb3efb44");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\UICatalog.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.UICatalog");
        dc.setCapability("instrumentApp", true);
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);

        dc.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS,true);
        //dc.setCapability("autoAcceptAlerts",true);
        //dc.setCapability(IOSMobileCapabilityType.AUTO_DISMISS_ALERTS,true);
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA17967() throws InterruptedException {
        //driver.swipe(365, 1120, 327, 264, 760);
        driver.findElement(By.xpath("//*[@class='UITableViewCellContentView' and ./*[@text='PhotoPickerViewTitle']]")).click();
        //try{driver.findElement(By.linkText("nop")).click();}catch (Exception e){ }
        driver.findElement(By.xpath("//*"));
        Thread.sleep(10000);
        driver.removeApp("com.experitest.UICatalog");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}