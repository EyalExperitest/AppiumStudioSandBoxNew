package main.java.testrail.exported;

/**
 * Created by eyal.neumann on 12/21/2017.
 */
//package <set your test package>;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.drivers.ExIOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class LuanchWikipediaIOS {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "LuanchWikipediaIOS";
    protected ExIOSDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "8a81b1e32471f53ac99a741bcc14bd6b84991fff");
        dc.setBrowserName(MobileBrowserType.SAFARI);
        driver = new ExIOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testLuanchWikipediaIOS() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        String pageSource1 = driver.getPageSource();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}