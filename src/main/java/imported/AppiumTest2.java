package main.java.imported;// Insert your package here
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import main.java.drivers.ExIOSDriver;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;

import javax.net.ssl.*;

public class AppiumTest2 {

	ExIOSDriver driver;
	static {
		System.getProperties().setProperty("javax.net.ssl.trustStore","C:\\Users\\eyal.neumann\\Documents\\keys3\\truststore.jks");
		//System.getProperties().setProperty("javax.net.ssl.trustStore","C:\\Users\\eyal.neumann\\Documents\\MacKeys\\trusstore.jks");
		System.getProperties().setProperty("javax.net.ssl.trustStorePassword","");
		//ignoreCertificateIssues();
	}

	private static void ignoreCertificateIssues() {
		TrustManager[] trustAllCerts = new TrustManager[] {
				new X509TrustManager() {
					public X509Certificate[] getAcceptedIssuers()
					{ return null; }
					public void checkClientTrusted(X509Certificate[] certs, String authType) { }
					public void checkServerTrusted(X509Certificate[] certs, String authType) { }
				}
		};
		SSLContext sc = null;
		try {
			sc = SSLContext.getInstance("SSL");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session)
			{ return true; }
		};
// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	}

	@Before
	public void setUp() throws MalformedURLException {
		String accessKey ="eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVd05qUXpNakUwTlRJeU1BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MjM2OTgwNzAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.BltrshQlLHTt8jb8Yqno7QuIAQgbEKG3Jrb1maw1t-Q";
		String user ="admin";
		String password ="Experitest2012";
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("reportDirectory", "reports");
		dc.setCapability("reportFormat", "xml");
		dc.setCapability("testName", "AppiumTest 2");
		dc.setCapability(MobileCapabilityType.UDID, "1d3e36fba9e9d23918ca4f4b8760d0c10ce24b3b");
		dc.setCapability("user", user);
		// In case your user is assigned to a single project leave empty, otherwise please specify the project name
		//dc.setCapability("projectName", "");
		dc.setCapability("password",password);
		//dc.setCapability(MobileCapabilityType.APP, <PATH TO APPLICATION> ); // If you wish to continue with the app running on the device, comment this line
		driver = new ExIOSDriver(new URL("https://eyalneumann.experitest.local"+":"+8091+"/wd/hub"), dc);
		//driver = new ExIOSDriver(new URL("https://192.168.2.60"+":"+8091+"/wd/hub"), dc);
		//driver = new ExIOSDriver(new URL("https://qas-mac-mini.experitest.local"+":"+8091+"/wd/hub"), dc);
		//driver = new IOSDriver(new URL("http://:"+accessKey+"@"+"eyalneumann.experitest.local"+":"+8091+"/wd/hub"), dc);
	}

	@Test
	public void testAppiumTest2(){
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