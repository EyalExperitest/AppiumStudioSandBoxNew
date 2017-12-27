package main.java.testrail.parallel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

//package <set your test package>;
//import com.experitest.appium.*;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class RunTwoDrivers2 {
  private static final int ITERATIONS = 10;
private String host = "localhost";
  private int port = 8889;
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "Run Two Drivers";
  protected IOSDriver iosDriver = null;
  protected AndroidDriver androidDriver = null;
  private ASIOSDriverFactory aSIOSDriverFactory =null;
  private ASAndroidDriverFactory aSAndroidDriverFactory=null;
  private URL url;
  
  @Before
  public void setUp() throws MalformedURLException, InterruptedException {
	  
      url =new URL("http://"+host+":"+port);

	  
	  
      DesiredCapabilities iosDC = new DesiredCapabilities();
      iosDC.setCapability("reportDirectory", reportDirectory);
      iosDC.setCapability("reportFormat", reportFormat);
      iosDC.setCapability("testName", testName+" iOS");
      iosDC.setCapability(MobileCapabilityType.UDID, "8c5a391c5be2c4a140a9246486768736e062eb59");

      
      DesiredCapabilities androidDC = new DesiredCapabilities();
      androidDC.setCapability("reportDirectory", reportDirectory);
      androidDC.setCapability("reportFormat", reportFormat);
      androidDC.setCapability("testName", testName +"Android");
      androidDC.setCapability(MobileCapabilityType.UDID, "FA549YJ00800");

      
      aSIOSDriverFactory =new ASIOSDriverFactory(url, iosDC);
      aSAndroidDriverFactory =new ASAndroidDriverFactory(url, androidDC);
      
      
      Thread aSIOSDriverFactoryThread =new Thread (aSIOSDriverFactory);
      Thread aSAndroidDriverFactoryThread = new Thread(aSAndroidDriverFactory);
      aSIOSDriverFactoryThread.setName("Initiating iOS Driver");
      aSAndroidDriverFactoryThread.setName("Initiating Android Driver");
      
      aSIOSDriverFactoryThread.start();
      aSAndroidDriverFactoryThread.start();
      
      aSIOSDriverFactoryThread.join();
      aSAndroidDriverFactoryThread.join();
      
      iosDriver=aSIOSDriverFactory.getDriver();
      androidDriver=aSAndroidDriverFactory.getDriver();
      
      
      
      
      
      
      
      //iosDriver = new SeeTestIOSDriver<>(new URL("http://"+host+":"+port), iosDC);
  }
  
  @Test
  public void testRunTwoDrivers() throws InterruptedException {
	  
	  ASDriverRunnerIOS2 asDriverRunnerIOS = new ASDriverRunnerIOS2(iosDriver,20);
	  ASDriverRunnerAndroid2 asDriverRunnerAndroid = new ASDriverRunnerAndroid2(androidDriver,20);
	  
	  Thread asDriverRunnerIOSThread= new Thread(asDriverRunnerIOS);
	  Thread asDriverRunnerAndroidThread =new Thread(asDriverRunnerAndroid);
  
	  asDriverRunnerIOSThread.setName("IOS Driver");
	  asDriverRunnerAndroidThread.setName("Android Driver");
	  
	  asDriverRunnerIOSThread.start();
	  asDriverRunnerAndroidThread.start();
	  
	  
	  asDriverRunnerIOSThread.join(); 
	  asDriverRunnerAndroidThread.join();
	  
	  
	  
	  
  }
  
  
  @After
  public void tearDown() {
	  iosDriver.quit();
	  androidDriver.quit();
  }
}