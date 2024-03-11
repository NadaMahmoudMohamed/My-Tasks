package core;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import rst.pdfbox.layout.elements.Orientation;

import static java.lang.Integer.parseInt;
import static java.lang.System.getProperty;
import static utils.PropertiesLoader.readPropertyFile;

public class Config {
    private final Map<String, Object> capabilities = new HashMap<>();
    private boolean isAndroid;
    private boolean isIos;
    private boolean isMobile;
    public static final String WORKSPACE = getProperty("user.dir");
    private String url;
    Properties iosProp = readPropertyFile("config/ios.properties");
    Properties androidProp = readPropertyFile("config/android.properties");
    Properties platformProp = readPropertyFile("config/platform.properties");
   private String accesskey = System.getProperty("accessKey", platformProp.getProperty("accessKey"));
  //  private String accesskey = System.getenv("AccessKey");
    private String platform = System.getProperty("PLATFORM", platformProp.getProperty("PLATFORM"));
  //  private String platform = System.getenv("MOBILE_PLATFORM");
    public Config() throws MalformedURLException {
        Logger.getLogger("org.openqa.core.remote").setLevel(Level.OFF);
        url = "https://tscloud.vodafone.com/wd/hub";
        setCapabilitiesForPlatform(platform);
        System.out.println("Platform is: "+platform);
    }

    public void setup(@Optional("android") String platform) throws MalformedURLException {
        switch (platform.toUpperCase()) {
            case "ANDROID":
                setAndroidCapabilities();
                break;
            case "IOS":
                setIosCapabilities();
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Driver Factory type not implemented: [%s]", platform));

        }
    }

    private void setIosCapabilities() {
        if (platformProp.getProperty("cloud").equalsIgnoreCase("true")) {
            capabilities.put("testName", "MVA10AutomationIOS");
            capabilities.put("accessKey", accesskey);
            capabilities.put("deviceQuery", "@os='ios' and @version='15.7.2'");
            // capabilities.put("deviceQuery", "@os='ios' and @name='" + iosProp.getProperty("DEVICE_NAME") + "'");
           // capabilities.put("deviceQuery", "@os='ios' and @version='15.7.2' and @name='" + iosProp.getProperty("DEVICE_NAME") + "'");
            capabilities.put(MobileCapabilityType.APP, iosProp.getProperty("CloudAPP"));
            capabilities.put("autoAcceptAlerts", "true");
            capabilities.put(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
        } else {
            url = getProperty("seleniumGrid", "http://0.0.0.0:4723/wd/hub");
            capabilities.put("deviceName", iosProp.getProperty("DEVICE_NAME"));
            capabilities.put("systemPort", parseInt(getProperty("systemPort", "8200")));
            capabilities.put("platformVersion", iosProp.getProperty("PLATFORM_VERSION"));
            capabilities.put("app", System.getProperty("APP", iosProp.getProperty("APP")));
            capabilities.put("automationName", "XCUITest");
            capabilities.put("udid", System.getProperty("UDID", iosProp.getProperty("UDID")));
            capabilities.put("newCommandTimeout", 90000);
            capabilities.put("adbExecTimeout", 200000);
            capabilities.put("platformName", "iOS");
            capabilities.put("instrumentApp", true);

        }
        capabilities.put("fullReset", true);
        capabilities.put("noReset", false);
        capabilities.put("autoGrantPermissions", true);
    }

    private void setAndroidCapabilities() throws MalformedURLException {
        if (platformProp.getProperty("cloud").equalsIgnoreCase("true")) {
            capabilities.put("testName", "MVA10AutomationAndroid");
            capabilities.put("accessKey", accesskey);
            capabilities.put("deviceQuery", "@os='android' and @VERSION='9.0'");
            // and @name='" + androidProp.getProperty("DEVICE_NAME") + "'");
         //   capabilities.put("deviceQuery", "@os='android' and @VERSION='9.0' and @name='" + androidProp.getProperty("DEVICE_NAME") + "'");
            capabilities.put(MobileCapabilityType.APP, androidProp.getProperty("cloudApp"));
            capabilities.put("deviceOrientation" , "PORTRAIT");

        } else {
            url = System.getProperty("seleniumGrid", "http://0.0.0.0:4723/wd/hub");
            capabilities.put("deviceName", System.getProperty("DEVICE_NAME", androidProp.getProperty("DEVICE_NAME")));
            capabilities.put("systemPort", parseInt(getProperty("systemPort", "8200")));
            capabilities.put("appiumVersion", "1.21.0");
            capabilities.put("platformVersion", System.getProperty("PLATFORM_VERSION", androidProp.getProperty("PLATFORM_VERSION")));
            capabilities.put("app", System.getProperty("user.dir") + System.getProperty("APP", androidProp.getProperty("APP")));
            capabilities.put("autoGrantPermissions", true);
            capabilities.put("autoAcceptAlerts", true);
            capabilities.put("newCommandTimeout", 90000);
            capabilities.put("androidInstallTimeout", 90000);
            capabilities.put("uiautomator2ServerInstallTimeout", 120000);
            capabilities.put("adbExecTimeout", 200000);
            capabilities.put("platformName", "Android");
            capabilities.put("automatorName", "UiAutomator2");
            capabilities.put("noSign", "true");
        }
        capabilities.put("fullReset", true);
        capabilities.put("noReset", false);
    }

    private void setCapabilitiesForPlatform(String platform) throws MalformedURLException {
        isAndroid = platform.equalsIgnoreCase("Android");
        isIos = platform.equalsIgnoreCase("iOS");
        if (isAndroid || isIos) isMobile = true;
        if (isAndroid) setAndroidCapabilities();
        if (isIos) setIosCapabilities();
    }

    //////////////////
    // Get and Sets //
    //////////////////
    String getPlatform() {
        return platform;
    }

    public Map<String, Object> getCapabilities() {
        return capabilities;
    }

    public String getUrl() {
        return url;
    }

    public boolean isAndroid() {
        return isAndroid;
    }

    public boolean isIos() {
        return isIos;
    }

    public boolean isMobile() {
        return isMobile;
    }
}
