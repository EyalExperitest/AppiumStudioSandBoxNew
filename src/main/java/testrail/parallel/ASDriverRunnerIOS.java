package main.java.testrail.parallel;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;




public class ASDriverRunnerIOS implements Runnable {
	private IOSDriver driver;
	private int iterations;

	public ASDriverRunnerIOS(IOSDriver driver, int iterations) {
		this.driver=driver;
		this.iterations=iterations;
	}
	public ASDriverRunnerIOS(IOSDriver driver) {
		this(driver,1);
	}

	@Override
	public void run() {
		for (int i = 0; i < iterations; i++) {
			//driver.getClient().startStepsGroup("Iteration "+i);
			try {
				driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
				driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
				driver.findElement(By.xpath("//*[@accessibilityLabel='loginButton']")).click();
				driver.findElement(By.xpath("//*[@accessibilityLabel='makePaymentButton']")).click();
				driver.findElement(By.xpath("//*[@placeholder='Phone']")).sendKeys("09785643");
				driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("Eyal "+i);
				driver.findElement(By.xpath("//*[@placeholder='Amount']")).sendKeys("-100");
				driver.findElement(By.xpath("//*[@accessibilityLabel='countryButton']")).click();
				driver.findElement(By.xpath("//*[@accessibilityLabel='USA']")).click();
				driver.findElement(By.xpath("//*[@accessibilityLabel='sendPaymentButton']")).click();
				driver.findElement(By.xpath("//*[@text='Yes']")).click();
				driver.findElement(By.xpath("//*[@accessibilityLabel='logoutButton']")).click();
				driver.findElement(By.xpath("//*[@placeholder='Username']")).click();
				driver.findElement(By.xpath("//*[@class='UIButton']")).click();
				driver.findElement(By.xpath("//*[@placeholder='Password']")).click();
				driver.findElement(By.xpath("//*[@class='UIButton']")).click();
				driver.findElement(By.xpath("//*[@class='UIInputSetContainerView' and ./*[./*[@class='UIKBInputBackdropView']]]")).click();
			} catch (Exception e) {
				//driver.getClient().launch("com.experitest.ExperiBank", true,true);	

			}
			//driver.getClient().stopStepsGroup();
		}
		driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("Done");

	}

}
