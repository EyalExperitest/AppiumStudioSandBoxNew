package main.java.extended;

//package <set your test package>;
import com.experitest.appium.SeeTestClient;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AndroidEriBank {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Android EriBank Extended";
    protected AndroidDriver<AndroidElement> driver = null;
    //private SeeTestClient client;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "0516055aa1bb0802");
        //dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\apk\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        dc.setCapability("instrumentApp", true);
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);

    }

    @Test@Ignore
    public void testGetAllValues() {
        SeeTestClient client = new SeeTestClient(driver);
        String version =client.getVersionWithBuild();
        System.out.println(version);

        client.elementSendText("NATIVE", "hint=Username", 0, "company");
        client.elementSendText("NATIVE", "hint=Password", 0, "company");
        client.click("NATIVE", "text=Login", 0, 1);
        client.click("NATIVE", "text=Make Payment", 0, 1);
        client.elementSendText("NATIVE", "hint=Phone", 0, "09785634");
        client.elementSendText("NATIVE", "hint=Name", 0, "Eyal");
        client.elementSendText("NATIVE", "hint=Amount", 0, "100");
        client.click("NATIVE", "text=Select", 0, 1);
       boolean learnPhaze =true;
        Set<String> contries = new HashSet<String>();
        String text = client.getText("Native");
        System.out.println("Text : "+text);
        String[] allValues = client.getAllValues("Native", "xpath=(/*//*[@id='countryList']*//*[@id='rowTextView'])", "text");
        while (learnPhaze){
            String [] contriesArray = client.getAllValues("Native", "xpath=(/*//*[@id='countryList']*//*[@id='rowTextView'])", "text");
            boolean isMore=false;
            for (String countryString :contriesArray){
                if(!contries.contains(countryString)){
                    isMore=true;
                }
                contries.add(countryString);
            }
            learnPhaze=isMore;
        }
        client.elementListSelect("", "text=Spain", 0, true);

        for (String country :contries){
            client.click("NATIVE", "text=Select", 0, 1);
            client.elementListSelect("", "text="+country, 0, true);
            String getText = client.elementGetText("Native", "//*[@hint='Country']", 0);
            assertEquals(getText,country);

        }


        client.click("NATIVE", "text=Send Payment", 0, 1);
        client.click("NATIVE", "text=Yes", 0, 1);
        client.click("NATIVE", "text=Logout", 0, 1);




    }
    @Test@Ignore
    public void testEriBankClearAndLaunch() {

        SeeTestClient client = new SeeTestClient(driver);
        String version =client.getVersionWithBuild();
        System.out.println(version);
        client.applicationClearData("com.experitest.ExperiBank");
        client.launch("com.experitest.ExperiBank/.LoginActivity",true,true);
        client.elementSendText("NATIVE", "hint=Username", 0, "company");
        client.elementSendText("NATIVE", "hint=Password", 0, "company");
        client.click("NATIVE", "text=Login", 0, 1);
        String elementGetText = client.elementGetText("Web", "xpath=//*[@nodeName='H1']", 0);
        assertEquals(elementGetText,"Your balance is: 100.00$");
        client.applicationClose("com.experitest.ExperiBank");

        //client.collectSupportData("C:\\Users\\eyal.neumann\\workspace\\AppiumStudioSandBoxNew\\SupportData\\supportData.zip","",deviceName,"Scenario","Expected","Actual");

   }
    @Test@Ignore
    public void testEriBankRunNativeAPICall() {
        SeeTestClient client = new SeeTestClient(driver);
        String str0 = client.runNativeAPICall("NATIVE", "xpath=//*[@text='Login']", 0, "view.setText(\"LOGIN\");");
        System.out.println("str0 : "+str0);
        client.click("NATIVE", "text=LOGIN", 0, 1);
    }
    @Test@Ignore
    public void testEriBankCollectSupportData() {
        SeeTestClient client = new SeeTestClient(driver);
        String deviceName = client.getDeviceProperty("device.name");
        System.out.println("Device Name : "+deviceName);
        client.collectSupportData("C:\\Users\\eyal.neumann\\workspace\\AppiumStudioSandBoxNew\\SupportData\\supportData.zip","",deviceName,"Scenario","Expected","Actual");
    }
    @Test@Ignore
    public void testEriBankLog() {
        SeeTestClient client = new SeeTestClient(driver);
        String deviceLog0 = client.getDeviceLog();
        System.out.println(deviceLog0);
        client.clearDeviceLog();
        String deviceLog1 = client.getDeviceLog();
        System.out.println(deviceLog1);
    }
    @Test@Ignore
    public void testEriBankCoordinate() {
        SeeTestClient client = new SeeTestClient(driver);
        client.elementSendText("NATIVE", "hint=Username", 0, "company");
        client.elementSendText("NATIVE", "hint=Password", 0, "company");

        String xString = client.elementGetProperty("NATIVE", "text=Login", 0, "x");
        String yString = client.elementGetProperty("NATIVE", "text=Login", 0, "y");
        String widthString = client.elementGetProperty("NATIVE", "text=Login", 0, "width");
        String heightString = client.elementGetProperty("NATIVE", "text=Login", 0, "height");

        Integer x =Integer.parseInt(xString);
        Integer y =Integer.parseInt(yString);
        Integer width =Integer.parseInt(widthString);
        Integer height =Integer.parseInt(heightString);
        int xClick=x+(width/2);
        int yClick=y+(height/2);
        client.clickCoordinate(xClick,yClick,1);

        driver.findElement(By.linkText("Make Payment"));
    }
    @Test
    public void testEriBank000() {
        SeeTestClient client = new SeeTestClient(driver);



    }




    @After
    public void tearDown() {
        driver.quit();
    }
}