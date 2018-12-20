package main.java.extended;

//package <set your test package>;
import com.experitest.appium.SeeTestClient;
import com.experitest.appium.SeeTestClient;
import com.sun.javafx.scene.traversal.Direction;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;
/*
* ElementSwipeWhileNotFound X X
* SyncElements V
* StartLoggingDevice X  X
* getRunningApplications V
* SetClipboardText V
* GetClipboardText V
 * */

public class SA21034_Extention {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA21034_Extention";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    private SeeTestClient client;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        //dc.setCapability(MobileCapabilityType.UDID, "14bdd0fd9904");
        dc.setCapability(MobileCapabilityType.UDID, "HT51HWV00455");

        //dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\apk\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        //driver.setLogLevel(Level.INFO);
        client= new SeeTestClient(driver);
        String versionWithBuild = client.getVersionWithBuild();
        System.out.println("Version :"+versionWithBuild);

    }

/*    @Test
    public void testSA21034_ElementExtentionSwipeWhileNotFound() {
        String pageSource1 = driver.getPageSource();
        driver.context("NATIVE_APP");
        driver.findElement(By.id("usernameTextField")).sendKeys("company");
        driver.findElement(By.id("passwordTextField")).sendKeys("company");
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.linkText("Make Payment")).click();
        driver.findElement(By.linkText("Select")).click();
        client.elementSwipeWhileNotFound("NATIVE", "xpath=//*[@id='countryList']", "Down", 0, 2000, "NATIVE", "xpath=//*[@text='Germany']", 0, 1000, 5, true);




    }*/
    @Test
    public void testSA21034_Extention_Version(){
        String versionWithBuild = client.getVersionWithBuild();
        System.out.println("Version :"+versionWithBuild);
    }

    @Test
    public void testSA21034_Extension_syncElements(){
        String versionWithBuild = client.getVersionWithBuild();
        System.out.println("Version :"+versionWithBuild);
        driver.pressKeyCode(AndroidKeyCode.HOME);
        driver.findElement(By.xpath("//*[@contentDescription='Play Store']")).click();
        boolean syncElements = client.syncElements(1, 10);
        System.out.println(syncElements);

    }
    @Test
    public void testSA21034_Extension_startLoggingDevice(){
        client.startLoggingDevice("C:\\Path\\device3.log");
        client.sleep(10000);
        client.getVisualDump("Native");
        String stopLoggingDevice = client.stopLoggingDevice();
        System.out.println(stopLoggingDevice);
    }
/*    @Test
    public void testSA21034_Extension_runningApplications(){
        String[] runningApplications = client.getRunningApplications();
        System.out.println("runningApplications:"+runningApplications);
        for(String runningApplication:runningApplications){
            System.out.println(runningApplication);
        }
    }*/
/*    @Test
    public void testSA21034_Extension_SetClipboardText(){
        try {
            client.setClipboardText("company");
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.sleep(10000);
        String clipboardText = client.getClipboardText();
        System.out.println(clipboardText);

    }*/
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
