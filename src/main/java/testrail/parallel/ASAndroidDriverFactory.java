package main.java.testrail.parallel;

import java.net.URL;

import main.java.drivers.ExAndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

/*import com.experitest.appium.SeeTestAndroidDriver;
import com.experitest.appium.SeeTestAndroidElement;*/

public class ASAndroidDriverFactory implements Runnable {
	private ExAndroidDriver driver=null;
	private URL url=null;
	private DesiredCapabilities dc = null;


	public ASAndroidDriverFactory(URL url,DesiredCapabilities dc) {
		this.dc=dc;
		this.url=url;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.setDriver(new ExAndroidDriver(this.url, this.dc));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ExAndroidDriver getDriver() {
		return driver;
	}

	private void setDriver(ExAndroidDriver driver) {
		this.driver = driver;
	}

}
