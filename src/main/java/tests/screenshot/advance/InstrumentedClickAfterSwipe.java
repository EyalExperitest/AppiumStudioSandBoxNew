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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class InstrumentedClickAfterSwipe {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Instrumented Click After Swipe With or W/O Screenshots";

    protected IOSDriver<IOSElement> driver = null;
    private String accessKey = "eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVek9UQXdPRGd5TkRjME13IiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NTQzNjg4MjQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.eP-0E-eqPkzSWCEhl_6nkidJDltRCMMib4jusr1lcc4";

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, "36f0a41a8fca9263c1f977b915dcb5668a0b83fc");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        dc.setCapability("instrumentApp", true);
        dc.setCapability("takeScreenshots", true);

//        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver = new IOSDriver<>(new URL("http://eyalneumann.experitest.local:8090/wd/hub"), dc);

        //driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testInstrumentedClickAfterSwipe() throws InterruptedException {
        driver.context("NATIVE_APP_INSTRUMENTED");
        driver.findElement(By.linkText("Username")).sendKeys("company");
        driver.findElement(By.linkText("Password")).sendKeys("company");
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.linkText("Make Payment")).click();


        int tries = 10;
        for (int j=1;j<11;j++) {
            int fails=0;
            int millis = 100 * j;
            for (int i = 0; i< tries; i++) {
                try {
                    driver.findElement(By.linkText("Select")).click();
                    new TouchAction(driver).press(435, 1155).waitAction(Duration.ofMillis(480)).moveTo(286, 252).release().perform();
                    Thread.sleep(millis);
                    new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("South Africa")));
                    driver.findElement(By.linkText("South Africa")).click();
                    driver.findElement(By.linkText("Select"));
                    driver.findElement(By.xpath("//*[@text='South Africa' and @class='UITextField']"));
                    //System.out.println("Element Found");

                } catch (Exception e) {
                    //e.printStackTrace();
                    //System.out.println("Element Not Found");

                    fails++;
                    try {
                        driver.findElement(By.xpath("//*[@text='South Africa']")).click();
                    } catch (Exception e1) {
                    }

                } finally {
    //                driver.findElement(By.xpath("//*[@text='countryButton']")).click();
                    //System.out.println("For "+millis+" Mili-seconds There is a "+fails+" Fails out of "+(i+1)+ " tries");
                    Thread.sleep(2000);

                }
            }
            System.out.println("For "+millis+" Mili-seconds There is a "+fails+" Fails out of "+tries+ " tries");

        }






    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}