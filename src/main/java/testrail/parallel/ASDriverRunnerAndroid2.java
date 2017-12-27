package main.java.testrail.parallel;

import io.appium.java_client.android.AndroidDriver;



public class ASDriverRunnerAndroid2 implements Runnable {
	private AndroidDriver driver;
	private int iterations;

	public ASDriverRunnerAndroid2(AndroidDriver driver,int iterations) {
		this.driver=driver;
		this.iterations=iterations;
	}
	public ASDriverRunnerAndroid2(AndroidDriver driver) {
		this(driver,1);
	}
	@Override
	public void run() {

		for (int i = 0; i < iterations; i++) {
			//driver.getClient().startStepsGroup("Iteration "+i);
			try {
				driver.installApp("com.experitest.ExperiBank/.LoginActivity");
				//driver.startActivity("com.experitest.ExperiBank", ".LoginActivity");
				driver.getPageSource();
				driver.removeApp("com.experitest.ExperiBank");
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			//driver.getClient().stopStepsGroup();

		}




	}

}
