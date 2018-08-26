package main.java.longrun;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.net.MalformedURLException;



/**
 * Created by eyal.neumann on 10/29/2017.
 */
public class IOSTest implements Runnable {
    private int index;
    public static void main(String[] args) throws MalformedURLException {
        (new IOSTest(0)).run();



    }
    public IOSTest(int index){
        this.index=index;
    }
    public  void run()  {
        String reportDirectory = "reports";
        String reportFormat = "xml";
        String testName = "Basic IOS Test "+index;
        IOSDriver<IOSElement> driver = null;

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
        dc.setCapability(MobileCapabilityType.APP, "http://192.168.2.72:8181/iOSApps/UICatalog.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.UICatalog");
        dc.setCapability("waitForDeviceTimeout", 600000);
        dc.setCapability("newSessionWaitTimeout", 600);
        //dc.setBrowserName(MobileBrowserType.SAFARI);

        try {
            //driver = new IOSDriver(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
            //driver = new IOSDriver(new URL("http://192.168.2.150/wd/hub"), dc);
            driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);

            //driver = new IOSDriver(new URL("http://mastercloud.experitest.local/wd/hub"), dc);
            try {
                String pageSource1 = driver.getPageSource();
                System.out.println(pageSource1);

                driver.findElement(By.xpath("//*[@accessibilityLabel='Buttons']")).click();
                driver.findElement(By.xpath("(//*[@text='Buttons']/*[@text='Back'])[1]")).click();
                driver.findElement(By.xpath("//*[@accessibilityLabel='TextFields']")).click();
                driver.findElement(By.xpath("(//*[@class='UIATable']/*/*[@placeholder='<enter text>'])[1]")).sendKeys("Test " + index);
                driver.findElement(By.xpath("(//*[@text='TextFields']/*[@text='Back'])[1]")).click();

                driver.get("https://www.wikipedia.org/");
                String pageSource2 = driver.getPageSource();
                //System.out.println(pageSource2);
                driver.findElement(By.linkText("English")).click();
                driver.findElement(By.id("mw-mf-main-menu-button")).click();
                driver.findElement(By.linkText("Random")).click();
                new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("mw-mf-main-menu-button")));
                driver.findElement(By.id("mw-mf-main-menu-button")).click();
                driver.findElement(By.linkText("Random")).click();


            } catch (Exception e1) {
                e1.printStackTrace();
            }
            driver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



    }
}

