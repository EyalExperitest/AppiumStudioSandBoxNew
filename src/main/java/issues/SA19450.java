package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA19450 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA19450";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "e323acec7ba4322be383a7c431d8a7d8739b581b");
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA19450() {
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@accessibilityLabel='loginButton']")).click();
        driver.findElement(By.xpath("//*[@accessibilityLabel='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Phone']")).sendKeys("0976876876");
        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("Eyal");
        driver.findElement(By.xpath("//*[@placeholder='Amount']")).sendKeys("100");
        driver.findElement(By.xpath("//*[@accessibilityLabel='countryButton']")).click();
       // driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 0, 2000, \"NATIVE\", \"xpath=//*[@accessibilityLabel='Spain']\", 0, 1000, 5, true)")
        driver.findElement(By.xpath("//*[@accessibilityLabel='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='Yes']")).click();
        driver.findElement(By.xpath("//*[@accessibilityLabel='logoutButton']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}