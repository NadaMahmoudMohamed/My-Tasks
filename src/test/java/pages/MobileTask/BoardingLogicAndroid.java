package pages.MobileTask;

import java.net.MalformedURLException;

public class BoardingLogicAndroid extends BoardingAbstract {
    public BoardingLogicAndroid() throws MalformedURLException {
        super();
    }

    @Override
    public void startMinimalSetup() {
        clickOnElement(scenarioStartButton.get(0));
    }

    @Override
    public void startOneStepOnePerm() {
        clickOnElement(scenarioStartButton.get(1));
    }

    @Override
    public void startMinimalSetupWithoutPerm() {
        clickOnElement(scenarioStartButton.get(2));
    }

    @Override
    public void startMinimalSetupWithoutTobi() {
        clickOnElement(scenarioStartButton.get(3));
    }

    @Override
    public boolean OverlayIsDisplayed() {
        return elementDisplayed(TermsOverlay);
    }

    @Override
    public boolean checkContinueIsClickable() {
        return checkElementIsActive(continuetermsbtn);
    }

    @Override
    public void clickOnAgreeTermsAndConditions() {
        clickOnElement(agreecheckbox);
    }

    @Override
    public void clickOnTermsContinueBtn() {
        clickOnElement(continuetermsbtn);
    }

    @Override
    public boolean letsGoBtnClickable() {
        return checkElementIsActive(letsGoBtn);
    }

    @Override
    public void clickOnLetsGoBtn() {
        clickOnElement(letsGoBtn);
    }

    @Override
    public void clickOnContinueBtn() {
        clickOnElement(continueBtn);
    }

    @Override
    public void clickOnNotNowBtn() {
        clickOnElement(notNowBtn);
    }

    @Override
    public void UsageOnBoarding() {
        if (!androidSettings_React.isDisplayed()) {
            System.out.println("Not exist on android native");
        } else {
            clickOnElement(androidSettings_React);
            Scrolling(androidSettings_React_AppName);
            Scrolling(androidSettings_React_AppName);
            clickOnElement(androidSettings_React_AppName);
            clickOnElement(androidSettings_React_UsageToggle);
            clickOnElement(androidSettings_React_BackBtn);
            clickOnElement(androidSettings_React_BackBtn);
        }
    }

    @Override
    public boolean PermissionsAreDisplayed() {
        return elementDisplayed(permissionsStep);
    }

    @Override
    public boolean turnOffAllToggle() {
        boolean status = false;
        for (var permission : PermissionToggle) {
            if (!permission.isSelected()) {
                status = true;
            } else {
                status = false;
                break;
            }
        }
        return status;
    }

    @Override
    public boolean PersonalisedIsDisplayed() {
        Scrolling(PersonalisedServices);
        return elementDisplayed(PersonalisedServices);
    }

    @Override
    public void clickOnIamHappyWithThis() {
        Scrolling(IamHappyWithThis);
        clickOnElement(IamHappyWithThis);
    }

    @Override
    public String getTextCongratulations() {
        return getElementText(Congratulations);
    }

    @Override
    public boolean TobiIsDisplayed() {
        return elementDisplayed(TobiView);
    }

    @Override
    public boolean ClappingIsDisplayed() {
        return elementDisplayed(clappingIcon);
    }

    @Override
    public void clickOnGetStarted() {
        clickOnElement(getStarted);
    }

    @Override
    public boolean GetStartedIsClickable() {
        return checkElementIsActive(getStarted);
    }

    @Override
    public void setDeviceInDarkMode() {
        changeToAndroidDarkMode(displaymode, darkmode, advancedOptions, deviceTheme, darkmode);
    }

    //Hend Changes
    @Override
    public int indicationCount() {
        return stepIndicator.size();
    }

    @Override
    public void OnboardingSteps() {
        for (int i = 0; i < 3; i++) {
            clickOnContinueBtn();

        }
    }
        @Override
        public String onBoardingEnteryPointGetText()
        {
            return getElementText(scenarioStartButton.get(2));
        }
    }
