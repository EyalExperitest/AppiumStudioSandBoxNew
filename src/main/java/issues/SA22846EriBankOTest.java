package main.java.issues;

//package <set your test package>;
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SA22846EriBankOTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA22846EriBankOTest";
//  private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2NzIxMzI4NTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.na315fDIXdpqkRVem7V1vbiHnST4I7Ee3vYMIpBb11A";
    private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTVRVd09UVXlPVEl3TWpreE53IiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MjQ4OTIwNzAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.icG-vUduTupsyGxjkOqK82j3yEa5f6311NZo6gHnmDM";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
//        dc.setCapability(MobileCapabilityType.UDID, "7dab622e4213cc503ccca3fa4a213645d7f9e5da");
        dc.setCapability(MobileCapabilityType.UDID, "b5e53830a00a854f3c820869a3feb2f38b4fc7d8");
        dc.setCapability(MobileCapabilityType.APP, "http://192.168.1.213:8090/guestAuth/repository/download/bt4/.lastSuccessful/eribanko.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBankO");
        //driver = new IOSDriver<>(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
        driver = new IOSDriver<>(new URL("http://mastercloud/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testEriBankOTest() {
        String pageSource1 = driver.getPageSource();
        SeeTestClient client = new SeeTestClient(driver);
        String currentApplicationName = client.getCurrentApplicationName();
        System.out.println("Current Application :"+currentApplicationName);
        System.out.println(pageSource1);
        driver.removeApp("com.experitest.ExperiBankO");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}