package main.java.export;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class ExperitestCommands003 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "ExperitestCommands003";
    protected AndroidDriver driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "N2K7N16811000808");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testExperitestCommands003() {
        //driver.removeApp("com.experitest.ExperiBank");
        //String str1 = (String)driver.executeScript("client:client.installWithCustomKeystore(\"C:\\MobileApps\\apk\\eribank.apk\", true, false, \"C:\\Users\\eyal.neumann\\Downloads\\keystores\\experitest.keystore\", \"123456\", \"cool\", \"654321\")");
        //System.out.println(str1);

        //driver.startActivity("com.experitest.ExperiBank", ".LoginActivity");
        String pageSource1 = driver.getPageSource();
        System.out.println(pageSource1);

        String str2 = (String)driver.executeScript("client:client.getContextList()");
        System.out.println(str2);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}