package main.java.testrail.parallel;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

//package <set your test package>;

public class RunIOSDrivers {
    private static final int ITERATIONS = 5;
    private String host = "localhost";
    private int port = 4723;
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Run IOS Drivers";
    protected IOSDriver[] iosDrivers = null;
    private ASIOSDriverFactory[] aSIOSDriverFactories =null;
    private URL url;

    @Before
    public void setUp() throws MalformedURLException, InterruptedException {

        url =new URL("https://qacloud.experitest.com/wd/hub");
        String user ="eyal";
        String password ="Experitest2012";

        DesiredCapabilities iosDC = new DesiredCapabilities();
        iosDC.setCapability("reportDirectory", reportDirectory);
        iosDC.setCapability("reportFormat", reportFormat);
        iosDC.setCapability("testName",testName);
        //iosDC.setCapability(MobileCapabilityType.UDID, "74ee108a3e08509f1e8056aa1623d6a1a01dcb1f");
        //iosDC.setCapability(MobileCapabilityType.APP, "C:\\Users\\eyal.neumann\\AppData\\Roaming\\appiumstudio\\apk\\com.experitest.ExperiBank.1.ipa");
        iosDC.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        iosDC.setCapability("instrumentApp", true);
        iosDC.setCapability("user", user);
        iosDC.setCapability("password",password);

        aSIOSDriverFactories =new ASIOSDriverFactory[ITERATIONS];
        Thread[] aSIOSDriverFactoryThreads =new Thread[ITERATIONS];

        for (int i=0;i<ITERATIONS;i++){
            aSIOSDriverFactories[i] =      new ASIOSDriverFactory(url, iosDC);
            aSIOSDriverFactoryThreads[i] = new Thread (aSIOSDriverFactories[i]);
            aSIOSDriverFactoryThreads[i].setName("Initiating iOS Driver "+i);
        }

        for (int i=0;i<ITERATIONS;i++){
            aSIOSDriverFactoryThreads[i].start();
        }
        for (int i=0;i<ITERATIONS;i++){
            aSIOSDriverFactoryThreads[i].join();
        }
        for (int i=0;i<ITERATIONS;i++){
            iosDrivers[i]=aSIOSDriverFactories[i].getDriver();
        }

    }

    @Test
    public void testRunIOSDrivers() throws InterruptedException {
        ASDriverRunnerIOS[] asDriverRunnersIOS = new ASDriverRunnerIOS[ITERATIONS];
        Thread[] asDriverRunnerIOSThreads =new Thread[ITERATIONS];
        for (int i=0;i<ITERATIONS;i++){
            asDriverRunnersIOS[i] = new ASDriverRunnerIOS(iosDrivers[i],20);
            asDriverRunnerIOSThreads[i] =new Thread(asDriverRunnersIOS[i]);
            asDriverRunnerIOSThreads[i].setName("IOS Driver "+i);
        }

        for (int i=0;i<ITERATIONS;i++){
            asDriverRunnerIOSThreads[i].start();
        }
        for (int i=0;i<ITERATIONS;i++){
            asDriverRunnerIOSThreads[i].join();
        }





    }


    @After
    public void tearDown() {
        for (int i=0;i<ITERATIONS;i++){
            iosDrivers[i].quit();
        }

    }
}