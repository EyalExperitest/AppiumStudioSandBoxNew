package main.java.examples;
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.util.logging.Level;
import java.net.MalformedURLException;

public class EriBankInstrumentedAndroid {
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "EriBank Instrumented on Android";
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
      driver.setLogLevel(Level.INFO);
  }
  
  @Test
  public void testEriBankInstrumentedAndroid() {
      driver.findElement(By.xpath("//*[@hint='Username']")).sendKeys("company");
      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Password']")));
      driver.findElement(By.xpath("//*[@hint='Password']")).sendKeys("company");
      driver.findElement(By.xpath("//*[@text='Login']")).click();
      driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
      driver.findElement(By.xpath("//*[@hint='Phone']")).sendKeys("09785645");
      driver.findElement(By.xpath("//*[@hint='Name']")).sendKeys("Eyal");
      driver.findElement(By.xpath("//*[@hint='Amount']")).sendKeys("-100");
      driver.findElement(By.xpath("//*[@text='Select']")).click();
      driver.findElement(By.xpath("//*[@text='China']")).click();
      driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
      driver.findElement(By.xpath("//*[@text='Yes']")).click();
      driver.findElement(By.xpath("//*[@text='Logout']")).click();
  }
  
  @After
  public void tearDown() {
      driver.quit();
  }
}