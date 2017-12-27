package main.java.testrail.parallel;

import io.appium.java_client.ios.IOSDriver;




public class ASDriverRunnerIOS2 implements Runnable {
	private IOSDriver driver;
	private int iterations;

	public ASDriverRunnerIOS2(IOSDriver driver, int iterations) {
		this.driver=driver;
		this.iterations=iterations;
	}
	public ASDriverRunnerIOS2(IOSDriver driver) {
		this(driver,1);
	}

	@Override
	public void run() {
		for (int i = 0; i < iterations; i++) {
			//driver.getClient().startStepsGroup("Iteration "+i);
			try {
		        driver.installApp("com.experitest.ExperiBank");
		        //driver.launchApp("com.experitest.ExperiBank");
		        driver.launchApp();
		        driver.getPageSource();
		        driver.removeApp("com.experitest.ExperiBank");
			} catch (Exception e) {

			}
			//driver.getClient().stopStepsGroup();
		}

	}

}
