package main.java.issues;
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.support.ui.Select;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;

public class SA18808 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA18808";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "e323acec7ba4322be383a7c431d8a7d8739b581b");
        dc.setBrowserName(MobileBrowserType.SAFARI);
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA18808_Scenario1() {
        driver.get("http://www.espn.com/mlb/standings");
        String pageSource1 = driver.getPageSource();
        IOSElement select = driver.findElement(By.xpath("//*[@type='select-one' and @value='Standings']"));
        Select dropdown = new Select(select);
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option:options) {
            System.out.println(option.getText());
        }
        dropdown.selectByValue("Expanded Standings");

    }
    @Test@Ignore
    public void testSA18808_Scenario2() {
//Scenario 2 - You might need to click on "Try it yourself" from https://www.w3schools.com/tags/att_select_multiple.asp if URL is invalid (file not found)
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
        driver.switchTo().frame("iframeResult");
        WebElement select = driver.findElement(By.xpath("//select"));
        Select dropdown = new Select(select);
        System.out.println(dropdown.isMultiple());
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option:options) {
            System.out.println(option.getAttribute("value"));
        }
        dropdown.selectByValue("volvo");
        dropdown.deselectByValue("volvo");

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}