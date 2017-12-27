package main.java.examples;

//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class EriBankInstrumentedIOS {
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "EriBankInstrumented";
  protected IOSDriver driver = null;
  
  @Before
  public void setUp() throws MalformedURLException {
      DesiredCapabilities dc = new DesiredCapabilities();
      dc.setCapability("reportDirectory", reportDirectory);
      dc.setCapability("reportFormat", reportFormat);
      dc.setCapability("testName", testName);
      dc.setCapability(MobileCapabilityType.UDID, "74ee108a3e08509f1e8056aa1623d6a1a01dcb1f");
      dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
      dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "cloud:com.experitest.ExperiBank");
      dc.setCapability("instrumentApp", true);
      driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), dc);
  }
  
  @Test
  public void testEriBankInstrumented() {
      driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Password']")));
      driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
      driver.findElement(By.xpath("//*[@accessibilityLabel='loginButton']")).click();
      driver.findElement(By.xpath("//*[@accessibilityLabel='makePaymentButton']")).click();
      driver.findElement(By.xpath("//*[@placeholder='Phone']")).sendKeys("09785634");
      driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("Eyal");
      driver.findElement(By.xpath("//*[@placeholder='Amount']")).sendKeys("-100");
      driver.findElement(By.xpath("//*[@accessibilityLabel='countryButton']")).click();
      driver.findElement(By.xpath("//*[@accessibilityLabel='USA']")).click();
      driver.findElement(By.xpath("//*[@accessibilityLabel='sendPaymentButton']")).click();
      driver.findElement(By.xpath("//*[@accessibilityLabel='Yes' and @class='_UIAlertControllerActionView']")).click();
      driver.findElement(By.xpath("//*[@accessibilityLabel='logoutButton']")).click();
  }
  
  @After
  public void tearDown() {
      driver.quit();
  }
}