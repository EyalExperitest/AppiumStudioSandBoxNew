package main.java.issues;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.logging.Level;

public class SA21436A {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA21436A";
    private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTUEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4Mzk5MTMxMjEsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.NDxf8DjL1TrXuFw6RpbLOBxTn0hVVPUCo3xc7xWknEw";

    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
//        dc.setCapability(MobileCapabilityType.UDID, "MWS0216817004401");
//        dc.setCapability(MobileCapabilityType.UDID, "0123456789ABCDEF");
        dc.setCapability(MobileCapabilityType.UDID, "1115fb3c0e5f3c03");

        dc.setBrowserName(MobileBrowserType.CHROME);
        dc.setCapability("accessKey", accessKey);

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
//        driver = new AndroidDriver<>(new URL("http://mastercloud:80/wd/hub"), dc);

        //driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testSA21436A() {
//        driver.get("https://google.com");
        driver.get("https://www.wikipedia.org/");
        Set<Cookie> cookies0 = driver.manage().getCookies();
        Set<Cookie> cookies = driver.manage().getCookies();

        System.out.println("All Cookies:");
        for(Cookie c : cookies) {
            System.out.println("["+c.getName()+":"+c.getValue()+"]");
        }
        driver.manage().deleteAllCookies();
        System.out.println("All Cookies After Deletion:");
        cookies = driver.manage().getCookies();
        for(Cookie c : cookies) {
            System.out.println("["+c.getName()+":"+c.getValue()+"]");
        }
        for(Cookie c : cookies0) {
            driver.manage().addCookie(c);
        }
        System.out.println("All Cookies After Restoring:");
        cookies = driver.manage().getCookies();
        for(Cookie c : cookies) {
            System.out.println("["+c.getName()+":"+c.getValue()+"]");
        }
        Cookie someCookie=new Cookie("someCookie", "value00");
        driver.manage().addCookie(someCookie);
        System.out.println("All Cookies After Adding SomeCookie:");
        cookies = driver.manage().getCookies();
        for(Cookie c : cookies) {
            System.out.println("["+c.getName()+":"+c.getValue()+"]");
        }

        Cookie someCookie2 = driver.manage().getCookieNamed("someCookie");
        System.out.println("someCookie2.toString:"+someCookie2.toString());
        driver.manage().deleteCookieNamed("someCookie");
        System.out.println("All Cookies After Deleting SomeCookie:");
        cookies = driver.manage().getCookies();
        for(Cookie c : cookies) {
            System.out.println("["+c.getName()+":"+c.getValue()+"]");
        }
        driver.manage().addCookie(someCookie);
        Cookie someCookie3 = driver.manage().getCookieNamed("someCookie");
        String value = someCookie3.getValue();
        System.out.println("Value : "+value);
        driver.manage().deleteCookie(someCookie);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}