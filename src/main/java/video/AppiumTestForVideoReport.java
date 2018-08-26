package main.java.video;

//package <set your test package>;
import com.experitest.appium.SeeTestClient;
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

public class AppiumTestForVideoReport {
    private String reportDirectory = "reports";
    private String reportFormat = "xml,html2";
    private String testName = "Appium Test For Video Report";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        //dc.setCapability(MobileCapabilityType.UDID, "2d522e08c4694484718d46ee55afefcc8bf41d7e");
        dc.setCapability(MobileCapabilityType.UDID, "2ec34da9c45eedbeea2bfaf2253a3b567ce45699");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        //driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testAppiumTestForVideoReport() {
        SeeTestClient client = new SeeTestClient(driver);



        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Password']")));
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='loginButton']")).click();
        driver.findElement(By.xpath("//*[@text='Advanced Actions']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Account Info']")));
        driver.findElement(By.xpath("//*[@text='Account Info']")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='OK']")));
        driver.findElement(By.xpath("//*[@text='OK']")).click();
        //String str0 = client.capture("Capture");
        String str1 = client.getVisualDump("Native");

        client.report("Success Report",true);
        client.report("Failure Report",false);

//        client.report("C:\\Users\\eyal.neumann\\Pictures\\login.png","C:\\Users\\eyal.neumann\\Pictures\\login.png",true);
//        client.report("C:\\Users\\eyal.neumann\\Pictures\\login000.png","C:\\Users\\eyal.neumann\\Pictures\\login000.png",false);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}