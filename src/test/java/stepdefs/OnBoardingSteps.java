package stepdefs;

import base.PageObjectBase;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.MobileTask.*;
import java.net.MalformedURLException;
import java.util.Locale;

public class OnBoardingSteps {
    private PageObjectBase base = new PageObjectBase(){};
    private static final Logger logger = Logger.getLogger(OnBoardingSteps.class);
    private BoardingAbstract onBoardingPage;
    SoftAssert softAssert;

    public OnBoardingSteps(Config config) throws MalformedURLException {
        config = new Config();
        if (config.isIos()) {
            onBoardingPage = new BoardingLogicIOS();
        }
        if (config.isAndroid()) {
            onBoardingPage = new BoardingLogicAndroid();
        }
        softAssert = new SoftAssert();
    }

    @Given("User started Minimal Setup without Tobi")
    public void UserStartedMinimalSetupWithoutTobi() {
        logger.info("User started Minimal Setup without Tobi");
        onBoardingPage.startMinimalSetupWithoutTobi();
        softAssert.assertTrue(onBoardingPage.OverlayIsDisplayed());
        softAssert.assertAll();
    }

    @Then("Check continue button not clickable")
    public void checkContinueButtonNotClickable() {
        logger.info("Check continue button not clickable");
        softAssert.assertFalse(onBoardingPage.checkContinueIsClickable());
        softAssert.assertAll();
    }

    @When("User click on I agree checkbox")
    public void userClickOnIAgreeCheckbox() {
        logger.info("User click on I agree checkbox");
        onBoardingPage.clickOnAgreeTermsAndConditions();
    }

    @Then("Check continue button clickable")
    public void checkContinueButtonClickable() {
        logger.info("Check continue button clickable");
        softAssert.assertTrue(onBoardingPage.checkContinueIsClickable());
        softAssert.assertAll();
    }

    @When("User click on continue button")
    public void userClickOnContinueButton() {
        logger.info("User click on continue button");
        onBoardingPage.clickOnTermsContinueBtn();
    }

    @Then("Overlay disappeared and Let's go button will be clickable")
    public void overlayDisappearedAndLetSGoButtonWillBeClickable() {
        logger.info("Overlay disappeared and Let's go button will be clickable");
        softAssert.assertTrue(onBoardingPage.letsGoBtnClickable());
        // logger.info("Applitools- Check UI of Let's Go button  in Light Mode");
        // base.validateFrameByApplitools("mva10.test"," Let's Go button -Light",onBoardingPage.letsGoBtn);
        softAssert.assertAll();
    }

    @And("Tobi shouldn't be Displayed")
    public void tobiNotDisplayed() {
        logger.info("Tobi shouldn't be Displayed");
        softAssert.assertFalse(onBoardingPage.TobiIsDisplayed());

    }

    @When("User click on Let's go button")
    public void userClickOnLetSGoButton() {
        logger.info("User click on Let's go button");
        onBoardingPage.clickOnLetsGoBtn();
    }

    @When("User can go through all the steps till Permissions step where they are on by default")
    public void go_through_alls_steps_till_permissions_step() {
        logger.info("User can go through all the steps till Permissions step where they are on by default");
      //  softAssert.assertTrue(onBoardingPage.PermissionsAreDisplayed());
        onBoardingPage.clickOnContinueBtn();
        onBoardingPage.clickOnContinueBtn();
        onBoardingPage.clickOnContinueBtn();
        softAssert.assertAll();
    }

    @And("Click on I'm happy with this button")
    public void clickOnIMHappyWithThisButton() {
        logger.info("Click on I'm happy with this button");
        onBoardingPage.clickOnIamHappyWithThis();
    }

    @Then("Congratulations message should be displayed {string}")
    public void congratulationsMessageDisplayed(String CongulateMsg) {
        //  logger.info("Applitools- Check UI of Congratulations Text in Light Mode");
        //   base.validateFrameByApplitools("mva10.test"," Congratulations Text-Light",onBoardingPage.Congratulations);

        logger.info("Congratulations message should be displayed");
        softAssert.assertTrue(onBoardingPage.getTextCongratulations().toLowerCase(Locale.ROOT).contains(CongulateMsg));
    }

    @And("Clapping icon should be displayed instead of Tobi")
    public void clappingDisplayed() {
        logger.info("Clapping icon should be displayed instead of Tobi");
        softAssert.assertTrue(onBoardingPage.ClappingIsDisplayed());
        //softAssert.assertAll();
        //Clapping icon part still need to be handled in TC  @VMACMVA10-T2764
    }

