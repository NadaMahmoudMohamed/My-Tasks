package base;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import core.Config;
import core.Hooks;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPO;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static utils.PropertiesLoader.readPropertyFile;

public abstract class PageObjectBase {
    public MobileDriver driver;
    public WebDriver webDriver;
    Properties platformProp = readPropertyFile("config/platform.properties");
    private TouchAction touchAction;
    public Eyes eyesApplitools;
    public String applitoolsKey;
    WebDriverWait wait;
    //CommonPO commonPO= new CommonPO();

    public PageObjectBase() throws MalformedURLException {
        applitoolsKey = System.getProperty("applitoolsKey", platformProp.getProperty("applitoolsKey"));
        this.driver = Hooks.getDriver();
        this.webDriver = Hooks.getWebDriver();
        setDecoratorBasedOnPlatform();
        wait = new WebDriverWait(driver, 30);
    }

    private void setDecoratorBasedOnPlatform() throws MalformedURLException {
        Config config = new Config();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if (config.isMobile()) setAppiumDecorator();
        else webDriver.get("https://practice.automationtesting.in/");
    }


    private void setAppiumDecorator() {
        AppiumFieldDecorator appiumFieldDecorator =
                new AppiumFieldDecorator(driver, Duration.ofSeconds(3));
        PageFactory.initElements(appiumFieldDecorator, this);
    }

    public void resetAndroid() {
        driver.resetApp();
    }

    public void resetIOS(String bundleId) {
        if (driver.isAppInstalled(bundleId)) {
            driver.resetApp();
            try {
                Boolean x = (Boolean) driver.removeApp(bundleId);
                System.out.println("Boolean value is " + x);
                driver.installApp(bundleId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.launchApp();
            try {
                WebElement overlaysec = driver.findElement(By.xpath("//*[@text='Horizontal scroll bar, 1 page' and (./preceding-sibling::* | ./following-sibling::*)[./*[@class='UIAView']]]"));
                if (overlaysec.isDisplayed())
                    overlaysec.click();
            } catch (Exception e) {
                System.out.println("element overlay not exist");
            }
        } else {
            WebElement overlaysec = driver.findElement(By.xpath("//*[@text='Horizontal scroll bar, 1 page' and (./preceding-sibling::* | ./following-sibling::*)[./*[@class='UIAView']]]"));
            if (overlaysec.isDisplayed())
                overlaysec.click();
            driver.launchApp();
        }
    }

    public void initializingEyes() {
        eyesApplitools = new Eyes();
        eyesApplitools.setApiKey(applitoolsKey);
    }

    public void validateFrameByApplitools(String websiteName, String testName, WebElement frame) {
        initializingEyes();
        eyesApplitools.open(driver, websiteName, testName);
        //eyes.setMatchLevel(MatchLevel.STRICT);
        //eyes.setMatchLevel(MatchLevel.CONTENT);
        eyesApplitools.setMatchLevel(MatchLevel.EXACT);
        //eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyesApplitools.checkFrame(frame);
        eyesApplitools.close();
    }

    public void swipeFunction(double sX, double sy, double eX, double eY) {

        //TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * sX);
        int startY = (int) (size.height * sy);

        int endX = (int) (size.width * eX);
        int endY = (int) (size.height * eY);
        new TouchAction(driver).press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();


    }

    public void waitForVisibility(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            System.out.println(element + "Element not Visible");
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException e) {
            System.out.println(element + "Element not Clickable");
        }
    }

    public void Scrolling(WebElement element) {
        boolean end_of_page = false;
        String source_page = driver.getPageSource();
        while (!end_of_page) {
            if (elementDisplayed(element)) {
                return;
            }
            Dimension dimension = driver.manage().window().getSize();
            int scrollStart = (int) (dimension.getHeight() * 0.9);
            int scrollEnd = (int) (dimension.getHeight() * 0.3);
            new TouchAction(driver)
                    .press(PointOption.point(0, scrollStart))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(0, scrollEnd)).release().perform();
            end_of_page = source_page.equals(driver.getPageSource());
            source_page = driver.getPageSource();
        }
    }

