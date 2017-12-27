package main.java.issues;

//package <set your test package>;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA18610 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA18610";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "ce051605686c683b03");
        dc.setBrowserName(MobileBrowserType.CHROMIUM);
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA18610() {
        driver.get("http://www.amazon.com");
        WebElement search = driver.findElement(By.xpath("//*[@nodeName='INPUT' and @id='nav-search-keywords']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(search);
        actions.click();
        actions.sendKeys("A dance with dragons");
        actions.build().perform();    }

    @After
    public void tearDown() {
        driver.quit();
    }
}