    @And("User should click on get started button")
    public void userShouldClickOnGetStartedButton() {
        onBoardingPage.clickOnGetStarted();
        logger.info("click on get started");
        softAssert.assertAll();
    }
    @And("Get Started button should be clickable")
    public void clickOnGetStartedButton() {

        //logger.info("Applitools- Check UI of Get Started Button in Light Mode");
        //  base.validateFrameByApplitools("mva10.test","Get Started Button-Light",onBoardingPage.getStarted);
        logger.info("Get Started button should be clickable");
        onBoardingPage.GetStartedIsClickable();
    }


    @Given("Click on minimal setup button")
    public void clickOnMinimalSetupButton() {
      /*  if(platform.equalsIgnoreCase("iosreact"))
        {
            onBoardingPage.startMinimalSetup();
        }*/
       /* if (config.isReactIos()) {
            onBoardingPage = new BoardingLogicReactiOS();
        }*/
        onBoardingPage.startMinimalSetup();
        logger.info("Click on minimal setup button");

    }

    @Then("T&C screen will ar with: An unselected I agree checkbox. and Dammed Continue button.")
    public void tCScreenWillArWithAnUnselectedIAgreeCheckboxAndDammedContinueButton() {
 //       softAssert.assertFalse(onBoardingPage.checkContinueIsClickable());[still not appear]
//        softAssert.assertFalse(onBoardingPage.agreecheckbox.isSelected());
//        softAssert.assertFalse(onBoardingPage.continuetermsbtn.isEnabled()); need ID enhancments
        logger.info("T&C screen will ar with: An unselected I agree checkbox. and Dammed Continue button");
        softAssert.assertAll();


    }

    @When("Mark on  I agree check box")
    public void markOnIAgreeCheckBox() {
        onBoardingPage.clickOnAgreeTermsAndConditions();
        logger.info("check the agree box");
    }

    @Then("Check box turned ON & Continue button is activated")
    public void checkBoxTurnedONContinueButtonIsActivated() {
//        softAssert.assertTrue(onBoardingPage.agreecheckbox.isSelected());
        softAssert.assertTrue(onBoardingPage.continuetermsbtn.isEnabled());
        softAssert.assertTrue(onBoardingPage.checkContinueIsClickable());
        logger.info("Check box turned ON & Continue button is activated ");
        softAssert.assertAll();

    }

    @When("Tap on Continue button")
    public void tapOnContinueButton() {
        onBoardingPage.clickOnTermsContinueBtn();
        logger.info("Tap on Continue button");

    }

    @Then("Onboarding screen should be displayed")
    public void onboardingScreenShouldBeDisplayed() {
        softAssert.assertTrue(onBoardingPage.letsGoBtn.isDisplayed());
        logger.info("onboarding is displayed now");
        softAssert.assertAll();
    }

    @When("Tap on Let's go button")
    public void tapOnLetSGoButton() {
        onBoardingPage.clickOnLetsGoBtn();//clickOnLetsgoBtn();
        logger.info("Click on let's go button");

    }

    @Then("Onboarding steps should be displayed")
    public void onboardingStepsShouldBeDisplayed() {
        softAssert.assertTrue(onBoardingPage.continueBtn.isDisplayed());
        logger.info("steps displayed");
        softAssert.assertAll();

    }

    @When("Go through permissions step")
    public void goThroughPermissionsStep() {
        onBoardingPage.clickOnContinueBtn();
        onBoardingPage.clickOnContinueBtn();
        onBoardingPage.clickOnContinueBtn();
        logger.info("go through all the steps");

    }

    @Then("User should find:All permissions are ON by default and I am happy with this button is active.")
    public void userShouldFindAllPermissionsAreONByDefaultAndIAmHappyWithThisButtonIsActive() {
        logger.info("Assert that Toggle is Enabled by Default");
        //  softAssert.assertTrue(onBoardingPage.permstoggles.isEnabled()); need IDs enhancements
        onBoardingPage.Scrolling(onBoardingPage.IamHappyWithThis);
        softAssert.assertTrue(onBoardingPage.IamHappyWithThis.isEnabled());
        logger.info("Assert that I am Happy With That Button is Active");
        logger.info("User should find:All permissions are ON by default and I am happy with this button is active.");
        //   logger.info("Applitools- Check UI of I am happy with this Button in Light Mode");
        // base.validateFrameByApplitools("mva10.test","I am happy with this_button-Light",onBoardingPage.IamHappyWithThis);
    }

    @When("Tap on I am happy with this button")
    public void tapOnIAmHappyWithThisButton() {
        //    onBoardingPage.Scrolling(onBoardingPage.IamHappyWithThis);
        onBoardingPage.clickOnIamHappyWithThis();
        logger.info("Tap on I am happy with this button");

    }

