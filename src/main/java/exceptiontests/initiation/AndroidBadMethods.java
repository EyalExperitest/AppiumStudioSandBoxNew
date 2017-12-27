package main.java.exceptiontests.initiation;
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Set;

public class AndroidBadMethods {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "AndroidBadMethods";
    protected AndroidDriver driver = null;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "ce051605686c683b03");
        //dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        //dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        //dc.setCapability("instrumentApp", true);
        dc.setBrowserName(MobileBrowserType.CHROMIUM);

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testAndroidBadMethods() {
        driver.get("https://www.wikipedia.org/");
        //String str1 = (String)driver.executeScript("client:client.getContextList(\"Nop\")");//javascript error
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle:windowHandles){
            System.out.println("Handle "+handle);
            driver.switchTo().window(handle);
        }
        driver.switchTo().window("NoSuchWindow"); //unknown error//NoSuchWindowException

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}