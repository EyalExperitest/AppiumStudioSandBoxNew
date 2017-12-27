package main.java.reporter;

import com.experitest.manager.api.ManagerPublisher;
import com.experitest.manager.api.ManagerPublisherFactory;
import com.experitest.manager.api.TestSession;
import com.experitest.manager.api.TestSessionFactory;
import com.experitest.manager.client.PManager;
import com.experitest.manager.junit.ManagerTestRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.tools.URLReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RunWith(ManagerTestRunner.class)
public class AndroidReporterTestGrid {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testNameString = "AndroidReporterTest";
    protected AndroidDriver driver = null;
    protected Map<String, ?> dcMap;
    protected File reportsMainFolder = null;
    //private ManagerPublisher managerPublisher = null;


    static {
/*      System.setProperty("manager.url", "localhost:9090");
        System.setProperty("manager.user", "admin");
        System.setProperty("manager.password", "Experitest2012");
        System.setProperty("manager.project", "Default");*/
    }
    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() throws MalformedURLException {
        //managerPublisher = PManager.createManagerPublisher(testName.getMethodName());
        DesiredCapabilities dc = new DesiredCapabilities();
        reportsMainFolder =new File("reports");
        dc.setCapability("reportDirectory", reportsMainFolder.getAbsolutePath());
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testNameString);

        dc.setCapability(MobileCapabilityType.UDID, "668bbfe5");
        dc.setCapability("user", "admin");
        dc.setCapability("projectName", "Default");
        dc.setCapability("password","Experitest2012");

       // dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
       // dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        dcMap= dc.asMap();
        driver = new AndroidDriver(new URL("http://192.168.2.13:80/wd/hub"), dc);

        /////////////

//        SessionId sessionId = driver.getSessionId();
        //driver.getSessionDetails();
        //TestSession testSession = TestSessionFactory.fromAppiumSession(sessionId, dc);
       // ManagerPublisher managerPublisher = PManager.fromAppiumDriver(driver);
        
    }

    @Test
    public void testAndroidReporterTestGrid5() throws IOException {
       // Map<String,String> propertiesMap =new HashMap<String,String>();
       /* Map<String, ?> dcMap = driver.getCapabilities().asMap();
        Set<String> keySet = dcMap.keySet();
        for (String key :keySet){
            String stringValue = dcMap.get(key).toString();
            System.out.println(key+" : "+ stringValue);
            propertiesMap.put(key,stringValue);
        }
        String sessionsStringFromURL = URLReader.getStringFromURL("http://localhost:4723/wd/hub/sessions");
        propertiesMap.put("Sessions",sessionsStringFromURL);
        String statusStringFromURL = URLReader.getStringFromURL("http://localhost:4723/wd/hub/status");
        propertiesMap.put("Server Status",statusStringFromURL);*/

        driver.findElement(By.xpath("//*[@hint='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@hint='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        driver.context("WEBVIEW_1");
        String balance = driver.findElement(By.xpath("/*//*[@nodeName='H1']")).getText().replace("Your balance is: ","");
        System.out.println(balance);
       // propertiesMap.put("balance",balance);


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


       // managerPublisher.addProperties(propertiesMap);

    }

    @After
    public void tearDown() throws InterruptedException {
        /*Capabilities capabilities = driver.getCapabilities();
        Map<String, ?> dcMap = capabilities.asMap();
        Set<String> keySet = dcMap.keySet();
        Map<String,String> propertiesMap =new HashMap<String,String>();
        for (String key :keySet){
            String stringValue = dcMap.get(key).toString();
            System.out.println(key+" : "+ stringValue);
            propertiesMap.put(key,stringValue);
        }*/
        driver.quit();
        File[] files = reportsMainFolder.listFiles();
        File reportsDir=new File("");

        for (File file: files){
            //System.out.println(file.getAbsolutePath());
            reportsDir=file;
        }

        System.out.println(reportsDir.getAbsolutePath());
        Date date = new Date();
        String dateString = date.toString();
        System.out.println("Time Stamp : "+ dateString);
       // managerPublisher.addProperty("Time Stamp", dateString);
        //managerPublisher.addReportFolder(reportsDir);
        Thread.sleep(5000);
    }
}