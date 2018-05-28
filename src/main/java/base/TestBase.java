package base;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("Browser")
    public void testInitialize(@Optional String browserName) throws IllegalAccessException {
        if (browserName == null){
            browserName = "chrome";
        }

        if (browserName.contentEquals("chrome")){
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        else if (browserName.contentEquals("headless")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        }
        else if (browserName.contentEquals("grid_chrome")){
            try {
                String nodeURL = "http://172.17.67.65:4444/wd/hub";
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
                capabilities.setPlatform(org.openqa.selenium.Platform.WIN10);
                driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else if (browserName.contentEquals("mobile")){
            Map<String, String> mobileEmulation = new HashMap<String, String>();
            mobileEmulation.put("deviceName", "Galaxy S5");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            driver = new ChromeDriver(chromeOptions);
        }
        else if (browserName.contentEquals("firefox")){
            driver = new FirefoxDriver();
        }
        else if (browserName.contentEquals("ie")){
            driver = new InternetExplorerDriver();
        }
        else {
            throw new IllegalAccessException("Unknown browser");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void testCleanup(){
        driver.quit();
    }

    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        long time = date.getTime();
        Files.copy(scrFile, new File(String.format("screenshots\\scr_%s.png", time)));
    }
}
