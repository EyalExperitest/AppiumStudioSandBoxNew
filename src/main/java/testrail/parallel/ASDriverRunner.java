package main.java.testrail.parallel;


import io.appium.java_client.android.AndroidDriver;

public class ASDriverRunner implements Runnable {
	private AndroidDriver driver;

	public ASDriverRunner(AndroidDriver driver) {
		this.driver=driver;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
