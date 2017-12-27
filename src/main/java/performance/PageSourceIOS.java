package main.java.performance;//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class PageSourceIOS {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "PageSourceAndroid";
    private String accessKey = "eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9UZzFNVEl3TXprd05BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MTc2NDc2NTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NJkrA94cO5ONFXFnZid06BtEcCljWHEeYkdRQWLUOcM";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "b5e53830a00a854f3c820869a3feb2f38b4fc7d8");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\EriBank.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        dc.setCapability("instrumentApp", true);
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);

    }



    @Test
    public void testnew(){

        driver.findElement(By.xpath("//*[@accessibilityLabel='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@accessibilityLabel='Password']")).sendKeys("company");
        driver.findElement(By.xpath("xpath=//*[@text='Login']")).click();
        driver.findElement(By.xpath("xpath=//*[@text='Make Payment']")).click();
        driver.findElement(By.xpath("xpath=//*[@text='Select']")).click();
        //driver.swipeWhileNotFound(By.xpath("//*[@accessibilityLabel='Colombia']"), 626, SwipeElementDirection.DOWN, 721, 0, 3, false);
        driver.findElement(By.xpath("//*[@accessibilityLabel='USA']")).click();
        driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='Cancel']")).click();
        driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='Logout']")).click();

        driver.get("http://www.wikipedia.org");
        driver.findElement(By.id("searchInput")).sendKeys("expert");
        driver.findElement(By.xpath("xpath=//*[@nodeName='BUTTON' and ./parent::*[@nodeName='FIELDSET']]")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
