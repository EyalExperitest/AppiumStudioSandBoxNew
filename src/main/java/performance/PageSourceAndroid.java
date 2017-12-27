package main.java.performance;//package <set your test package>;
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

public class PageSourceAndroid {
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
    public void testPageSource() throws InterruptedException {

//        driver.unlockDevice();
//
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
        driver.findElement(By.xpath("//*[@text='Select']")).click();
        //driver.swipeWhileNotFound(By.xpath("xpath=//*[@text='Argentina']"),730, SwipeElementDirection.DOWN,750,0,4,false);
        driver.findElement(By.xpath("//*[@text='USA']")).click();
        driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
        driver.findElement(By.xpath("xpath=//*[@text='Cancel']")).click();
        driver.findElement(By.xpath("//*[@text='Logout']")).click();

        driver.get("http://www.wikipedia.org");
        driver.context("WEB");
        //driver.sleep(10000);
        Thread.sleep(10000);
        driver.findElement(By.id("searchInput")).sendKeys("expert");
        //driver.getClient().sendText("{ENTER}");
        //driver.swipe(SwipeElementDirection.DOWN,206,1225);


    }

    @After
    public void tearDown() {
        driver.quit();
    }
}