package main.java.issues;

//package <set your test package>;
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA18207IOS {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA18207IOS";
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
    public void testSA18207IOS() {
        String pageSource1 = driver.getPageSource();
        String visualDump = client.getVisualDump("Native");

        System.out.println("pageSource1:"+pageSource1);
        System.out.println("visualDump:"+visualDump);
        System.out.println("Match :"+visualDump.equals(pageSource1));



    }

    @After
    public void tearDown() {
        driver.quit();
    }
}