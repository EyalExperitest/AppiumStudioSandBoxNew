package main.java.issues.sa21461;

import com.experitest.appium.SeeTestClient;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
//import org.slf4j.impl.Log4jLoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * grid-tests
 * Created by tom.ben-simhon on 1/11/2018.
 */
public class TestParallel {
    //protected Logger log = new Log4jLoggerFactory().getLogger(this.getClass().getName());
    AppiumDriver driver;
    SeeTestClient client;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability("accessKey", <> );

        driver = new AndroidDriver(new URL("https://cloud.seetest.io/wd/hub"), dc);
        client = new SeeTestClient(driver);
        client.setShowPassImageInReport(false);
        client.setProperty("report:name", client.getDeviceProperty("device.name"));
    }

    @Test
    public void testParallel()  {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        list.parallelStream()
                .forEach(number ->
                {
                    if (number % 2 == 0) {
                        try {
                            if (driver.findElement(By.xpath("//*")).isDisplayed()) {
                                //log.info("found valid element");
                            }
                        }
                        catch (Exception e) {
                            //log.error("FAILED TO FIND VALID ELEMENT");
                        }

                    } else {
                        try {
                            if (driver.findElement(By.xpath("//*[@text='invalid']")).isDisplayed()) {
                               // log.error("FOUND INVALID ELEMENT");
                            }
                        } catch (Exception e) {
                           // log.info("didn't find invalid element");
                        }
                    }
                });

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            System.out.println("Report : " + driver.getCapabilities().getCapability("reportUrl"));
            driver.quit();
        }
    }


}
