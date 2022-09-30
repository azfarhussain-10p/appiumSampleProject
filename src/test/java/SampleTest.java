import configurationFileReader.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {

    ConfigReader configReader;

    public SampleTest() {
        configReader = new ConfigReader();
    }
    AppiumDriver driver;

    @BeforeTest
    public void initializer() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", configReader.getPlatformName());
        capabilities.setCapability("platformVersion", configReader.getPlatformVersion());
        capabilities.setCapability("deviceName", configReader.getDeviceName());
        capabilities.setCapability("automationName", configReader.getAutomationName());
        capabilities.setCapability("app", System.getProperty("user.dir") + configReader.getApkPath());
        driver = new AndroidDriver(new URL(configReader.appiumServerEndpointURL()), capabilities);
        System.out.println("Opening Appium Server");
    }

    @Test
    public void clickAppButton() {
        // Code
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
