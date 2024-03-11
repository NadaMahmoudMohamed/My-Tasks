package core;

import base.PageObjectBase;
import io.appium.java_client.MobileDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import static utils.PropertiesLoader.readPropertyFile;
public class Hooks {
    private static MobileDriver driver;
    private static WebDriver webDriver;
    private final Config config = new Config();
    private DriverFactory factory;
    private String scenarioname;
    static Properties platformProp = readPropertyFile("config/platform.properties");
   // private static String platform = System.getenv("Platform");
   private static String platform= System.getProperty("PLATFORM", platformProp.getProperty("PLATFORM"));
    public Hooks() throws MalformedURLException {
        setDriver(driver);
        setWebDriver(webDriver);
    }

    public static MobileDriver getDriver() {
        return driver;
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }
    private static void setDriver(MobileDriver driver) {
        Hooks.driver = driver;
    }
    private static void setWebDriver(WebDriver webDriver) {Hooks.webDriver = webDriver;}

    @BeforeTest
    @Before(order = 1)
    @Parameters("browser")
    public void beforeAll(String browser) throws MalformedURLException {
        if (!config.isMobile()){if(webDriver==null) {
            WebDriverManager.chromedriver().reset();
            WebDriverManager.chromedriver().setup();
            if(browser.equalsIgnoreCase("firefox"))
                webDriver = new FirefoxDriver();
            else
                webDriver=new ChromeDriver();
            webDriver.manage().window().maximize();
        }
        } else {
            if (driver == null) {
                factory = new DriverFactory(config.getUrl(), config.getCapabilities());
                setDriver(factory.createDriver());
                BasicConfigurator.configure();
                PropertyConfigurator.configure("config/log4j2.xml");

            }        }
    }

    PageObjectBase base;
    @Before(order = 5)
    public void getScenarioName(Scenario scenario) {
        String[] tab = scenario.getId().split("/");
        int rawFeatureNameLength = tab.length;
        String featureName = tab[rawFeatureNameLength - 1].split(":")[0];
        scenarioname = featureName.replace(".", "") + scenario.getName().toString().replace(" ", "")+platform;

    }


    @After()
    public void takeScreenshotOnFail(Scenario scenario) {
        if (platform == "Android") {
            if (scenario.isFailed()) {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    String screenshotsPath = String.format((new File(System.getProperty("user.dir")) +
                            System.getProperty("Screenshots", platformProp.getProperty("Screenshots"))), scenarioname);
                    FileUtils.copyFile(scrFile, new File(screenshotsPath));
                    TakesScreenshot ts = (TakesScreenshot) driver;
                    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/jpeg", scenarioname);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (platform == "ios") {
            if (scenario.isFailed()) {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    String screenshotsPath = String.format((new File(System.getProperty("user.dir")) +
                            System.getProperty("Screenshots", platformProp.getProperty("Screenshots"))), scenarioname);
                    FileUtils.copyFile(scrFile, new File(screenshotsPath));
                    TakesScreenshot ts = (TakesScreenshot) driver;
                    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/jpeg", scenarioname);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

   @AfterClass()
    public void quitDriver() {
            driver.quit();
    }

}
