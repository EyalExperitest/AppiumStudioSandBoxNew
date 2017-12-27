package main.java.issues;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.tools.URLReader;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.MalformedURLException;

public class SA18154 {
	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "SA18154";
	protected AndroidDriver driver = null;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("reportDirectory", reportDirectory);
		dc.setCapability("reportFormat", reportFormat);
		dc.setCapability("testName", testName);
		dc.setCapability(MobileCapabilityType.UDID, "N2K7N16811000808");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
	}

	@Test
	public void testSA18154() throws MalformedURLException, IOException {
		String urlString ="http://localhost:4723/wd/hub/sessions";
		String stringFromURL = URLReader.getStringFromURL(urlString);
		System.out.println(stringFromURL);
		driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
		driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
		System.out.println("Stoping commands");
/*		try {
			Thread.sleep(60*1000);
			System.out.println("After 1 minute :");
			stringFromURL = URLReader.getStringFromURL(urlString);
			System.out.println(stringFromURL);
			Thread.sleep(60*1000);
			System.out.println("After 2 minutes :");
			stringFromURL = URLReader.getStringFromURL(urlString);
			System.out.println(stringFromURL);
			Thread.sleep(60*1000);
			System.out.println("After 3 minutes :");
			stringFromURL = URLReader.getStringFromURL(urlString);
			System.out.println(stringFromURL);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String currentStringFromURL=stringFromURL;
		long t0=System.currentTimeMillis();
		while (currentStringFromURL.equals(stringFromURL)){
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			currentStringFromURL= URLReader.getStringFromURL(urlString);
			
		}
		long t1=System.currentTimeMillis();
		System.out.println(currentStringFromURL);
		long totalSeconds =(t1-t0)/1000;
		long seconds =totalSeconds%60;
		long minutes = totalSeconds/60;
		System.out.println("Time : ["+minutes+":"+seconds+"]");
		
		
		
		
		try {
			driver.findElement(By.xpath("//*[@text='Login']")).click();
			driver.context("NATIVE_APP");
			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='makePaymentButton']")));
			driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
			fail("Session should have ended");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		try {
			driver.quit();
			fail("Session should have ended");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}