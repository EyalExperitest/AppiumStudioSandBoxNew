package main.java.export;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.SwipeElementDirection;//not in 5
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class ExperitestCommands001 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "ExperitestCommands001";
    protected AndroidDriver driver = null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "N2K7N16811000808");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudio\\apk\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testExperitestCommands001() throws InterruptedException {
        driver.findElement(By.xpath("//*[@hint='Username']")).sendKeys("company");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Password']")));
        driver.findElement(By.xpath("//*[@hint='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Make Payment']")));
        driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
        driver.findElement(By.xpath("//*[@hint='Phone']")).sendKeys("09785634");
        driver.findElement(By.xpath("//*[@hint='Name']")).sendKeys("Eyal");
        driver.findElement(By.xpath("//*[@hint='Amount']")).sendKeys("-100");
        driver.findElement(By.xpath("//*[@text='Select']")).click();
        System.out.println("swipeWhileNotFound");
        Thread.sleep(10000);
        //String str1 = (String)driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000,\"NATIVE\", \"xpath=//*[@text='Indonesia']\", 1000, 5, true)");
        //driver.findElement(By.xpath("//*[@text='Indonesia']")).click();
        //driver.findElement(By.xpath("//*[@text='Select']")).click();
        driver.executeScript("client:client.elementListSelect(\"id=countryList\", \"text=South Africa\",1, true)");
        driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
        driver.findElement(By.xpath("//*[@text='Yes']")).click();
        driver.findElement(By.xpath("//*[@text='Logout']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}