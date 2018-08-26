package main.java.testrail.parallel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

//package <set your test package>;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.drivers.ExAndroidDriver;
import main.java.drivers.ExIOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;

public class RunTwoDrivers {
  private static final int ITERATIONS = 10;
private String host = "localhost";
  private int port = 4723;
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "Run Two Drivers";
  protected ExIOSDriver iosDriver = null;
  protected ExAndroidDriver androidDriver = null;
  private ASIOSDriverFactory aSIOSDriverFactory =null;
  private ASAndroidDriverFactory aSAndroidDriverFactory=null;
  private URL url;
  
  @Before
  public void setUp() throws MalformedURLException, InterruptedException {

      host="192.168.2.40";
      String urlString = "http://" + host + ":" + port + "/wd/hub";
      System.out.println(urlString);
      url =new URL(urlString);
      DesiredCapabilities iosDC = new DesiredCapabilities();
      iosDC.setCapability("reportDirectory", reportDirectory);
      iosDC.setCapability("reportFormat", reportFormat);
      iosDC.setCapability("testName",testName+" iOS");
      iosDC.setCapability(MobileCapabilityType.UDID, "5d22bbe0e5529ccbf60b3626ed42ee636bc5f836");
      //iosDC.setCapability(MobileCapabilityType.APP, "http://192.168.2.72:8181/iOSApps/EriBank.ipa");
      iosDC.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
      iosDC.setCapability("instrumentApp", true);
      
      DesiredCapabilities androidDC = new DesiredCapabilities();
      androidDC.setCapability("reportDirectory", reportDirectory);
      androidDC.setCapability("reportFormat", reportFormat);
      androidDC.setCapability("testName", testName +" Android");
      androidDC.setCapability(MobileCapabilityType.UDID, "HT5AWBE05669");
      androidDC.setCapability(MobileCapabilityType.APP, "http://192.168.2.72:8181/AndroidApps/eribank.apk");
      androidDC.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
      androidDC.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
      androidDC.setCapability("instrumentApp", true);

      
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
      
      iosDriver= (ExIOSDriver) aSIOSDriverFactory.getDriver();
      androidDriver= (ExAndroidDriver) aSAndroidDriverFactory.getDriver();
      
      
      
      
      
      
      
      //iosDriver = new SeeTestIOSDriver<>(new URL("http://"+host+":"+port), iosDC);
  }
  
  @Test
  public void testRunTwoDrivers() throws InterruptedException {
	  
	  ASDriverRunnerIOS asDriverRunnerIOS = new ASDriverRunnerIOS(iosDriver,250);
	  ASDriverRunnerAndroid asDriverRunnerAndroid = new ASDriverRunnerAndroid(androidDriver,250);
	  
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