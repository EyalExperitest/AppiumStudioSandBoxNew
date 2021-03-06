package main.java.reporter;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.tools.URLReader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import com.experitest.manager.api.ManagerPublisher;
import com.experitest.manager.client.PManager;
import com.experitest.manager.junit.ManagerTestRunner;

@RunWith(ManagerTestRunner.class)
public class AndroidReporterTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testNameString = "AndroidReporterTest";
    protected AndroidDriver driver = null;
    protected Map<String, ?> dcMap;
    protected File reportsMainFolder = null;
    private ManagerPublisher managerPublisher = null;


    static {
        System.setProperty("manager.url", "localhost:9090");
        System.setProperty("manager.user", "admin");
        System.setProperty("manager.password", "Experitest2012");
        System.setProperty("manager.project", "Default");
    }
    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() throws MalformedURLException {
        managerPublisher = PManager.createManagerPublisher(testName.getMethodName());
        DesiredCapabilities dc = new DesiredCapabilities();
        reportsMainFolder =new File("reports");
        dc.setCapability("reportDirectory", reportsMainFolder.getAbsolutePath());
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testNameString);
        dc.setCapability(MobileCapabilityType.UDID, "LGH850ab3befa7");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        dcMap= dc.asMap();
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testAndroidReporterTest5() throws IOException {
        Map<String, ?> dcMap = driver.getCapabilities().asMap();
        Set<String> keySet = dcMap.keySet();
        Map<String,String> propertiesMap =new HashMap<String,String>();
        for (String key :keySet){
            String stringValue = dcMap.get(key).toString();
            System.out.println(key+" : "+ stringValue);
            propertiesMap.put(key,stringValue);
        }
        String sessionsStringFromURL = URLReader.getStringFromURL("http://localhost:4723/wd/hub/sessions");
        propertiesMap.put("Sessions",sessionsStringFromURL);
        String statusStringFromURL = URLReader.getStringFromURL("http://localhost:4723/wd/hub/status");
        propertiesMap.put("Server Status",statusStringFromURL);

        driver.findElement(By.xpath("//*[@hint='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@hint='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        driver.context("WEBVIEW_1");
        String balance = driver.findElement(By.xpath("/*//*[@nodeName='H1']")).getText().replace("Your balance is: ","");
        System.out.println(balance);
        propertiesMap.put("balance",balance);


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
        managerPublisher.addProperty("Time Stamp", dateString);
        managerPublisher.addReportFolder(reportsDir);
        Thread.sleep(5000);
    }
}