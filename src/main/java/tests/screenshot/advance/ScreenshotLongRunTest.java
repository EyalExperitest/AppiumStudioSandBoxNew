package main.java.tests.screenshot.advance;

//package <set your test package>;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import main.java.Utils.CSV;
import main.java.Utils.CommandsMonitor;
import main.java.Utils.TimeMeasure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;


import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class ScreenshotLongRunTest {
    public static final String HOST ="http://eyalneumann.experitest.local:8090/wd/hub";//https://mastercloud.experitest.com:443/wd/hub";// "http://localhost:4723/wd/hub";
    private static final String VERSION ="12 1 3978";

//    public static final String FILE_NAME = "AndroidPerformanceTestGridAutomation_Cloud_12_1_3978_50_Tests_File_007.csv";
    public static final String FILE_NAME = "IOSPerformanceTestGridAutomation_Cloud_12_1_4040_1_Tests_File_022.csv";

    public static final int ITERATIONS = 2;
//    public static final String ANDROID_DEVICE_ID = "PMF4C17807017153";
    public static final String ANDROID_DEVICE_ID = "32e0d2a20377e920";
    public static final String IOS_DEVICE_ID = "36f0a41a8fca9263c1f977b915dcb5668a0b83fc";

    private static final boolean SET_LOF_FLAG =false;
    public static final int WEB_ELEMENT_ITERATIONS = 5;
    public static final int WEB_CLICK = 5;
    private static final int WEB_SWIPE =5 ;
    private static final int SEND_WEB_TEXT = 5;
    private String reportDirectory = "reports\\EriBank Appium Test";
//    private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTUEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4Mzk5MTMxMjEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NDxf8DjL1TrXuFw6RpbLOBxTn0hVVPUCo3xc7xWknEw";
//    private String accessKey = "eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVek56RTVOVE01TXpVNU5BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NTI1NTUzOTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.fwhIfssRWlme8DInuNu6tDuV0ezd-OyUURyx6KVdfHg";
    private String accessKey = "eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVek9UQXdPRGd5TkRjME13IiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NTQzNjg4MjQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.eP-0E-eqPkzSWCEhl_6nkidJDltRCMMib4jusr1lcc4";
    private String reportFormat = "xml";
//    private String testName = "EriBank Appium Test";

    protected CommandsMonitor commandsMonitor;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
         commandsMonitor =new CommandsMonitor();
    }

    @Test
    public void testScreenshotLongRunTest() throws IOException {

        boolean takeScreenShots;// =true;




//        CommandsMonitor commandsMonitor =new CommandsMonitor();
//        TimeMeasure timeMeasure =new TimeMeasure();


        //DesiredCapabilities dc = setDesiredCapabilitiesAndroidEriBankTest(takeScreenShots);

        for (int i = 0; i< ITERATIONS; i++) {
            takeScreenShots =(i%2==0);//=false;//=true;//
            System.out.println("*********************************************************************");
            String takeScreenShotsString = takeScreenShots ? "With ScreenShots" : "Without ScreenShots";

            System.out.println("Starting Iteration "+i+" ("+takeScreenShotsString+")");
            try {
                runIOSEribankTest(setDesiredCapabilitiesIOSEriBankTest(takeScreenShots),commandsMonitor,takeScreenShots);
            } catch (Exception e) {
                e.printStackTrace();
            }
            /*try {
                runAndroidEriBankTest(setDesiredCapabilitiesAndroidEriBankTest(takeScreenShots),commandsMonitor, takeScreenShots);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                runIOSTestSafari(setDesiredCapabilitiesSafari(takeScreenShots),commandsMonitor,takeScreenShots);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                runAndroidTestChrome(setDesiredCapabilitiesChrome(takeScreenShots),commandsMonitor,takeScreenShots);
            } catch (Exception e) {
                e.printStackTrace();
            }*/






            System.out.println("*********************************************************************");
        }







    }
    private DesiredCapabilities setDesiredCapabilitiesIOSEriBankTest(boolean takeScreenShots) {
        String takeScreenShotsString = takeScreenShots ? "With ScreenShots" : "Without ScreenShots";
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", "EriBank iOS Appium Test"+" "+takeScreenShotsString);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, IOS_DEVICE_ID);

        dc.setCapability(MobileCapabilityType.UDID, "36f0a41a8fca9263c1f977b915dcb5668a0b83fc");
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\EriBank.ipa");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");




        dc.setCapability("takeScreenshots", takeScreenShots);
        dc.setCapability("instrumentApp", true);
        return dc;
    }








    private DesiredCapabilities setDesiredCapabilitiesAndroidEriBankTest(boolean takeScreenShots) {
        String takeScreenShotsString = takeScreenShots ? "With ScreenShots" : "Without ScreenShots";
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", "EriBank Android Appium Test"+" "+takeScreenShotsString);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, ANDROID_DEVICE_ID);
        //dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\apk\\com.experitest.ExperiBank.LoginActivity.2.apk");
        //dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.eribank/com.experitest.ExperiBank.LoginActivity");
//        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.eribank");
//        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.experitest.ExperiBank.LoginActivity");

        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudioenterprise\\original-apks\\com.experitest.ExperiBank.LoginActivity.2.apk");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");



        dc.setCapability("takeScreenshots", takeScreenShots);
        dc.setCapability("instrumentApp", true);
        return dc;
    }
    private DesiredCapabilities setDesiredCapabilitiesChrome(boolean takeScreenShots) {
        String takeScreenShotsString = takeScreenShots ? "With ScreenShots" : "Without ScreenShots";
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", "Chrome Appium Test"+" "+takeScreenShotsString);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, ANDROID_DEVICE_ID);
        dc.setBrowserName(MobileBrowserType.CHROMIUM);
        dc.setCapability("takeScreenshots", takeScreenShots);
        return dc;
    }
    private DesiredCapabilities setDesiredCapabilitiesSafari(boolean takeScreenShots) {
        String takeScreenShotsString = takeScreenShots ? "With ScreenShots" : "Without ScreenShots";
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", "Safari Appium Test"+" "+takeScreenShotsString);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, IOS_DEVICE_ID);
        dc.setBrowserName(MobileBrowserType.SAFARI);
        dc.setCapability("takeScreenshots", takeScreenShots);
        return dc;
    }


    private void runAndroidEriBankTest(DesiredCapabilities dc, CommandsMonitor commandsMonitor, boolean takeScreenShots) throws MalformedURLException {
        TimeMeasure commandTimeMeasure =new TimeMeasure();
        TimeMeasure totalTimeMeasure =new TimeMeasure();
        AndroidDriver<AndroidElement> driver = null;

        String os="Android: ";
        String takeScreenShotsString =os+(takeScreenShots ? "With Screenshots: " : "Without Screenshots: ");

        String findNativeElement = takeScreenShotsString+"Find Instrumented Element";
        String find_hybrid_element = takeScreenShotsString+"Find Hybrid Element";
        String send_keys =takeScreenShotsString+"Send Keys";
        String click = takeScreenShotsString+"Click";
        String find_elements =takeScreenShotsString+"Find Elements :";
        String swipe_action = takeScreenShotsString+"Swipe Action";
        String initiate_driver_ =takeScreenShotsString+"Initiate Driver ";
        String quit_driver = takeScreenShotsString+"Quit Driver";
        String get_text = takeScreenShotsString+"Get Text";
        String instrumented_eriBank_test =takeScreenShotsString+"A.Instrumented EriBank Test";
        totalTimeMeasure.set();
        try {
            try {
                commandTimeMeasure.set();
                driver = new AndroidDriver<>(new URL(HOST), dc);
                commandsMonitor.add(initiate_driver_,commandTimeMeasure.get());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (SET_LOF_FLAG) {
                driver.setLogLevel(Level.INFO);
            }

            driver.context("NATIVE_APP");

            commandTimeMeasure.set();
            AndroidElement usernameTextField = driver.findElement(By.id("usernameTextField"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement passwordTextField = driver.findElement(By.id("passwordTextField"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement loginButton = driver.findElement(By.id("loginButton"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());


            commandTimeMeasure.set();
            usernameTextField.sendKeys("company");
            commandsMonitor.add(send_keys,commandTimeMeasure.get());


            commandTimeMeasure.set();
            passwordTextField.sendKeys("company");
            commandsMonitor.add(send_keys,commandTimeMeasure.get());

            commandTimeMeasure.set();
            loginButton.click();
            commandsMonitor.add(click,commandTimeMeasure.get());


            driver.context("WEBVIEW_1");

            for (int j = 0; j< WEB_ELEMENT_ITERATIONS; j++) {
                commandTimeMeasure.set();
//            AndroidElement balance = driver.findElement(By.linkText("Your balance is: 100.00$"));
                AndroidElement balance = driver.findElement(By.xpath("//*[@nodeName='H1']"));
                commandsMonitor.add(find_hybrid_element,commandTimeMeasure.get());

                commandTimeMeasure.set();
                String text = balance.getText();
                commandsMonitor.add(get_text,commandTimeMeasure.get());
                System.out.println("Balance :"+text);

            }


            driver.context("NATIVE_APP");
            commandTimeMeasure.set();
            AndroidElement makePayment = driver.findElement(By.linkText("Make Payment"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            makePayment.click();
            commandsMonitor.add(click,commandTimeMeasure.get());

            commandTimeMeasure.set();
            List<AndroidElement> elementsEditText = driver.findElements(By.xpath("//*[@class='android.widget.EditText']"));
            commandsMonitor.add(find_elements +elementsEditText.size(),commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement phoneTextField = driver.findElement(By.id("phoneTextField"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement nameTextField = driver.findElement(By.id("nameTextField"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement amountTextField = driver.findElement(By.id("amountTextField"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement select = driver.findElement(By.linkText("Select"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            phoneTextField.sendKeys("0987");
            commandsMonitor.add(send_keys,commandTimeMeasure.get());

            commandTimeMeasure.set();
            nameTextField.sendKeys("Eyal");
            commandsMonitor.add(send_keys,commandTimeMeasure.get());

            commandTimeMeasure.set();
            amountTextField.sendKeys("1000");
            commandsMonitor.add(send_keys,commandTimeMeasure.get());

            commandTimeMeasure.set();
            select.click();
            commandsMonitor.add(click,commandTimeMeasure.get());

            commandTimeMeasure.set();
            List<AndroidElement> rowTextView = driver.findElements(By.id("rowTextView"));
            commandsMonitor.add(find_elements +rowTextView.size(),commandTimeMeasure.get());

            commandTimeMeasure.set();
            new TouchAction(driver).press(597, 1768).waitAction(Duration.ofMillis(472)).moveTo(586, 260).release().perform();
            commandsMonitor.add(swipe_action,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement elementNigeria = driver.findElement(By.xpath("//*[@text='Nigeria']"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            elementNigeria.click();
            commandsMonitor.add(click,commandTimeMeasure.get());


            commandTimeMeasure.set();
            AndroidElement sendPaymentButton = driver.findElement(By.id("sendPaymentButton"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());


            commandTimeMeasure.set();
            sendPaymentButton.click();
            commandsMonitor.add(click,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement yes = driver.findElement(By.linkText("Yes"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            yes.click();
            commandsMonitor.add(click,commandTimeMeasure.get());
        } finally {

            if (driver!=null) {
                commandTimeMeasure.set();
                driver.quit();
                commandsMonitor.add(quit_driver,commandTimeMeasure.get());
                commandsMonitor.add(instrumented_eriBank_test,totalTimeMeasure.get());
            }
        }





    }
    private void runAndroidTestChrome( DesiredCapabilities dc,CommandsMonitor commandsMonitor, boolean takeScreenShots) throws MalformedURLException {
        TimeMeasure commandTimeMeasure =new TimeMeasure();
        TimeMeasure totalTimeMeasure =new TimeMeasure();
        AndroidDriver<AndroidElement> driver = null;
        String os="Android: ";

        String takeScreenShotsString =os+( takeScreenShots ? "With Screenshots: " : "Without Screenshots: ");
        String initiate_driver_ = takeScreenShotsString+"Initiate Driver ";
        String quit_driver = takeScreenShotsString+"Quit Driver";

        String get_webPageTests = takeScreenShotsString+"Get WebPageTests";
        String hide_keyboard = takeScreenShotsString+"Hide Keyboard";
        String action_menu = takeScreenShotsString+"Action Menu";
        String find_non_instrumented_element =takeScreenShotsString+ "Find Non Instrumented Element";
        String ClickOnNonInstrumentedElement = takeScreenShotsString+"Click on Non-Instrumented Element";

        String send_keys = takeScreenShotsString+"Send Keys";
        String send_keys_non_instrumented =takeScreenShotsString+ "Send Keys Non Instrumented";
        String find_web_element =takeScreenShotsString+ "Find Web Element";
        String click_web_element = takeScreenShotsString+"Click Web Element";
        String send_keys_web =takeScreenShotsString+ "Send Keys Web";
        String get_web_text =takeScreenShotsString+ "Get Web Text";
        String swipe_web = takeScreenShotsString+"Swipe Web";

        String androidTest = takeScreenShotsString+"A.Chrome Test";
        totalTimeMeasure.set();
        try {
            try {
                commandTimeMeasure.set();
                driver = new AndroidDriver<>(new URL(HOST), dc);
                commandsMonitor.add(initiate_driver_,commandTimeMeasure.get());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (SET_LOF_FLAG) {
                driver.setLogLevel(Level.INFO);
            }
/*
              commandTimeMeasure.set();
              commandsMonitor.add("",totalTimeMeasure.get());
 */

            commandTimeMeasure.set();
            driver.get("http://192.168.4.85:8060/html-tests/WebPageTests/WebPageTests.html");
            commandsMonitor.add(get_webPageTests,commandTimeMeasure.get());


            driver.context("NATIVE_APP");
            // driver.findElement(By.xpath("//*[@id='menu_button']")).click();
            commandTimeMeasure.set();
            driver.hideKeyboard();
            commandsMonitor.add(hide_keyboard,commandTimeMeasure.get());

            commandTimeMeasure.set();
            driver.pressKeyCode(AndroidKeyCode.MENU);
            commandsMonitor.add(action_menu,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement findInPage = driver.findElement(By.xpath("//*[@text='Find in page']"));
            commandsMonitor.add(find_non_instrumented_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            findInPage.click();
            commandsMonitor.add(ClickOnNonInstrumentedElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement findQuery = driver.findElement(By.xpath("//*[@id='find_query']"));
            commandsMonitor.add(find_non_instrumented_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            findQuery.sendKeys("Autocomplete");
            commandsMonitor.add(send_keys_non_instrumented,commandTimeMeasure.get());

            commandTimeMeasure.set();
            driver.hideKeyboard();
            commandsMonitor.add(hide_keyboard,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement closeFindButton = driver.findElement(By.xpath("//*[@id='close_find_button']"));
            commandsMonitor.add(find_non_instrumented_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            closeFindButton.click();
            commandsMonitor.add(ClickOnNonInstrumentedElement,commandTimeMeasure.get());


            driver.context("WEBVIEW_1");

            commandTimeMeasure.set();
            AndroidElement autocomplete = driver.findElement(By.xpath("//*[@nodeName='A' and @text='Autocomplete']"));
            commandsMonitor.add(find_web_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            autocomplete.click();
            commandsMonitor.add(click_web_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement searchElement = driver.findElement(By.xpath("//*[@name='search']"));
            commandsMonitor.add(find_web_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            searchElement.sendKeys("South");
            commandsMonitor.add(send_keys_web,commandTimeMeasure.get());

            commandTimeMeasure.set();
            driver.hideKeyboard();
            commandsMonitor.add(hide_keyboard,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement selectElement = driver.findElement(By.xpath("//*[@name='select']"));
            commandsMonitor.add(find_web_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            selectElement.click();
            commandsMonitor.add(click_web_element,commandTimeMeasure.get());


            driver.context("NATIVE_APP");

            commandTimeMeasure.set();
            AndroidElement chromeListElement = driver.findElement(By.xpath("//*[@text='Chrome']"));
            commandsMonitor.add(find_non_instrumented_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            chromeListElement.click();
            commandsMonitor.add(ClickOnNonInstrumentedElement,commandTimeMeasure.get());


            driver.context("NATIVE_APP");

            commandTimeMeasure.set();
            driver.hideKeyboard();
            commandsMonitor.add(hide_keyboard,commandTimeMeasure.get());


            commandTimeMeasure.set();
            driver.pressKeyCode(AndroidKeyCode.MENU);
            commandsMonitor.add(action_menu,commandTimeMeasure.get());

            commandTimeMeasure.set();
            findInPage = driver.findElement(By.xpath("//*[@text='Find in page']"));
            commandsMonitor.add(find_non_instrumented_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            findInPage.click();
            commandsMonitor.add(ClickOnNonInstrumentedElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            findQuery = driver.findElement(By.xpath("//*[@id='find_query']"));
            commandsMonitor.add(find_non_instrumented_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            findQuery.sendKeys("Autocomplete");
            commandsMonitor.add(send_keys_non_instrumented,commandTimeMeasure.get());

            commandTimeMeasure.set();
            driver.hideKeyboard();
            commandsMonitor.add(hide_keyboard,commandTimeMeasure.get());


            commandTimeMeasure.set();
            closeFindButton = driver.findElement(By.xpath("//*[@id='close_find_button']"));
            commandsMonitor.add(find_non_instrumented_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            closeFindButton.click();
            commandsMonitor.add(ClickOnNonInstrumentedElement,commandTimeMeasure.get());

            driver.context("WEBVIEW_1");

            commandTimeMeasure.set();
            AndroidElement clickCounterElement = driver.findElement(By.xpath("//*[@nodeName='A' and @text='Click Counter']"));
            commandsMonitor.add(find_web_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            clickCounterElement.click();
            commandsMonitor.add(click_web_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement clickHereElement = driver.findElement(By.xpath("//*[@nodeName='BUTTON' and @text='Click Here']"));
            commandsMonitor.add(find_web_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            clickHereElement.click();
            commandsMonitor.add(click_web_element,commandTimeMeasure.get());

            for (int j = 0; j < WEB_CLICK; j++) {
                commandTimeMeasure.set();
                AndroidElement counterElement = driver.findElement(By.xpath("//*[@nodeName='SPAN' and @id='counter']"));
                commandsMonitor.add(find_web_element,commandTimeMeasure.get());

                commandTimeMeasure.set();
                counterElement.getText();
                commandsMonitor.add(get_web_text,commandTimeMeasure.get());
            }


            for  (int j = 0; j < WEB_SWIPE; j++) {
                commandTimeMeasure.set();
                new TouchAction(driver).press(937, 1711).waitAction(Duration.ofMillis(516)).moveTo(831, 433).release().perform();
                commandsMonitor.add(swipe_web,commandTimeMeasure.get());

                commandTimeMeasure.set();
                new TouchAction(driver).press(877, 451).waitAction(Duration.ofMillis(1024)).moveTo(940, 1657).release().perform();
                commandsMonitor.add(swipe_web,commandTimeMeasure.get());
            }


        } finally {

            if (driver!=null) {
                commandTimeMeasure.set();
                driver.quit();
                commandsMonitor.add(quit_driver,commandTimeMeasure.get());
                commandsMonitor.add(androidTest,totalTimeMeasure.get());
            }
        }
    }
    private void runIOSTest( DesiredCapabilities dc,CommandsMonitor commandsMonitor, boolean takeScreenShots) throws MalformedURLException {
        TimeMeasure commandTimeMeasure =new TimeMeasure();
        TimeMeasure totalTimeMeasure =new TimeMeasure();
        IOSDriver<WebElement> driver=null;

        String os ="IOS: ";
        String takeScreenShotsString = os+(takeScreenShots ? "With Screenshots: " : "Without Screenshots: ");
        String initiate_driver_ = takeScreenShotsString+"Initiate Driver ";
        String quit_driver = takeScreenShotsString+"Quit Driver";
        String iOSTest = takeScreenShotsString+"A.IOS Test";





        totalTimeMeasure.set();
        try {
            try {
                commandTimeMeasure.set();
                driver = new IOSDriver<>(new URL(HOST), dc);
                commandsMonitor.add(initiate_driver_,commandTimeMeasure.get());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (SET_LOF_FLAG) {
                driver.setLogLevel(Level.INFO);
            }
            driver.context("NATIVE_APP");




        } finally {

            if (driver!=null) {
                commandTimeMeasure.set();
                driver.quit();
                commandsMonitor.add(quit_driver,commandTimeMeasure.get());
                commandsMonitor.add(iOSTest,totalTimeMeasure.get());
            }
        }
    }
    private void runIOSTestSafari( DesiredCapabilities dc,CommandsMonitor commandsMonitor, boolean takeScreenShots) throws MalformedURLException {
        TimeMeasure commandTimeMeasure =new TimeMeasure();
        TimeMeasure totalTimeMeasure =new TimeMeasure();
        IOSDriver<WebElement> driver=null;
        String os="IOS: ";

        String takeScreenShotsString =os+( takeScreenShots ? "With Screenshots: " : "Without Screenshots: ");
        String initiate_driver_ = takeScreenShotsString+"Initiate Driver ";
        String quit_driver = takeScreenShotsString+"Quit Driver";

        String get_webPageTests = takeScreenShotsString+"Get WebPageTests";
        String hide_keyboard = takeScreenShotsString+"Hide Keyboard";
        String action_menu = takeScreenShotsString+"Action Menu";
        String find_non_instrumented_element =takeScreenShotsString+ "Find Non Instrumented Element";
        String ClickOnNonInstrumentedElement = takeScreenShotsString+"Click on Non-Instrumented Element";

        String send_keys = takeScreenShotsString+"Send Keys";
        String send_keys_non_instrumented =takeScreenShotsString+ "Send Keys Non Instrumented";
        String find_web_element =takeScreenShotsString+ "Find Web Element";
        String click_web_element = takeScreenShotsString+"Click Web Element";
        String send_keys_web =takeScreenShotsString+ "Send Keys Web";
        String get_web_text =takeScreenShotsString+ "Get Web Text";
        String swipe_web = takeScreenShotsString+"Swipe Web";

        String testName = takeScreenShotsString+"A.Safari Test";
        totalTimeMeasure.set();
        try {
            try {
                commandTimeMeasure.set();
                driver = new IOSDriver<>(new URL(HOST), dc);
                commandsMonitor.add(initiate_driver_,commandTimeMeasure.get());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (SET_LOF_FLAG) {
                driver.setLogLevel(Level.INFO);
            }
/*
              commandTimeMeasure.set();
              commandsMonitor.add("",totalTimeMeasure.get());
 */

            commandTimeMeasure.set();
            driver.get("http://192.168.4.85:8060/html-tests/WebPageTests/WebPageTests.html");
            commandsMonitor.add(get_webPageTests,commandTimeMeasure.get());


            driver.context("NATIVE_APP");
            // driver.findElement(By.xpath("//*[@id='menu_button']")).click();
            commandTimeMeasure.set();
            driver.hideKeyboard();
            commandsMonitor.add(hide_keyboard,commandTimeMeasure.get());





            driver.context("WEBVIEW_1");

/*
            for (int j = 0; j < SEND_WEB_TEXT; j++) {

                commandTimeMeasure.set();
                WebElement searchElement = driver.findElement(By.xpath("//*[@id='searchInput']"));
                commandsMonitor.add(find_web_element, commandTimeMeasure.get());

                commandTimeMeasure.set();
                searchElement.sendKeys("");
                commandsMonitor.add(send_keys_web, commandTimeMeasure.get());

                commandTimeMeasure.set();
                WebElement selectElement = driver.findElement(By.xpath("//*[@name='select']"));
                commandsMonitor.add(find_web_element, commandTimeMeasure.get());

                commandTimeMeasure.set();
                selectElement.sendKeys("");
                commandsMonitor.add(send_keys_web, commandTimeMeasure.get());
            }
*/









            for (int j = 0; j < WEB_CLICK; j++) {
                commandTimeMeasure.set();
                WebElement clickHereElement = driver.findElement(By.xpath("//*[@id='add_button' and @text='Click Here']"));
                commandsMonitor.add(find_web_element,commandTimeMeasure.get());

                commandTimeMeasure.set();
                clickHereElement.click();
                commandsMonitor.add(click_web_element,commandTimeMeasure.get());

                commandTimeMeasure.set();
                WebElement counterElement = driver.findElement(By.xpath("//*[@id='counter']"));
                commandsMonitor.add(find_web_element,commandTimeMeasure.get());


                commandTimeMeasure.set();
                String text1 = counterElement.getText();
                commandsMonitor.add(get_web_text,commandTimeMeasure.get());
            }


            for  (int j = 0; j < WEB_SWIPE; j++) {
                commandTimeMeasure.set();
                new TouchAction(driver).press(937, 1711).waitAction(Duration.ofMillis(516)).moveTo(831, 433).release().perform();
                commandsMonitor.add(swipe_web,commandTimeMeasure.get());

                commandTimeMeasure.set();
                new TouchAction(driver).press(877, 451).waitAction(Duration.ofMillis(1024)).moveTo(940, 1657).release().perform();
                commandsMonitor.add(swipe_web,commandTimeMeasure.get());
            }


        } finally {

            if (driver!=null) {
                commandTimeMeasure.set();
                driver.quit();
                commandsMonitor.add(quit_driver,commandTimeMeasure.get());
                commandsMonitor.add(testName,totalTimeMeasure.get());
            }
        }
    }


    private void runIOSEribankTest( DesiredCapabilities dc,CommandsMonitor commandsMonitor, boolean takeScreenShots) throws MalformedURLException {
        TimeMeasure commandTimeMeasure =new TimeMeasure();
        TimeMeasure totalTimeMeasure =new TimeMeasure();
        IOSDriver<WebElement> driver=null;

        String os ="IOS: ";
        String takeScreenShotsString = os+(takeScreenShots ? "With Screenshots: " : "Without Screenshots: ");
        String initiate_driver_ = takeScreenShotsString+"Initiate Driver ";
        String quit_driver = takeScreenShotsString+"Quit Driver";
        String iOSTest = takeScreenShotsString+"A.IOS Test";
        String find_non_instrumented_element =takeScreenShotsString+ "Find Non Instrumented Element";

        String findNativeElement = takeScreenShotsString+"Find Instrumented Element";
        String find_hybrid_element = takeScreenShotsString+"Find Hybrid Element";
        String send_keys =takeScreenShotsString+"Send Keys";
        String click = takeScreenShotsString+"Click";
        String find_elements =takeScreenShotsString+"Find Elements :";
        String get_text = takeScreenShotsString+"Get Text";
        String swipe_action = takeScreenShotsString+"Swipe Action";
        String wait_for_element = takeScreenShotsString+"Wait For Element";





        totalTimeMeasure.set();
        try {
            try {
                commandTimeMeasure.set();
                driver = new IOSDriver<>(new URL(HOST), dc);
                commandsMonitor.add(initiate_driver_,commandTimeMeasure.get());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            if (SET_LOF_FLAG) {
                driver.setLogLevel(Level.INFO);
            }

            //driver.context("NATIVE_APP");
            driver.context("NATIVE_APP_INSTRUMENTED");

            commandTimeMeasure.set();
            WebElement userNameElement = driver.findElement(By.xpath("//*[@placeholder='Username']"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            userNameElement.sendKeys("company");
            commandsMonitor.add(send_keys,commandTimeMeasure.get());

            commandTimeMeasure.set();
            WebElement passwordElement = driver.findElement(By.xpath("//*[@placeholder='Password']"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            passwordElement.sendKeys("company");
            commandsMonitor.add(send_keys,commandTimeMeasure.get());

            commandTimeMeasure.set();
            WebElement loginButtonElement = driver.findElement(By.xpath("//*[@text='Login']"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            loginButtonElement.click();
            commandsMonitor.add(click,commandTimeMeasure.get());

            driver.context("WEBVIEW_1");

            commandTimeMeasure.set();
            WebElement h1Element = driver.findElement(By.xpath("//*[@nodeName='H1']"));
            commandsMonitor.add(find_hybrid_element,commandTimeMeasure.get());

            driver.context("NATIVE_APP_INSTRUMENTED");

            commandTimeMeasure.set();
            WebElement makePaymentButtonElement = driver.findElement(By.xpath("//*[@accessibilityLabel='makePaymentButton']"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            makePaymentButtonElement.click();
            commandsMonitor.add(click,commandTimeMeasure.get());

            commandTimeMeasure.set();
            WebElement phoneElement = driver.findElement(By.xpath("//*[@placeholder='Phone']"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            phoneElement.sendKeys("09876543");
            commandsMonitor.add(send_keys,commandTimeMeasure.get());

            commandTimeMeasure.set();
            WebElement nameElement = driver.findElement(By.xpath("//*[@placeholder='Name']"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            nameElement.sendKeys("Eyal");
            commandsMonitor.add(send_keys,commandTimeMeasure.get());

            commandTimeMeasure.set();
            WebElement amountElement = driver.findElement(By.xpath("//*[@placeholder='Amount']"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            amountElement.sendKeys("1000");
            commandsMonitor.add(send_keys,commandTimeMeasure.get());

            commandTimeMeasure.set();
            WebElement countryButtonElement = driver.findElement(By.xpath("//*[@accessibilityLabel='countryButton']"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            countryButtonElement.click();
            commandsMonitor.add(click,commandTimeMeasure.get());

            commandTimeMeasure.set();
            new TouchAction(driver).press(432, 1241).waitAction(Duration.ofMillis(585)).moveTo(264, 52).release().perform();
            commandsMonitor.add(swipe_action,commandTimeMeasure.get());

            commandTimeMeasure.set();
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("South Africa")));
            commandsMonitor.add(wait_for_element,commandTimeMeasure.get());

            commandTimeMeasure.set();
            WebElement SouthAfricaElement = driver.findElement(By.xpath("//*[@accessibilityLabel='South Africa']"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            SouthAfricaElement.click();
            commandsMonitor.add(click,commandTimeMeasure.get());

            commandTimeMeasure.set();
            WebElement sendPaymentButtonElement = driver.findElement(By.xpath("//*[@accessibilityLabel='sendPaymentButton']"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            sendPaymentButtonElement.click();
            commandsMonitor.add(click,commandTimeMeasure.get());

            commandTimeMeasure.set();
            WebElement yesElement = driver.findElement(By.xpath("//*[@text='Yes']"));
            commandsMonitor.add(findNativeElement,commandTimeMeasure.get());

            commandTimeMeasure.set();
            yesElement.click();
            commandsMonitor.add(click,commandTimeMeasure.get());

            driver.context("NATIVE_APP_NON_INSTRUMENTED");

            commandTimeMeasure.set();
            WebElement UIStatusBarTimeItemViewElement = driver.findElement(By.xpath("//*[@knownSuperClass='UIStatusBarTimeItemView']"));
            commandsMonitor.add(find_non_instrumented_element,commandTimeMeasure.get());

            commandTimeMeasure.set();

            String text = UIStatusBarTimeItemViewElement.getText();
            System.out.println(text);
            commandsMonitor.add(get_text,commandTimeMeasure.get());



            driver.context("NATIVE_APP_INSTRUMENTED");

            commandTimeMeasure.set();
            List<WebElement> elements = driver.findElements(By.xpath("//*[@textColor='0x007AFF']"));
            commandsMonitor.add(find_elements +elements.size(),commandTimeMeasure.get());

            driver.context("NATIVE_APP");








        } finally {

            if (driver!=null) {
                commandTimeMeasure.set();
                driver.quit();
                commandsMonitor.add(quit_driver,commandTimeMeasure.get());
                commandsMonitor.add(iOSTest,totalTimeMeasure.get());
            }
        }
    }
    @AfterMethod
    public void tearDown() throws IOException {
        //C:\Users\eyal.neumann\workspace\AppiumStudioSandBoxNew\Files\CSV\ScreenShotIssue\AndroidEriBankTest
        String fileName = "C:\\Users\\eyal.neumann\\workspace\\AppiumStudioSandBoxNew\\Files\\CSV\\ScreenShotIssue\\AndroidEriBankTest\\" + FILE_NAME;
        try(CSV csv =new CSV(fileName,"Command Name","Command Iterations","Command Time","Command Standard Deviation","Command Maximum")){
            Set<String> keySet = commandsMonitor.keySet();
            SortedSet<String> sortedKeySet = new TreeSet<String>();
            sortedKeySet.addAll(keySet);
            for(String key:sortedKeySet){
                long average = commandsMonitor.getAverage(key);
                int number = commandsMonitor.getNumber(key);
                long variance = commandsMonitor.getVariance(key);
                long max = commandsMonitor.getMax(key);
                long standardDeviation = commandsMonitor.getStandardDeviation(key);
                csv.addLine(key,number+"",average+"",standardDeviation+"",max+"");
            }

        }
    }
}