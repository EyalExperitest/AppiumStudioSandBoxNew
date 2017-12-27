package main.java.issues;

//package <set your test package>;

import io.appium.java_client.android.AndroidKeyCode;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SA19372 {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "SA19372";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "17b3dcc17d43");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testSA19372() {
        int[] keyCodes = {
                1142, 15, 173, 98, 110, 189, 253, 259, 13, 107, 111, 170, 178, 1228, 171, 184, 18, 175, 159, 156, 120, 164, 254, 69, 21, 8192, 215, 106, 236, 169, 2097152, 144, 81, 4194304, 121, 172, 57, 30, 136, 52, 42, 116, 176, 154, 50, 205, 32, 1, 16, 29, 31, 108, 1198, 79, 91, 150, 75, 1197, 179, 252, 102, 206, 89, 49, 8, 105, 221, 214, 24, 0, 1227, 97, 174, 101, 226, 151, 73, 14, 3, 147, 204, 113, 224, 16384, 117, 58, 212, 5, 77, 218, 1200, 84, 12, 66, 213, 131, 188, 63, 103, 114, 45, 255, 233, 128, 1199, 458752, 51, 145, 26, 250, 246, 43, 44, 186, 153, 64, 256, 220, 187, 152, 7, 163, 53, 83, 41, 94, 210, 23, 74, 195, 135, 223, 86, 115, 211, 182, 192, 1203, 25, 249, 139, 6, 10, 229, 129, 247, 93, 241, 11, 238, 166, 207, 161, 240, 68, 37, 234, 19, 78, 47, 87, 185, 209, 28672, 82, 155, 90, 71, 258, 180, 137, 28, 225, 59, 222, 67, 132, 235, 158, 196, 162, 96, 194, 130, 4, 243, 512, 118, 219, 133, 183, 1202, 70, 165, 61, 248, 193, 95, 177, 216, 65536, 36, 231, 1024, 126, 65, 112, 38, 239, 55, 2, 60, 232, 262144, 40, 181, 127, 131072, 100, 123, 104, 208, 138, 244, 167, 134, 4096, 99, 149, 34, 157, 124, 217, 109, 143, 1048576, 122, 88, 80, 92, 17, 257, 22, 9, 1140, 1201, 119, 72, 190, 85, 76, 54, 35, 1141, 125, 146, 168, 46, 39, 191, 148, 56, 251, 33, 242, 230, 62, 20, 237, 27, 48, 245, 160
        };
        for (int key : keyCodes) {
            try {
                driver.pressKeyCode(key);
            } catch (Exception e) {
                Pattern pattern = Pattern.compile("(?<=keycode\\=\\')\\d+");
                Matcher match = pattern.matcher(e.getMessage());
                if (match.find()) {
                    System.out.println(match.group());
                } else {
                    System.out.println(key+":");
                        e.printStackTrace();
                }
            }


        }

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}