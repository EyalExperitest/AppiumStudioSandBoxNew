package main.java.issues;//package <set your test package>;

import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class ClickThreeTimes {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected IOSDriver driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.UDID, "00d064b580b7e36184819a9ce668f8c9f1d2413f");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testUntitled() {

        //Object result1 = driver.executeScript("client:client.launch(\"com.apple.calculator\", \"true\", \"true\")");
        WebElement el = driver.findElement(By.xpath("//*[@text='8']"));

        Object result3 = driver.executeScript("client:client.click(\"NATIVE\", \"xpath=//*[@text='9']\", \"0\", \"3\")");
        System.out.println("");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}