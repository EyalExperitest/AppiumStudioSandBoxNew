package main.java.tests.screenshot.advance;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.TouchAction;
import java.time.Duration;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class NonInstrumentedClickAfterSwipe {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Non Instrumented Click After Swipe W/O Screenshots";
    protected IOSDriver<IOSElement> driver = null;
    private String accessKey = "eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVek9URTFOamd3TkRRM013IiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NTQ1MTY4MDUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.y35ppa3JhZVw4u7DiuWv6TFK3gm17yKheKBFuFtEEFo";

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "36f0a41a8fca9263c1f977b915dcb5668a0b83fc");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
//        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        dc.setCapability("takeScreenshots", true);
        dc.setCapability("instrumentApp", false);
        driver = new IOSDriver<>(new URL("http://eyalneumann.experitest.local:8090/wd/hub"), dc);
        //driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testNonInstrumentedClickAfterSwipe() throws InterruptedException {
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='loginButton']")).click();
        driver.findElement(By.xpath("//*[@text='makePaymentButton']")).click();
        //driver.findElement(By.xpath("//*[@text='countryButton']")).click();
        int fails=0;
        int tries = 100;
        for (int i = 0; i< tries; i++) {
            try {
                driver.findElement(By.xpath("//*[@text='countryButton']")).click();
                new TouchAction(driver).press(435, 1155).waitAction(Duration.ofMillis(480)).moveTo(286, 252).release().perform();
                driver.findElement(By.xpath("//*[@text='South Africa']")).click();
                driver.findElement(By.xpath("//*[@text='countryButton']"));
                System.out.println("Element Found");

            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Element Not Found");

                fails++;
                driver.findElement(By.xpath("//*[@text='South Africa']")).click();

            } finally {
//                driver.findElement(By.xpath("//*[@text='countryButton']")).click();
                System.out.println(fails+" Fails out of "+(i+1)+ " tries");
                Thread.sleep(2000);

            }
        }
        System.out.println(fails+" out of "+tries+ " tries");
/*        new TouchAction(driver).press(316, 1012).waitAction(Duration.ofMillis(528)).moveTo(392, 332).release().perform();
        driver.findElement(By.xpath("//*[@text='South Africa']")).click();
        driver.findElement(By.xpath("//*[@text='countryButton']")).click();
        new TouchAction(driver).press(312, 983).waitAction(Duration.ofMillis(584)).moveTo(353, 226).release().perform();
        driver.findElement(By.xpath("//*[@text='South Africa']")).click();*/
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}