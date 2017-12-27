package main.java.export;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class EriBankTestExport {
    static {
        System.getProperties().setProperty("javax.net.ssl.trustStore","C:\\Users\\eyal.neumann\\Documents\\keys3\\truststore.jks");
        System.getProperties().setProperty("javax.net.ssl.trustStorePassword","");

    }
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "EriBankTestExport";
  //private String accessKey = "eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVd05qUXpNakUwTlRJeU1BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MjQxMTc3NDAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.f64n8YmKTCFp88ErjYeEoBV8jUMrADHVXhJ3foeRBcc";
    private String accessKey = "eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVd05qUXpNakUwTlRJeU1BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MjQzODAwNzEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.FJiZAWOBl-_D8pQCkash3Z0fqqaPZGaHkBBy9CYZK9M";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
/*        System.getProperties().setProperty("javax.net.ssl.trustStore","C:\\Users\\eyal.neumann\\Documents\\keys3\\truststore.jks");
        System.getProperties().setProperty("javax.net.ssl.trustStorePassword","");*/


        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        //dc.setCapability("accessKey", accessKey);
        dc.setCapability("user", "admin");
        dc.setCapability("password", "Experitest2012");

        dc.setCapability(MobileCapabilityType.UDID, "f759ec5d8343175b2c68f856c9c47559aa1fc0fc");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        //dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "cloud:com.experitest.ExperiBank");
        dc.setCapability("instrumentApp", true);

        driver = new IOSDriver<IOSElement>(new URL("https://eyalneumann.experitest.local:8091/wd/hub"), dc);
    }

    @Test
    public void testEriBankTestExport() {
        System.out.println(driver.getPageSource());
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Password']")));
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@accessibilityLabel='loginButton']")).click();
        driver.findElement(By.xpath("//*[@accessibilityLabel='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Phone']")).sendKeys("09787653543");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Name']")));
        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("Eyal");
        driver.findElement(By.xpath("//*[@placeholder='Amount']")).sendKeys("100");
        driver.findElement(By.xpath("//*[@accessibilityLabel='countryButton']")).click();
        driver.findElement(By.xpath("//*[@accessibilityLabel='Greece']")).click();
        driver.findElement(By.xpath("//*[@accessibilityLabel='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='Yes']")).click();
        driver.findElement(By.xpath("//*[@accessibilityLabel='logoutButton']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}