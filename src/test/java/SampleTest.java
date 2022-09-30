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
    AppiumDriver driver;

    @BeforeTest
    public void initializer() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
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
