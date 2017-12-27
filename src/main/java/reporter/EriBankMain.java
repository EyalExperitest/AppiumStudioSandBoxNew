package main.java.reporter;

import com.experitest.manager.api.ManagerPublisher;
import com.experitest.manager.client.PManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.tools.URLReader;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by eyal.neumann on 8/1/2017.
 */
public class EriBankMain {
    public static void main(String[] args) throws InterruptedException, IOException {
        boolean successFlag = true;


        String reportDirectory = "reports";
        String reportFormat = "xml";
        String testNameString = "AndroidReporterTest";
        AndroidDriver driver = null;
        Map<String, ?> dcMap;
        File reportsMainFolder = null;
        ManagerPublisher managerPublisher = null;

        System.setProperty("manager.url", "localhost:9090");
        System.setProperty("manager.user", "admin");
        System.setProperty("manager.password", "Experitest2012");
        System.setProperty("manager.project", "Default");

        managerPublisher = PManager.createManagerPublisher("EriBank_Main_Test");

        DesiredCapabilities dc = new DesiredCapabilities();
        reportsMainFolder = new File("reports");
        dc.setCapability("reportDirectory", reportsMainFolder.getAbsolutePath());
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testNameString);
        dc.setCapability(MobileCapabilityType.UDID, "LGH850ab3befa7");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        dcMap = dc.asMap();
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);

        try {
            dcMap = driver.getCapabilities().asMap();
            Set<String> keySet = dcMap.keySet();
            Map<String, String> propertiesMap = new HashMap<String, String>();
            for (String key : keySet) {
                String stringValue = dcMap.get(key).toString();
                System.out.println(key + " : " + stringValue);
                propertiesMap.put(key, stringValue);
            }
            String sessionsStringFromURL = URLReader.getStringFromURL("http://localhost:4723/wd/hub/sessions");
            propertiesMap.put("Sessions", sessionsStringFromURL);
            String statusStringFromURL = URLReader.getStringFromURL("http://localhost:4723/wd/hub/status");
            propertiesMap.put("Server Status", statusStringFromURL);

            driver.findElement(By.xpath("//*[@hint='Username']")).sendKeys("company");
            driver.findElement(By.xpath("//*[@hint='Password']")).sendKeys("company");
            driver.findElement(By.xpath("//*[@text='Login']")).click();
            driver.context("WEBVIEW_1");
            String balance = driver.findElement(By.xpath("/*//*[@nodeName='H1']")).getText().replace("Your balance is: ", "");
            System.out.println(balance);
            propertiesMap.put("balance", balance);


            driver.context("NATIVE_APP_INSTRUMENTED");
            driver.findElement(By.xpath("//*[@text='Make Payment']")).click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@hint='Phone']")));
            driver.findElement(By.xpath("//*[@hint='Phone']")).sendKeys("09785645");
            driver.findElement(By.xpath("//*[@hint='Name']")).sendKeys("Eyal");
            driver.findElement(By.xpath("//*[@hint='Amount']")).sendKeys("-100");
            driver.findElement(By.xpath("//*[@text='Select']")).click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='USA']")));
            driver.findElement(By.xpath("//*[@text='USA']")).click();
            driver.findElement(By.xpath("//*[@text='Send Payment']")).click();
            driver.findElement(By.xpath("//*[@text='Yes']")).click();
            driver.findElement(By.xpath("//*[@text='Logout']")).click();


            managerPublisher.addProperties(propertiesMap);
        } catch (Exception e) {
            e.printStackTrace();
            successFlag = false;
        }


        managerPublisher.finishTest(successFlag);
        managerPublisher.waitForPublish();


    }

}