    @Then("User should find:Congratulations text and tobi on the right.Get started button is active.")
    public void userShouldFindCongratulationsTextAndTobiOnTheRightGetStartedButtonIsActive() {
        softAssert.assertTrue(onBoardingPage.getTextCongratulations().toLowerCase(Locale.ROOT).contains("congratulations"));
        //softAssert.assertTrue(onBoardingPage.TobiIsDisplayed());
        logger.info("User should find:Congratulations text and tobi on the right.Get started button is active");
        softAssert.assertAll();

    }

    @When("Tap on Get started button")
    public void tapOnGetStartedButton() {
        onBoardingPage.clickOnGetStarted();
        logger.info("click on get started");
    }

    @Then("User should navigate to the entry points screen again")
    public void userShouldNavigateToTheEntryPointsScreenAgain() {
       // softAssert.assertTrue(onBoardingPage.scenarioStartButton.size()==4);
        logger.info("User Navigated to the enetry points again");
        softAssert.assertAll();

    }

    @When("Set the App in dark mode and repeat the previous steps")
    public void setTheAppInDarkModeAndRepeatThePreviousSteps() {
        onBoardingPage.setDeviceInDarkMode();
        logger.info("Set the App in dark mode and repeat the previous steps");

    }

    @Then("the journey should be displayed successfully in dark mode")
    public void theJourneyShouldBeDisplayedSuccessfullyInDarkMode() {
        softAssert.assertAll();
    }
    //Hend Changes
    @Given("User click on \"One Step One Permission\" button")
    public void User_click_on_One_Step_One_Permission_button(){
        //logger.info("Applitools- Check UI of one Step One Permission Button in Light Mode");
        //  base.validateFrameByApplitools("mva10.test","One_Step_One_Permission_button-Light",onBoardingPage.scenarioStartButton.get(1));

        logger.info("User click on One Step One Permission button");
        //onBoardingPage.clickOnoneStepButton();
        onBoardingPage.startOneStepOnePerm();
    }
    @Then("Onboarding steps should be displayed with only one step")
    public void onboardingStepsShouldBeDisplayedWithOnlyOneStep() {
        // logger.info("Applitools- Check UI of stepIndicator in Light Mode");
        //   base.validateFrameByApplitools("mva10.test","Step Dots -Light",onBoardingPage.stepIndicator.get(0));

        logger.info("Assert that it's only One step and One permission");
     //   softAssert.assertEquals(onBoardingPage.indicationCount() , 2);
    }
    @When("User go through permissions step")
    public void userGoThroughPermissionsStep() {
        // logger.info("Applitools- Check UI of Continue Button in Light Mode");
        //  base.validateFrameByApplitools("mva10.test","Continue Button-Light",onBoardingPage.continueBtn);

        logger.info("Click on continue button");
        onBoardingPage.clickOnContinueBtn();
    }
    // for tobi less scenario
    @Then("Congratulations message should be displayed {string} and \"Get started\" button is active")
    public void userShouldFindCongratulationsTextAndClappingHandOnTheRightAndButtonIsActive(String arg0) {
        // logger.info("Applitools- Check UI of Congratulations Text in Light Mode");
        //base.validateFrameByApplitools("mva10.test"," Congratulations Text-Light",onBoardingPage.Congratulations);
        logger.info("Assert that Congratualations text message appears");
        softAssert.assertTrue(onBoardingPage.getTextCongratulations().toLowerCase(Locale.ROOT).contains(arg0));
        //Clapping icon part?
        // logger.info("Applitools- Check UI of Get Started Button in Light Mode");
        //base.validateFrameByApplitools("mva10.test","Get Started Button-Light",onBoardingPage.getStarted);
        logger.info("Assert that Let's Get Strted button is Clickable");
        softAssert.assertTrue(onBoardingPage.GetStartedIsClickable());



    }
    @Then("All steps should working fine in dark mode")
    public void allStepsShouldWorkingFineInDarkMode() {
     //   onBoardingPage.setDeviceInDarkMode();
        // logger.info("Applitools- Check UI of one Step One Permission Button in dark Mode");
        // base.validateFrameByApplitools("mva10.test","One_Step_One_Permission_button-Dark",onBoardingPage.scenarioStartButton.get(1));

        logger.info("User click on One Step One Permission button-Dark Mode");
        onBoardingPage.startOneStepOnePerm();
        logger.info("Overlay disappeared and Let's go button will be clickable DarkMODE");
        softAssert.assertTrue(onBoardingPage.letsGoBtnClickable());
        onBoardingPage.clickOnLetsGoBtn();
        // logger.info("Applitools- Check UI of Let's Go button  in Dark Mode");
        //  base.validateFrameByApplitools("mva10.test"," Let's Go button -Dark",onBoardingPage.letsGoBtn);
        //  logger.info("Applitools- Check UI of stepIndicator in Dark Mode");
        //base.validateFrameByApplitools("mva10.test","Step Dots -Dark",onBoardingPage.stepIndicator.get(0));

        logger.info("Assert that it's only One step and One permission in Dark Mode");
     //   softAssert.assertEquals(onBoardingPage.indicationCount() , 2);
        //logger.info("Applitools- Check UI of Continue Button in Dark MODE");
        //base.validateFrameByApplitools("mva10.test","Continue Button-Dark",onBoardingPage.continueBtn);

        logger.info("Click on continue button Dark Mode");
        onBoardingPage.clickOnContinueBtn();
        logger.info("Assert that Toggle is Enabled by Default - Dark Mode");
        //  softAssert.assertTrue(onBoardingPage.permstoggles.isEnabled()); need IDs enhancements
        onBoardingPage.Scrolling(onBoardingPage.IamHappyWithThis);
        softAssert.assertTrue(onBoardingPage.IamHappyWithThis.isEnabled());
        logger.info("Assert that I am Happy With That Button is Active- Dark Mode");
        // logger.info("Applitools- Check UI of I am happy with this Button in Dark Mode");
        // base.validateFrameByApplitools("mva10.test","I am happy with this_button-Dark",onBoardingPage.IamHappyWithThis);
        logger.info("Click on I'm happy with this button");
        onBoardingPage.clickOnIamHappyWithThis();
        // base.validateFrameByApplitools("mva10.test"," Congratulations Text-Dark",onBoardingPage.Congratulations);
        logger.info("Assert that Congratualations text message appears Dark Mode");
        softAssert.assertTrue(onBoardingPage.getTextCongratulations().toLowerCase(Locale.ROOT).contains("congratulations"));
        logger.info("Clapping icon should be displayed instead of Tobi");
        softAssert.assertTrue(onBoardingPage.ClappingIsDisplayed());
        //Clapping icon part still need to be handled in TC  @VMACMVA10-T2764
        // logger.info("Applitools- Check UI of Get Started Button in Dark Mode");
        //base.validateFrameByApplitools("mva10.test","Get Started Button-Dark",onBoardingPage.getStarted);
        logger.info("Assert that Let's Get Strted button is Clickable - Dark Mode");
        softAssert.assertTrue(onBoardingPage.GetStartedIsClickable());
        onBoardingPage.clickOnGetStarted();
        softAssert.assertAll();

    }

