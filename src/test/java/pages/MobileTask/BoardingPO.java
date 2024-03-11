package pages.MobileTask;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.CommonPO;

import java.net.MalformedURLException;
import java.util.List;

public class BoardingPO extends CommonPO {

    public BoardingPO() throws MalformedURLException {
        super();
    }

    @FindAll({
            @FindBy(how = How.ID, using = "homeItemButton"),
            @FindBy(how = How.CLASS_NAME, using = "UIAButton"),
            @FindBy(how = How.ID, using = "homeItemButtonBtn")
    })
    public List<WebElement> scenarioStartButton;

    @FindBy(how = How.ID, using = "homeItemButton0Btn")
    public WebElement minimalSetup;

    @FindBy(how = How.ID, using = "homeItemButton1Btn")
    public WebElement oneStepOnePermission;

    @FindBy(how = How.ID, using = "homeItemButton2Btn")
    public WebElement minimalSetupWithoutPermission;

    @FindBy(how = How.ID, using = "homeItemButton3Btn")
    public WebElement minimalSetupWithoutTobi;

    @FindAll({
            @FindBy(how = How.ID, using = "tobi_lottie_view"),
            @FindBy(how = How.ID, using = "Tobi"),
            @FindBy(how = How.ID, using = "OBtobiIcon")
    })
    public WebElement TobiView;

    @FindAll({
            @FindBy(how = How.ID, using = "terms_checkbox"),
            @FindBy(how = How.ID, using = "TermsToggle")
    })
    public WebElement agreecheckbox;

    @FindAll({
            @FindBy(how = How.ID, using = "terms_continue_button"),
            @FindBy(how = How.ID, using = "TermsContinueButton"),
            @FindBy(how = How.ID, using = "TermsContinueButtonBtn"),
            @FindBy(how = How.ID, using = "terms_continue_buttonBtn")

    })
    public WebElement continuetermsbtn;

    @FindAll({
            @FindBy(how = How.ID, using = "terms_view"),
            @FindBy(how = How.ID, using = "quickActionMainView"),
            @FindBy(how = How.ID, using = "TermsTermsTitle")
    })
    public WebElement TermsOverlay;

    @FindAll({
            @FindBy(how = How.ID, using = "OBstartButton"),
            @FindBy(how = How.ID, using = "OBstartButtonBtn"),
            @FindBy(how = How.XPATH, using = "//*[@name='OBstartBtn']")

    })
    public WebElement letsGoBtn;

    @FindAll({
            @FindBy(how = How.ID, using = "OBcontinueButton"),
            @FindBy(how = How.ID, using = "OBcontinueButton0Btn"),
            @FindBy(how = How.ID, using = "OBcontinueButton1Btn"),
            @FindBy(how = How.ID, using = "OBcontinueButton2Btn"),
            @FindBy(how = How.XPATH, using = "//*[@text='Continue ']"),
            @FindBy(how = How.XPATH, using = "//*[@name='OBcontinue']")

    })
    public WebElement continueBtn;

    @FindAll({
            //android
            @FindBy(how = How.ID, using = "OBnoButton"),
            @FindBy(how = How.ID, using = "OBnotNowButton0Btn"),
            @FindBy(how = How.ID, using = "OBnotNowButton1Btn"),
            @FindBy(how = How.ID, using = "OBnotNowButton2Btn"),
            @FindBy(how = How.XPATH, using = "//*[@text='not now']")
    })
    public WebElement notNowBtn;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Permissions for improved experience']"),
            @FindBy(how = How.XPATH, using = "//*[@name='OBpermissionsStepTitle']"),
            @FindBy(how = How.ID, using = "OBpermissionsStepTitle")
    })
    public WebElement permissionsStep;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Personalised services and recommendations']")
    })
    public WebElement PersonalisedServices;

    @FindBy(how = How.ID, using = "permission_toggle")
    public List<WebElement> PermissionToggle;

    @FindAll({
            @FindBy(how = How.ID, using = "OBhappyButtonBtnBtn"),
            @FindBy(how = How.ID, using = "OBhappyButton"),
            @FindBy(how = How.XPATH, using = "//*[@name='OBhappyBtn']")
    })
    public WebElement IamHappyWithThis;

    @FindAll({
            @FindBy(how = How.ID, using = "OBcongratulationsTitle"),
            @FindBy(how = How.XPATH, using = "//*[@name='OBcongratulationsTitle']")
    })
    public WebElement Congratulations;

    @FindAll({
            @FindBy(how = How.ID, using = "onboardingFinalizingIcon"),
            @FindBy(how = How.ID, using = "clapping"),
            @FindBy(how = How.CLASS_NAME, using = "UIAImage")
    })
    public WebElement clappingIcon;
    @FindAll({
            @FindBy(how = How.ID, using = "OBgetStartedButton"),
            @FindBy(how = How.ID, using = "OBgetStartedButtonBtn"),
            @FindBy(how = How.XPATH, using = "//*[@name='OBgestarted']")
    })
    public WebElement getStarted;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Change in Android settings']"),
    })
    public WebElement androidSettings_React;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@id='apps_list']/*/*[@class='android.widget.LinearLayout' and ./*[@text='MVA10 React']])[2]"),
    })
    public WebElement androidSettings_React_AppName;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@id='switch_widget']"),
    })
    public WebElement androidSettings_React_UsageToggle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@contentDescription='Navigate up']"),
    })
    public WebElement androidSettings_React_BackBtn;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Not now']"),
    })
    public WebElement usageNotNow_React_BackBtn;

    //Hend changes
    @FindAll({
            @FindBy(how = How.ID, using = "stepIndicator"),
            @FindBy(how = How.XPATH, using = "//*[@class='UIAImage' and (./preceding-sibling::* | ./following-sibling::*)]")
    })
    public List<WebElement> stepIndicator;
}
