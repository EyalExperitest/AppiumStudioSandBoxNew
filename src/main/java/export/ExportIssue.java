
package main.java.export;
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class ExportIssue {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "ExportIssue";
    protected IOSDriver driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("user", "eyal");
        dc.setCapability("password", "");
        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability("projectName", "");
        dc.setCapability(MobileCapabilityType.UDID, "0e1f7f2fcdc5b47b1c76d07bac240d09a99fd68d");
        driver = new IOSDriver(new URL("http://qacloud.experitest.com:80/wd/hub"), dc);
    }

    @Test
    public void testExportIssue() {
        String str1 = (String)driver.executeScript("client:client.installWithCustomKeystore(\"cloud:com.CameraFlash/.MainActivity\", true, false, \"\", \"\", \"\", \"\")");
        String str2 = (String)driver.executeScript("client:client.getContextList()");
        driver.executeScript("client:client.receiveIncomingCall(\"09876876978\", 10)");
        driver.executeScript("client:client.setDevice(\"ios_app:navot iPhone7+\")");
        driver.executeScript("client:client.receiveIncomingSMS(\"7867867\", \"123\")");
        driver.executeScript("client:client.drag(\" \", 0, 0)");
        String str3 = (String)driver.executeScript("client:client.swipeWhileNotFound(\"Up\", 0, 2000, \" \", 1000, 5, true)");
        driver.executeScript("client:client.deviceAction(\"Home\")");
        String str4 = (String)driver.executeScript("client:client.getContextList()");
        driver.executeScript("client:client.elementListSelect(\"\", \"\", true)");
        driver.installApp("");
        driver.executeScript("client:client.launch(\"\")");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}