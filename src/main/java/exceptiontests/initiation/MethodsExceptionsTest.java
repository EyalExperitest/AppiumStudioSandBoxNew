package main.java.exceptiontests.initiation;

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
import org.openqa.selenium.OutputType;
import java.io.File;
import java.util.Set;

public class MethodsExceptionsTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "MethodsExceptionsTest";
    protected IOSDriver driver = null;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "817c13817e7e131bdbb0fe8ce94f944051dd3422");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        dc.setCapability("instrumentApp", true);
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testMethodsExceptionsTest() throws InterruptedException {
        //String pageSource1 = driver.getPageSource();
        //String str1 = (String)driver.executeScript("client:client.getContextList()");
        //System.out.println(str1);


        //driver.shake();
        //String windowHandle = driver.getWindowHandle(); //Not Implemented
        //driver.rotate(null); //NullPointerException
        //driver.context("Nop"); //No such context found
        //File screenshotFile1 = driver.getScreenshotAs(OutputType.FILE); //unable to capture screen
        //System.out.println(screenshotFile1.getAbsolutePath());
        // driver.switchTo().window("Nop"); // Not Implemented
       //driver.findElement(By.xpath("Nop"));// no such element

        driver.findElement(By.xpath("//*[@accessibilityLabel='Login']")).sendKeys("Nop");

        Thread.sleep(5000);


    }

    @After
    public void tearDown() {
        driver.quit();
    }
}