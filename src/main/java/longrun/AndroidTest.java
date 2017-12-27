package main.java.longrun;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by eyal.neumann on 10/30/2017.
 */
public class AndroidTest implements Runnable{
    private int index;

    public AndroidTest(int index){
        this.index=index;
    }

    public static void main(String[] args) throws MalformedURLException {

        (new AndroidTest(1)).run();
    }
    @Override
    public void run() {

        String reportDirectory = "reports";
        String reportFormat = "xml";
        String testName = "Basic Android Test "+this.index;
        AndroidDriver<AndroidElement> driver = null;

        DesiredCapabilities dc = new DesiredCapabilities();
        long time =System.currentTimeMillis();
        long spliter=time%1000;
        dc.setCapability("spliter",spliter);
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        int indexMod=index%2;
        dc.setCapability("username", "user"+indexMod);
        dc.setCapability("password", "Experitest2012");
        dc.setCapability(MobileCapabilityType.APP, "http://192.168.2.72:8181/AndroidApps/UICatalog.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.uicatalog");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        dc.setCapability("waitForDeviceTimeout", 600000);
        dc.setCapability("newSessionWaitTimeout", 600);

        //dc.setBrowserName(MobileBrowserType.CHROMIUM);

        try {

            //driver = new AndroidDriver(new URL("https://qacloud.experitest.com/wd/hub"), dc);
            driver = new AndroidDriver(new URL("http://192.168.2.150/wd/hub"), dc);
            //driver = new AndroidDriver(new URL("http://mastercloud.experitest.local/wd/hub"), dc);
            try {
                String pageSource1 = driver.getPageSource();
                System.out.println(pageSource1);

/*                driver.findElement(By.xpath("/*//*[@text='Buttons']")).click();
                new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*//*[@text='Long Click Button']")));
                driver.findElement(By.xpath("/*//*[@text='Long Click Button']")).click();
                driver.pressKeyCode(AndroidKeyCode.BACK);
                driver.findElement(By.xpath("/*//*[@text='Text Fields']")).click();
                new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*//*[@id='editText']")));

                driver.findElement(By.xpath("/*//*[@id='editText']")).sendKeys("Text 1");
                driver.pressKeyCode(AndroidKeyCode.BACK);

                driver.get("https://www.wikipedia.org/");
                String pageSource2 = driver.getPageSource();
                //System.out.println(pageSource2);
                driver.findElement(By.linkText("English")).click();
                driver.findElement(By.id("mw-mf-main-menu-button")).click();
                driver.findElement(By.linkText("Random")).click();
                new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("mw-mf-main-menu-button")));
                driver.findElement(By.id("mw-mf-main-menu-button")).click();
                driver.findElement(By.linkText("Random")).click();*/

            } catch (Exception e1) {
                String pageSource1 = driver.getPageSource();
                //System.out.println(pageSource1);
                e1.printStackTrace();
            }

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
