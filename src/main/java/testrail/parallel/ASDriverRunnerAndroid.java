package main.java.testrail.parallel;

import org.openqa.selenium.By;



import io.appium.java_client.android.AndroidDriver;

public class ASDriverRunnerAndroid implements Runnable {
	private AndroidDriver driver;
	private int iterations;

	public ASDriverRunnerAndroid(AndroidDriver driver,int iterations) {
		this.driver=driver;
		this.iterations=iterations;
	}
	public ASDriverRunnerAndroid(AndroidDriver driver) {
		this(driver,1);
	}
	@Override
	public void run() {

		for (int i = 0; i < iterations; i++) {
			//driver.getClient().startStepsGroup("Iteration "+i);
			try {
				driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
				driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
				driver.findElement(By.xpath("//*[@text='Login']")).click();
				driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
				driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("097856");
				driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Eyal "+i);
				driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("-100");
				driver.findElement(By.xpath("//*[@text='Select']")).click();
				driver.findElement(By.xpath("//*[@text='USA']")).click();
				driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
				driver.findElement(By.xpath("//*[@text='Yes']")).click();
				driver.findElement(By.xpath("//*[@text='Logout']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//driver.getClient().launch("com.experitest.ExperiBank/.LoginActivity", true,true);	
			}
			//driver.getClient().stopStepsGroup();

		}
		driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("Done");




	}

}
