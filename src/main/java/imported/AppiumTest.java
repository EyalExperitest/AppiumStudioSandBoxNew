package main.java.imported;
// Insert your package here
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumTest {
	static {
		System.getProperties().setProperty("javax.net.ssl.trustStore","C:\\Users\\eyal.neumann\\Documents\\keys3\\truststore.jks");
		System.getProperties().setProperty("javax.net.ssl.trustStorePassword","");

	}
	AppiumDriver driver;

	@Before
	public void setUp() throws MalformedURLException {
		String accessKey ="eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVd05qUXpNakUwTlRJeU1BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MjQzOTAyNzMsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.zLodHntGVIa3OsCP9NoSnl9H-13Urygy-_HpiN5a10w";
		String user ="admin";
		String password ="Experitest2012";

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("reportDirectory", "reports");
		dc.setCapability("reportFormat", "xml");
		dc.setCapability("testName", "AppiumTest 1");
		dc.setCapability(MobileCapabilityType.UDID, "ce051605686c683b03");
		dc.setCapability("user", "admin");
		// In case your user is assigned to a single project leave empty, otherwise please specify the project name
		//dc.setCapability("projectName", "");
		dc.setCapability("password", "Experitest2012");
		//dc.setCapability("accessKey", accessKey);
		//dc.setCapability(MobileCapabilityType.APP, <PATH TO APPLICATION> ); // If you wish to continue with the app running on the device, comment this line
		driver = new AndroidDriver(new URL("https://eyalneumann.experitest.local:8091/wd/hub"), dc);
		//driver = new AndroidDriver(new URL("https://:"+accessKey+"@"+"eyalneumann.experitest.local"+":"+8091+"/wd/hub"), dc);
		//driver = new AndroidDriver(new URL("http://"+user+":"+password+"@"+"eyalneumann.experitest.local"+":"+8091+"/wd/hub"), dc);
	}

	@Test
	public void testAppiumTest(){
		String s= driver.getPageSource();
		System.out.println(s);
        s= driver.getPageSource();
        System.out.println(s);
        s= driver.getPageSource();
        System.out.println(s);
        s= driver.getPageSource();
        System.out.println(s);
        s= driver.getPageSource();
        System.out.println(s);
        s= driver.getPageSource();
        System.out.println(s);
        s= driver.getPageSource();
        System.out.println(s);
        s= driver.getPageSource();
        System.out.println(s);
        s= driver.getPageSource();
        System.out.println(s);
	}

	@After
	public void tearDown(){
		driver.quit();
	}

}