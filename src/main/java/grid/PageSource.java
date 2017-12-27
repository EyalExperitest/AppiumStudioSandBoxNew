package main.java.grid;
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class PageSource {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "PageSourceAndroid";
    private String accessKey = "eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9UZzFNVEl3TXprd05BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MTc2NDc2NTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NJkrA94cO5ONFXFnZid06BtEcCljWHEeYkdRQWLUOcM";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, "91df46f3");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<AndroidElement>(new URL("http://eyalneumann.experitest.local:8091/wd/hub"), dc);
    }

    @Test
    public void testPageSource() {
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}