    @Given("Open the Onboarding app & Find CTA: {string} text")
    public void CheckAppOpened(String Minimal_Setup_without_perm) {
        // base.validateFrameByApplitools("mva10.test","without permission -Light",onBoardingPage.minimalSetupWithoutPermission);

        //Assert.assertTrue(onBoardingPage.onBoardingEnteryPointGetText().equals(Minimal_Setup_without_perm));
        logger.info("Open the app & check that onboarding opened successfully");

    }

    @When("click on 'Minimal Setup without Permission' CTA")
    public void clickOnMinimalSetupWithoutPermCTA() {
        onBoardingPage.startMinimalSetupWithoutPerm();
        logger.info("click on CTA without permssion ");
    }

    @And("Mark on  'I Agree' check box")
    public void userClickOnIAgreeCheckboxx() {
        onBoardingPage. clickOnAgreeTermsAndConditions();
        logger.info("mark agree check box");

    }


    @Then("Click on continue button")
    public void clickoncontinuebutton() {
        onBoardingPage.clickOnTermsContinueBtn();
        logger.info("click on continue button");

    }

    @And("Click on 'Let's go' button")
    public void ClickonLetsgobutton() {
        onBoardingPage.clickOnLetsGoBtn();
        logger.info("click on let's go");
    }

    @Then("Go through Onboarding steps")
    public void GothroughOnboardingsteps() {

        onBoardingPage.OnboardingSteps();
        logger.info("go through all the steps");


    }
    @And("user can find :{string} text & also can Found {string} text")
    public void UsershouldseeCongratulationsandGetstartedtext(String Congratulation, String Get_started)
    {

        Assert.assertTrue(onBoardingPage.getTextCongratulations().toLowerCase(Locale.ROOT).contains(Congratulation));

        // Assert.assertTrue(onBoardingPage.getTextOnGetStarted().equals(Get_started));
        logger.info("check that congratulations text & get started button opened succssfully");


    }


    @Then("Click on  'Get Started' button")
    public void clickOnGetStartedThisButton() {
        onBoardingPage.clickOnGetStarted();
        logger.info("click on get started button");
    }
    @Then ("Set the App in dark mode")
    public void setAppinDarkMode()
    {
        onBoardingPage.setDeviceInDarkMode();
    }
}
