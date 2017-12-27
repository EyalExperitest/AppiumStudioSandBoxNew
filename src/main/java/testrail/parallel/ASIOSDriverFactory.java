package main.java.testrail.parallel;

import java.net.URL;

import main.java.drivers.ExIOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;


public class ASIOSDriverFactory implements Runnable {
	private ExIOSDriver driver=null;
	private URL url=null;
	private DesiredCapabilities dc = null;


	public ASIOSDriverFactory(URL url,DesiredCapabilities dc) {
		this.dc=dc;
		this.url=url;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.setDriver(new ExIOSDriver(this.url, this.dc));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ExIOSDriver getDriver() {
		return driver;
	}

	private void setDriver(ExIOSDriver driver) {
		this.driver = driver;
	}

}
