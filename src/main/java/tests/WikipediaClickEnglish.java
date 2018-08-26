package main.java.tests;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

public class WikipediaClickEnglish {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "WikipediaClickEnglish";
    protected AndroidDriver<AndroidElement> driver = null;
    private String accessKey = "eyJ4cC51IjoyMTc2LCJ4cC5wIjoyLCJ4cC5tIjoiTVRRNU9USXpPRE0zTkRrek9RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2NzIxMzI4NTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.na315fDIXdpqkRVem7V1vbiHnST4I7Ee3vYMIpBb11A";
    //private String accessKey = "eyJ4cC51Ijo3LCJ4cC5wIjoyLCJ4cC5tIjoiTVRVd09UVXlPVEl3TWpreE53IiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MjQ4OTIwNzAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.icG-vUduTupsyGxjkOqK82j3yEa5f6311NZo6gHnmDM";
    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);

        //dc.setCapability(MobileCapabilityType.UDID, "008578c8dd0dd353");
        //dc.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
        //dc.setCapability(MobileCapabilityType.UDID, "CB5A25AM17");

        dc.setCapability(MobileCapabilityType.UDID, "CB5A2BSDEE");



//        dc.setBrowserName(MobileBrowserType.CHROMIUM);
//        dc.setBrowserName("chrome");
        dc.setCapability("browserName", "Chrome");
        //driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver = new AndroidDriver<>(new URL("https://qacloud.experitest.com:443/wd/hub"), dc);
        //driver = new AndroidDriver<>(new URL("http://192.168.1.64:80/wd/hub"), dc);


        //driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testWikipediaClickEnglish() {
        driver.get("https://www.wikipedia.org/");
        driver.context("WEBVIEW_1");
        String xpathExpressionChromium = "//*[@nodeName='STRONG' and @text='English']";
        String xpathExpressionChrome ="//*[@id=\"js-link-box-en\"]/strong";
        String english = xpathExpressionChrome;
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(english)));
        driver.findElement(By.xpath(english)).click();
/*        List<AndroidElement> elements = driver.findElements(By.cssSelector("#mw-mf-main-menu-button"));
        System.out.println("Elements Found :"+elements.size());
        for(AndroidElement element:elements){
            System.out.println("Text:"+element.getText());
            //System.out.println("Text css:"+element.getCssValue("text"));
        }*/
        try {
            String text = driver.findElement(By.cssSelector("#mw-mf-main-menu-button")).getText();
            System.out.println("Text:"+text);

        } catch (Exception e) {
            e.printStackTrace();
        }
        String pageSource = driver.getPageSource();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}