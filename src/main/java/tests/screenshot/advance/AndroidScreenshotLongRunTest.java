package main.java.tests.screenshot.advance;

//package <set your test package>;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.TouchAction;

import java.io.IOException;
import java.time.Duration;

import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import javafx.collections.transformation.SortedList;
import main.java.Utils.CSV;
import main.java.Utils.CommandsMonitor;
import main.java.Utils.TimeMeasure;
import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;


import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;

public class AndroidScreenshotLongRunTest {
    public static final String HOST ="http://eyalneumann.experitest.local:8090/wd/hub";//https://mastercloud.experitest.com:443/wd/hub";// "http://localhost:4723/wd/hub";
    public static final String FILE_NAME = "AndroidPerformanceTestGridAutomation_Version_12_0_005.csv";
    public static final int ITERATIONS = 30;
    public static final String DEVICE_ID = "PMF4C17807017153";
    private static final boolean SET_LOF_FLAG =false;
    public static final int WEB_ELEMENT_ITERATIONS = 2;

    private String reportDirectory = "reports\\EriBank Appium Test";
//    private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTUEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4Mzk5MTMxMjEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NDxf8DjL1TrXuFw6RpbLOBxTn0hVVPUCo3xc7xWknEw";
    private String accessKey = "eyJ4cC51IjoxLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVek5qSXlPVGt4T0RBME9BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NTE1ODk5MTgsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.xK9z7ofb6rgyXGhg6flFBphxQmUHpROSeXWa9IJl52A";
    private String reportFormat = "xml";
    private String testName = "EriBank Appium Test";
    protected AndroidDriver<AndroidElement> driver = null;
    protected CommandsMonitor commandsMonitor;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
         commandsMonitor =new CommandsMonitor();
    }

    @Test
    public void testAndroidScreenshotLongRunTest() throws IOException {

        boolean takeScreenShots;// =true;




//        CommandsMonitor commandsMonitor =new CommandsMonitor();
//        TimeMeasure timeMeasure =new TimeMeasure();


        //DesiredCapabilities dc = setDesiredCapabilitiesEriBankTest(takeScreenShots);

        for (int i = 0; i< ITERATIONS; i++) {
            takeScreenShots = (i%2==0);
            System.out.println("*********************************************************************");
            String takeScreenShotsString = takeScreenShots ? "With ScreenShots" : "Without ScreenShots";

            System.out.println("Starting Iteration "+i+" ("+takeScreenShotsString+")");
            try {
                runEriBankTest(setDesiredCapabilitiesEriBankTest(takeScreenShots),commandsMonitor, takeScreenShots);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("*********************************************************************");
        }







    }

    private DesiredCapabilities setDesiredCapabilitiesEriBankTest(boolean takeScreenShots) {
        String takeScreenShotsString = takeScreenShots ? "With ScreenShots" : "Without ScreenShots";
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", "EriBank Appium Test"+" "+takeScreenShotsString);
        dc.setCapability("accessKey", accessKey);
        dc.setCapability(MobileCapabilityType.UDID, DEVICE_ID);
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
        dc.setCapability(MobileCapabilityType.UDID, DEVICE_ID);
        dc.setBrowserName(MobileBrowserType.CHROMIUM);
        dc.setCapability("takeScreenshots", takeScreenShots);
        return dc;
    }
    private void runEriBankTest( DesiredCapabilities dc,CommandsMonitor commandsMonitor, boolean takeScreenShots) throws MalformedURLException {
        TimeMeasure commandTimeMeasure =new TimeMeasure();
        TimeMeasure totalTimeMeasure =new TimeMeasure();


        String takeScreenShotsString = takeScreenShots ? "With Screenshots: " : "Without Screenshots: ";

        String findNativeElement = takeScreenShotsString+"Find Instrumented Element";
        String find_hybrid_element = takeScreenShotsString+"Find Hybrid Element";
        String send_keys = takeScreenShotsString+"Send Keys";
        String click = takeScreenShotsString+"Click";
        String find_elements = takeScreenShotsString+"Find Elements :";
        String swipe_action = takeScreenShotsString+"Swipe Action";
        String initiate_driver_ = takeScreenShotsString+"Initiate Driver ";
        String quit_driver = takeScreenShotsString+"Quit Driver";
        String get_text = takeScreenShotsString+"Get Text";
        String instrumented_eriBank_test = takeScreenShotsString+"A.Instrumented EriBank Test";
        totalTimeMeasure.set();
        try {
            try {
                commandTimeMeasure.set();
                driver = new AndroidDriver<>(new URL(HOST), dc);
                commandsMonitor.add(initiate_driver_,commandTimeMeasure.get());
            } catch (MalformedURLException e) {
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


        String takeScreenShotsString = takeScreenShots ? "With Screenshots: " : "Without Screenshots: ";
        String initiate_driver_ = takeScreenShotsString+"Initiate Driver ";
        String quit_driver = takeScreenShotsString+"Quit Driver";

        String get_webPageTests = takeScreenShotsString+"Get WebPageTests";
        String hide_keyboard = "Hide Keyboard";
        String action_menu = "Action Menu";
        String find_non_instrumented_element = "Find Non Instrumented Element";
        String ClickOnNonInstrumentedElement = "Click on Non-Instrumented Element";

        String send_keys = takeScreenShotsString+"Send Keys";
        String send_keys_non_instrumented = "Send Keys Non Instrumented";
        String find_web_element = "Find Web Element";
        String click_web_element = "Click Web Element";
        String send_keys_web = "Send Keys Web";

        String androidTest = takeScreenShotsString+"A.AndroidTest";
        totalTimeMeasure.set();
        try {
            try {
                commandTimeMeasure.set();
                driver = new AndroidDriver<>(new URL(HOST), dc);
                commandsMonitor.add(initiate_driver_,commandTimeMeasure.get());
            } catch (MalformedURLException e) {
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
            commandsMonitor.add(get_webPageTests,totalTimeMeasure.get());


            driver.context("NATIVE_APP");
            // driver.findElement(By.xpath("//*[@id='menu_button']")).click();
            commandTimeMeasure.set();
            driver.hideKeyboard();
            commandsMonitor.add(hide_keyboard,totalTimeMeasure.get());

            commandTimeMeasure.set();
            driver.pressKeyCode(AndroidKeyCode.MENU);
            commandsMonitor.add(action_menu,totalTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement findInPage = driver.findElement(By.xpath("//*[@text='Find in page']"));
            commandsMonitor.add(find_non_instrumented_element,totalTimeMeasure.get());

            commandTimeMeasure.set();
            findInPage.click();
            commandsMonitor.add(ClickOnNonInstrumentedElement,totalTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement findQuery = driver.findElement(By.xpath("//*[@id='find_query']"));
            commandsMonitor.add(find_non_instrumented_element,totalTimeMeasure.get());

            commandTimeMeasure.set();
            findQuery.sendKeys("Autocomplete");
            commandsMonitor.add(send_keys_non_instrumented,totalTimeMeasure.get());

            commandTimeMeasure.set();
            driver.hideKeyboard();
            commandsMonitor.add(hide_keyboard,totalTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement closeFindButton = driver.findElement(By.xpath("//*[@id='close_find_button']"));
            commandsMonitor.add(find_non_instrumented_element,totalTimeMeasure.get());

            commandTimeMeasure.set();
            closeFindButton.click();
            commandsMonitor.add(ClickOnNonInstrumentedElement,totalTimeMeasure.get());


            driver.context("WEBVIEW_1");

            commandTimeMeasure.set();
            AndroidElement autocomplete = driver.findElement(By.xpath("//*[@nodeName='A' and @text='Autocomplete']"));
            commandsMonitor.add(find_web_element,totalTimeMeasure.get());

            autocomplete.click();
            commandsMonitor.add(click_web_element,totalTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement searchElement = driver.findElement(By.xpath("//*[@name='search']"));
            commandsMonitor.add(find_web_element,totalTimeMeasure.get());

            commandTimeMeasure.set();
            searchElement.sendKeys("South");
            commandsMonitor.add(send_keys_web,totalTimeMeasure.get());

            commandTimeMeasure.set();
            driver.hideKeyboard();
            commandsMonitor.add(hide_keyboard,totalTimeMeasure.get());

            commandTimeMeasure.set();
            AndroidElement selectElement = driver.findElement(By.xpath("//*[@name='select']"));
            commandsMonitor.add(find_web_element,totalTimeMeasure.get());

            commandTimeMeasure.set();
            selectElement.click();
            commandsMonitor.add(click_web_element,totalTimeMeasure.get());


            driver.context("NATIVE_APP");

            commandTimeMeasure.set();
            AndroidElement chromeListElement = driver.findElement(By.xpath("//*[@text='Chrome']"));
            commandsMonitor.add(find_non_instrumented_element,totalTimeMeasure.get());

            commandTimeMeasure.set();
            chromeListElement.click();
            commandsMonitor.add(ClickOnNonInstrumentedElement,totalTimeMeasure.get());


            driver.context("NATIVE_APP");

            commandTimeMeasure.set();
            driver.hideKeyboard();
            commandsMonitor.add(hide_keyboard,totalTimeMeasure.get());


            commandTimeMeasure.set();
            driver.pressKeyCode(AndroidKeyCode.MENU);
            commandsMonitor.add(action_menu,totalTimeMeasure.get());

            commandTimeMeasure.set();
            findInPage = driver.findElement(By.xpath("//*[@text='Find in page']"));
            commandsMonitor.add(find_non_instrumented_element,totalTimeMeasure.get());

            commandTimeMeasure.set();
            findInPage.click();
            commandsMonitor.add(ClickOnNonInstrumentedElement,totalTimeMeasure.get());

            commandTimeMeasure.set();
            findQuery = driver.findElement(By.xpath("//*[@id='find_query']"));
            commandsMonitor.add(find_non_instrumented_element,totalTimeMeasure.get());

            commandTimeMeasure.set();
            findQuery.sendKeys("Autocomplete");
            commandsMonitor.add(send_keys_non_instrumented,totalTimeMeasure.get());

            commandTimeMeasure.set();
            driver.hideKeyboard();
            commandsMonitor.add(hide_keyboard,totalTimeMeasure.get());


            commandTimeMeasure.set();
            closeFindButton = driver.findElement(By.xpath("//*[@id='close_find_button']"));
            commandsMonitor.add(find_non_instrumented_element,totalTimeMeasure.get());

            commandTimeMeasure.set();
            closeFindButton.click();
            commandsMonitor.add(ClickOnNonInstrumentedElement,totalTimeMeasure.get());

            driver.context("WEBVIEW_1");


            driver.findElement(By.xpath("//*[@nodeName='A' and @text='Click Counter']")).click();

            driver.findElement(By.xpath("//*[@nodeName='BUTTON' and @text='Click Here']")).click();

            driver.findElement(By.xpath("//*[@nodeName='SPAN' and @id='counter']"));

            new TouchAction(driver).press(937, 1711).waitAction(Duration.ofMillis(516)).moveTo(831, 433).release().perform();

            new TouchAction(driver).press(877, 451).waitAction(Duration.ofMillis(1024)).moveTo(940, 1657).release().perform();





        } finally {

            if (driver!=null) {
                commandTimeMeasure.set();
                driver.quit();
                commandsMonitor.add(quit_driver,commandTimeMeasure.get());
                commandsMonitor.add(androidTest,totalTimeMeasure.get());
            }
        }
    }
    private void runAndroidTest1( DesiredCapabilities dc,CommandsMonitor commandsMonitor, boolean takeScreenShots) throws MalformedURLException {
        TimeMeasure commandTimeMeasure =new TimeMeasure();
        TimeMeasure totalTimeMeasure =new TimeMeasure();


        String takeScreenShotsString = takeScreenShots ? "With Screenshots: " : "Without Screenshots: ";
        String initiate_driver_ = takeScreenShotsString+"Initiate Driver ";
        String quit_driver = takeScreenShotsString+"Quit Driver";



        String androidTest = takeScreenShotsString+"A.AndroidTest";
        totalTimeMeasure.set();
        try {
            try {
                commandTimeMeasure.set();
                driver = new AndroidDriver<>(new URL(HOST), dc);
                commandsMonitor.add(initiate_driver_,commandTimeMeasure.get());
            } catch (MalformedURLException e) {
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
                commandsMonitor.add(androidTest,totalTimeMeasure.get());
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