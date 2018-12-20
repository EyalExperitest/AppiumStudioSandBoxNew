package main.java.manager;

//package <set your test package>;

import com.experitest.reporter.junit5.SeeTestReporterExceptionExtension;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

@ExtendWith(SeeTestReporterExceptionExtension.class)
public class SA26036_JUnit5_Android_extended extends SA26036_JUnit5_Android_Base{


    @Test
    public void testUntitled() throws Exception {
        throw (new Exception("A Random Extended Exception"));

    }


}