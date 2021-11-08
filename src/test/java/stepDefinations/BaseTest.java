package stepDefinations;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import basePage.BasePage;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest extends BasePage {

    private final String CHROME = "chrome-local";
    private final String BROWSERSTACK = "chrome";
    private final String FIREFOX = "firefox";
    private final String EDGE = "edge";
    private static final String url = "https://www.takealot.com/";
    private final String browser = getBrowser();
    public static final String AUTOMATE_USERNAME = "suneethan_U4jh5R";
    public static final String AUTOMATE_ACCESS_KEY = "QYnqvhQnTZMJ4Dsycx6B";
    public static final String REMOTE_URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Before
    public void setUp() throws MalformedURLException {
        openBrowser(url);
    }

    @After
    public void tearDown() {
       closeBrowser();
    }

    public void openBrowser(String url) throws MalformedURLException {
        if (!(browser.contains("api"))) {
            switch (browser) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "jars\\chromedriver95.exe");
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "jars\\.exe");
                    driver = new FirefoxDriver();
                    break;
                case EDGE:
                    System.setProperty("webdriver.edge.driver", "jars\\.exe");
                    driver = new EdgeDriver();
                    break;
                case BROWSERSTACK:
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browserName", browser);
                caps.setCapability("browserstack.debug", "true");
               driver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
               break;
            }

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.navigate().to(url);
        }

    }

    protected void closeBrowser() {
        if (!(browser.contains("api"))) {
            driver.close();
            driver.quit();
        }
    }

    public String getBrowser() {
        return System.getProperty("browser").toLowerCase();
    }

}
