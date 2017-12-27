package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SA18661 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA18661";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "17b3dcc17d43");
        //dc.setBrowserName(MobileBrowserType.CHROMIUM);
        dc.setBrowserName(MobileBrowserType.CHROME);
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA18661() throws InterruptedException {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        String pageSource0 = driver.getPageSource();
        System.out.println("Wikipedia :"+pageSource0);
        driver.pressKeyCode(AndroidKeyCode.HOME);
        //driver.startActivity("com.experitest.ExperiBank", ".LoginActivity");
        Thread.sleep(10000);
        driver.context("NATIVE_APP");

        String pageSource1 = driver.getPageSource();
        System.out.println("Eribank :"+pageSource1);
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Login']")).click();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}