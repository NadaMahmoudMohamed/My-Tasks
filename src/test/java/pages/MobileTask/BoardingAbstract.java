package pages.MobileTask;
import java.net.MalformedURLException;
public abstract class BoardingAbstract extends BoardingPO {
    public BoardingAbstract() throws MalformedURLException {        super();    }
    public abstract void startMinimalSetup();
    public abstract void startOneStepOnePerm();
    public abstract void OnboardingSteps();
    public abstract String onBoardingEnteryPointGetText();
    public abstract void startMinimalSetupWithoutPerm();
    public abstract void startMinimalSetupWithoutTobi();
    public abstract void clickOnAgreeTermsAndConditions();
    public abstract void clickOnTermsContinueBtn();
    public abstract boolean OverlayIsDisplayed();
    public abstract boolean checkContinueIsClickable();
    public abstract boolean letsGoBtnClickable();
    public abstract void clickOnLetsGoBtn();
    public abstract void clickOnContinueBtn();
    public abstract void clickOnNotNowBtn();
    public abstract boolean PermissionsAreDisplayed();
    public abstract boolean PersonalisedIsDisplayed();
    public abstract boolean turnOffAllToggle();
    public abstract void clickOnIamHappyWithThis();
    public abstract String getTextCongratulations();
    public abstract boolean TobiIsDisplayed();
    public abstract boolean ClappingIsDisplayed();
    public abstract void UsageOnBoarding();
    public abstract boolean GetStartedIsClickable();
    public abstract void clickOnGetStarted();
    public abstract void setDeviceInDarkMode();
    public abstract int indicationCount();
}
