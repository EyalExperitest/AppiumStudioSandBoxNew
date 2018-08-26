//package main.java.extended;
////package <set your test package>;
//import com.experitest.appium.SeeTestClient;
//import io.appium.java_client.remote.IOSMobileCapabilityType;
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.IOSElement;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.ScreenOrientation;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.By;
//import org.junit.*;
//import java.net.URL;
//import java.net.MalformedURLException;
//
//public class IOSEriBank {
//    private String reportDirectory = "reports";
//    private String reportFormat = "xml";
//    private String testName = "IOS EriBank Extended";
//    protected IOSDriver<IOSElement> driver = null;
//
//    DesiredCapabilities dc = new DesiredCapabilities();
//
//    @Before
//    public void setUp() throws MalformedURLException {
//        dc.setCapability("reportDirectory", reportDirectory);
//        dc.setCapability("reportFormat", reportFormat);
//        dc.setCapability("testName", testName);
//        dc.setCapability(MobileCapabilityType.UDID, "1d3e36fba9e9d23918ca4f4b8760d0c10ce24b3b");
//        //dc.setCapability(MobileCapabilityType.UDID, "74c36a0fbf4243c5164d2ce8c92584165eb9ce4e");
//        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\EriBank.ipa");
//        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
//        dc.setCapability("instrumentApp", true);
//        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
//    }
//
//    @Test
//    public void testIOSEriBankLog() {
//        SeeTestClient client = new SeeTestClient(driver);
//        String deviceLog = client.getDeviceLog();
//        System.out.println(deviceLog);
//        client.clearDeviceLog();
//        System.out.println(client.getDeviceLog());
//
//
//
//
//
//
//
//    }
//    @Test
//    public void testIOSEriBankCloseApplication() {
//        SeeTestClient client = new SeeTestClient(driver);
//        client.applicationClose("com.experitest.ExperiBank");
//        String currentApplicationName = client.getCurrentApplicationName();
//        System.out.println("currentApplicationName:"+currentApplicationName);
//    }
//    @Test
//    public void testIOSEriBankMobileTimer() {
//        SeeTestClient client = new SeeTestClient(driver);
//
//        client.launch("com.apple.mobiletimer", false, true);
//
//        client.click("NATIVE", "xpath=//*[@text='Stopwatch']", 0, 1);
//        client.click("NATIVE", "xpath=//*[@text='Start']", 0, 1);
//        client.sleep(10000);
//        client.click("NATIVE", "xpath=//*[@text='Lap']", 0, 1);
//        client.sleep(10000);
//        client.click("NATIVE", "xpath=//*[@text='Lap']", 0, 1);
//        client.sleep(10000);
//        client.click("NATIVE", "xpath=//*[@text='Lap']", 0, 1);
//        client.sleep(10000);
//        client.click("NATIVE", "xpath=//*[@text='Stop']", 0, 1);
//        client.click("NATIVE", "xpath=//*[@text='Reset']", 0, 1);
//
//    }
//    @Test@Ignore
//    public void testEriBankShake() {
//        SeeTestClient client = new SeeTestClient(driver);
//        driver.findElement(By.xpath("//*[@text='Username']")).sendKeys("company");
//        client.shake();
//        driver.findElement(By.linkText("Undo")).click();
//    }
//
//    @Test
//    public void testEriBankSetProperty() {
//        SeeTestClient client = new SeeTestClient(driver);
//        System.out.println(driver.getPageSource());
//        driver.findElement(By.xpath("//*[@accessibilityLabel='Username']")).sendKeys("company");
//        client.setProperty("report.image.width","2000");
//        driver.findElement(By.xpath("//*[@text='Password']")).sendKeys("company");
//        driver.findElement(By.linkText("Login")).click();
//    }
//    @Test
//    public void testEriBank0000() {
//        SeeTestClient client = new SeeTestClient(driver);
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//}