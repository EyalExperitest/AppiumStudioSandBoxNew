package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA25739_GetPageSourceAfterExecuteScriptIOS {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA25739_GetPageSourceAfterExecuteScriptIOS";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "36f0a41a8fca9263c1f977b915dcb5668a0b83fc");
        dc.setBrowserName(MobileBrowserType.SAFARI);
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testSA25739_GetPageSourceAfterExecuteScriptIOS() {
        driver.get("http://192.168.4.85:8060/html-tests/RegressionHibridApplication/iFramePage.html");
        System.out.println(driver.executeScript("result = document.getElementsByTagName(\"p\").length"));
        System.out.println(driver.getPageSource());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}