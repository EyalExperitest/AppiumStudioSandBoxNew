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

public class SA19132B {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA 19132B Client";
    protected IOSDriver<IOSElement> driver = null;
    private SeeTestClient client;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "e323acec7ba4322be383a7c431d8a7d8739b581b");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
        client = new SeeTestClient(driver);

    }

    @Test
    public void testSA19132B() {
        //Object result1 = driver.executeScript("client:client.startMonitor(\"com.experitest.ExperiBank\")");
        //Object result2 = driver.executeScript("client:client.setMonitorPollingInterval(100)");
        client.startMonitor("com.experitest.ExperiBank");
        client.setMonitorPollingInterval(100);

        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='loginButton']")).click();
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        driver.findElement(By.xpath("//*[@text='Expense Report']")).click();
        driver.findElement(By.xpath("//*[@text='Detail goes here' and ./preceding-sibling::*[@text='Expense 0']]")).click();
        driver.findElement(By.xpath("//*[@text='Detail goes here' and ./preceding-sibling::*[@text='Expense 1']]")).click();
        driver.findElement(By.xpath("//*[@text='addButton']")).click();
        driver.findElement(By.xpath("//*[@text='addButton']")).click();
        driver.findElement(By.xpath("//*[@text='addButton']")).click();
        driver.findElement(By.xpath("//*[@text='addButton']")).click();
        driver.findElement(By.xpath("//*[@text='addButton']")).click();
        driver.findElement(By.xpath("//*[@text='addButton']")).click();
        driver.findElement(By.xpath("//*[@text='addButton']")).click();
        driver.findElement(By.xpath("//*[@text='addButton']")).click();
        driver.findElement(By.xpath("//*[@text='addButton']")).click();
        driver.findElement(By.xpath("//*[@text='addButton']")).click();
        driver.findElement(By.xpath("//*[@text='addButton']")).click();
        driver.findElement(By.xpath("//*[@text='addButton']")).click();

        //new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@accessibilityLabel='logoutButton']")));
        //driver.findElement(By.xpath("//*[@accessibilityLabel='logoutButton']")).click();
        //Object result3 = driver.executeScript("client:client.getMonitorsData(\"\")");
        //client.getMonitorsData("");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}