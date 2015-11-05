package Parallel.GridDriver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected ThreadLocal<WebDriver> threadDriver = null;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        threadDriver = new ThreadLocal<>();
        URL hubUrl = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        threadDriver.set(new RemoteWebDriver(hubUrl, dc));
    }

    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

}