    private void tapOnPoint(int fromX, int fromY) {
        touchAction = new TouchAction(driver);
        try {
            touchAction.tap(PointOption.point(fromX, fromY)).release().perform();
        } catch (NoSuchElementException e) {
            System.out.println("Cannot tab on this point");
            e.printStackTrace();
        }
    }

    public void clickOnPartOfElement(WebElement element, double partX, double partY) {
        waitForVisibility(element);
        int sizeX = 0;
        int sizeY = 0;
        if (partX != 0)
            sizeX = (int) Math.round((partX * element.getSize().getWidth()));
        if (partY != 0)
            sizeY = (int) Math.round((partY * element.getSize().getHeight()));
        int fromX = getElementLocation(element).getX() + sizeX;
        int fromY = getElementLocation(element).getY() + sizeY;
        tapOnPoint(fromX, fromY);
    }

    public boolean elementDisplayed(WebElement element) {
        boolean isDisplyed = false;
        try {
            // waitForVisibility(element);
            isDisplyed = element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Element not Displayed " + element);
            e.printStackTrace();
            isDisplyed = false;
        }
        return isDisplyed;
    }

    public Point getElementLocation(WebElement element) {
        return element.getLocation();
    }

    public String getElementText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    public void sendText(WebElement element, String Text) {
        waitForVisibility(element);
        element.click();
        element.sendKeys(Text);
        driver.hideKeyboard();
    }

    public void clickOnElement(WebElement element) {

        try {
            waitForVisibility(element);
            waitForElementToBeClickable(element);
            element.click();
        } catch (NoSuchElementException e) {
            System.out.println("Element not exist to Click on" + element);
        }
    }

    public boolean checkElementIsActive(WebElement element) {
        try {
            waitForVisibility(element);
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void goBackAndroid() {
        driver.navigate().back();
    }

    public void killAndReopen() {
        driver.closeApp();
        driver.launchApp();
    }

    public void runAppinBackroundandReopen(int timeinSeconds, String bundleId) {
        driver.runAppInBackground(Duration.ofSeconds(timeinSeconds));
        //driver.activateApp("com.vodafone.mva10.test");
        driver.activateApp(bundleId);
    }

    @Deprecated
    public void sendAndroidAppToBackground() {
      //  ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.HOME);
        try {
            ((AndroidDriver) driver).startActivity(new Activity("com.android.settings", ".Settings"));
        }
        catch (Exception e)
        {
            System.out.println("Start Activity Exception");
        }

    }

    public boolean findElement(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollHorizontalToInvisibleElement(WebElement element) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int endx = (int) (size.width * 0.8); // lazem aghyar l scrolling
        int endy = (int) (size.height - size.height / 4);

        int startx = (int) (size.width * 0.2);
        int starty = (int) (size.height - size.height / 4);

        while (!findElement(element)) {

            action.press(PointOption.point(startx, starty))
                    .waitAction(WaitOptions
                            .waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endx, endy)).release().perform();
        }

        // driver.execute("mobile: pressButton", ImmutableMap.of("name","home"));

    }
    public void changeToAndroidDarkMode(WebElement displayMode,WebElement darkMode , WebElement advanced , WebElement theme , WebElement dark)
    {
        sendAndroidAppToBackground();
        Scrolling(displayMode);
        clickOnElement(displayMode);
        //clickOnElement(darkMode);
        try {
            if(darkMode.getAttribute("checked").equals("false"))
                clickOnElement(darkMode);
            else{
                System.out.println("Dark mode already applied");
            }
        }
        catch (Exception e){
//            clickOnElement(advanced);
//            clickOnElement(theme);
//            clickOnElement(dark);
        }
       // driver.runAppInBackground(Duration.ofSeconds(1));
        driver.launchApp();

    }
    public void changeToiOSDarkMode (WebElement settings, WebElement display, WebElement darkMode , WebElement devicesettings)
    {
        sendiOSAppToBackground(-1);
        scrollHorizontalToInvisibleElement(settings);
        clickOnElement(settings);
        Scrolling(display);
        clickOnElement(display);
        clickOnElement(darkMode);
        clickOnElement(devicesettings);
        driver.launchApp();
       // sendiOSAppToBackground(1);
    }

    public void sendiOSAppToBackground ( int x){
        driver.runAppInBackground(Duration.ofSeconds(x));
        //  System.out.println("y rbbbbbbbbb yzhar");

    }
}
