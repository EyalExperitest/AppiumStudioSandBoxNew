package main.java.clienttests;

//package <set your test package>;
import com.google.gson.Gson;
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
import java.util.Map;

public class GetDeviceName {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "getDeviceName";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "ce051605686c683b03");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testgetDeviceName() {
        Object jsonObject = driver.executeScript("client:client.getDeviceProperty(\"device.name\");");
        Map map = new Gson().fromJson(jsonObject.toString(), Map.class);
        System.out.println(jsonObject.toString());
        System.out.println(map.get("text"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}