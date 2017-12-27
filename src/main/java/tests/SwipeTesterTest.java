package main.java.tests;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class SwipeTesterTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SwipeTesterTest";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "09d07a6a");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.qa.experitest.swipetester");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".FullscreenActivity");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSwipeTesterTest() {
         Dimension dimension = getDimension();
        System.out.println("Height : "+dimension.getHeight());
        System.out.println("Width : "+dimension.getWidth());


        int x1In = 400;
        int y1In = 1824;
        int x2In = 800;
        int y2In = 1915;


        testSwipe(x1In, y1In, x2In, y2In);

        Random randomGenerator = new Random();

        for(int i=0;i<0;i++){
            System.out.println("Test : "+i);
            x1In=randomGenerator.nextInt(dimension.getWidth());
            x2In=randomGenerator.nextInt(dimension.getWidth());
            y1In=randomGenerator.nextInt(dimension.getHeight());
            y2In=randomGenerator.nextInt(dimension.getHeight());
            testSwipe(x1In, y1In, x2In, y2In);
        }





    }

    private void testSwipe(int x1In, int y1In, int x2In, int y2In) {
       // driver.swipe(x1In, y1In, x2In, y2In, 2000);
        driver.context("NATIVE_APP");
        String x1String = driver.findElement(By.id("X1")).getText();
        String y1String = driver.findElement(By.id("Y1")).getText();
        String x2String = driver.findElement(By.id("X2")).getText();
        String y2String = driver.findElement(By.id("Y2")).getText();
        int x1Out=(int)Double.parseDouble(x1String);
        int x2Out=(int)Double.parseDouble(x2String);
        int y1Out=(int)Double.parseDouble(y1String);
        int y2Out=(int)Double.parseDouble(y2String);

        System.out.println("Command: X1:"+x1In+" Y1:"+y1In+" X2:"+x2In+" Y2:"+y2In);
        System.out.println("Result : X1:"+x1Out+" Y1:"+y1Out+" X2:"+x2Out+" Y2:"+y2Out);
        assertEquals(x1In,x1Out);
        assertEquals(x2In,x2Out);
        assertEquals(y1In,y1Out);
        assertEquals(y2In,y2Out);
    }

    private Dimension getDimension() {
        Object result1 = driver.executeScript("client:client.getDeviceProperty( \"device.screensize\" );");
        String resultString = result1.toString();
        //System.out.println(resultString);
        String[] splitResult = resultString.replace("{", "").replace("}", "").replace("\"", "").split(",");
        String screenSizeString="";
        for (String keyValue:splitResult){
            String[] splitKeyValue = keyValue.split(":");
            //System.out.println("key: "+splitKeyValue[0]);
           // if (splitKeyValue.length==2) System.out.println("value: "+splitKeyValue[1]);

            if(splitKeyValue[0].equals("text")&&splitKeyValue.length==2){
                screenSizeString=splitKeyValue[1];
                //System.out.println("screenSizeString : "+screenSizeString);

            }
        }

        //System.out.println("screenSizeString : "+screenSizeString);
        String[] widthHeight = screenSizeString.split("x");
        int width = Integer.parseInt(widthHeight[0]);
        int height= Integer.parseInt(widthHeight[1]);
        return new Dimension(width, height);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}