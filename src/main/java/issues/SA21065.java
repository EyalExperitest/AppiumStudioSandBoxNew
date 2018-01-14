package main.java.issues;

/**
 * Created by eyal.neumann on 1/9/2018.
 */
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA21065 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA21065";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "F8AZFG02P867");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\apk\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "ASUS_Z00AD");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testSA21065() {
/*        driver.context("NATIVE_APP");
        driver.findElement(By.xpath("/*//*[@id='usernameTextField']")).replaceValue("company");*/
        AndroidElement element = driver.findElement(By.id("loginButton"));
        element.replaceValue("LOGIN");
        System.out.println(driver.findElement(By.xpath("//*[@id='loginButton']")).getText());
        System.out.println(element.getText());

        try {
            //driver.findElement(By.xpath("//*[@text='LOGIN']"));
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @After
    public void tearDown() {
        driver.quit();
    }
}