package main.java.extended.extended.issues;

/**
 * Created by eyal.neumann on 12/7/2017.
 */
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA20622 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA20622";
    protected AndroidDriver<AndroidElement> driver = null;
    protected  SeeTestClient client;
    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "32049b2612d2b1b9");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        client= new SeeTestClient(driver);

    }

    @Test
    public void testSA20622() {
        String pageSource1 = driver.getPageSource();
        String deviceScreenSize = client.getDeviceProperty("device.screensize");
        System.out.println(deviceScreenSize);


        System.out.println(client.getVersionWithBuild());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}