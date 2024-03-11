Feature: On boarding
  Background: User Logged in successfully "Market Journey"

  @VMACMVA10-T2764
  Scenario: One Step One Permission(Light/Dark)
    Given User click on "One Step One Permission" button
    Then Overlay disappeared and Let's go button will be clickable
    When User click on Let's go button
    Then Onboarding steps should be displayed with only one step
    When User go through permissions step
    Then User should find:All permissions are ON by default and I am happy with this button is active.
    When Tap on I am happy with this button
    Then Congratulations message should be displayed "congratulations"
    And Clapping icon should be displayed instead of Tobi
    And Get Started button should be clickable
   # And  clapping hand on the right and "Get started" button is active >> issue in demo app
    When Tap on Get started button
    Then User should navigate to the entry points screen again
    When Set the App in dark mode and repeat the previous steps
    Then All steps should working fine in dark mode


  @VMACMVA10-T2766
  Scenario: Go through in on-boarding screen without Tobi
    Given User started Minimal Setup without Tobi
    #Then Check continue button  not clickable
    When User click on I agree checkbox
    Then Check continue button clickable
    When User click on continue button
    Then Overlay disappeared and Let's go button will be clickable
    And Tobi shouldn't be Displayed
    When User click on Let's go button
    Then User can go through all the steps till Permissions step where they are on by default
    When Click on I'm happy with this button
    Then Congratulations message should be displayed "congratulations"
    And Clapping icon should be displayed instead of Tobi
    And Get Started button should be clickable
    And User should click on get started button

  @VMACMVA10-T2760
  Scenario: minimal setup (Light/Dark)
    Given Click on minimal setup button
    Then T&C screen will ar with: An unselected I agree checkbox. and Dammed Continue button.
    When Mark on  I agree check box
    Then Check box turned ON & Continue button is activated
    When Tap on Continue button
    Then Onboarding screen should be displayed
    When Tap on Let's go button
    Then Onboarding steps should be displayed
    When Go through permissions step
    Then User should find:All permissions are ON by default and I am happy with this button is active.
    When Tap on I am happy with this button
    Then User should find:Congratulations text and tobi on the right.Get started button is active.
    When Tap on Get started button
    Then User should navigate to the entry points screen again
    When Set the App in dark mode and repeat the previous steps
    Given Click on minimal setup button
    Then T&C screen will ar with: An unselected I agree checkbox. and Dammed Continue button.
    When Mark on  I agree check box
    Then Check box turned ON & Continue button is activated
    When Tap on Continue button
    Then Onboarding screen should be displayed
    When Tap on Let's go button
    Then Onboarding steps should be displayed
    When Go through permissions step
    Then User should find:All permissions are ON by default and I am happy with this button is active.
    When Tap on I am happy with this button
    Then User should find:Congratulations text and tobi on the right.Get started button is active.
    When Tap on Get started button
    Then User should navigate to the entry points screen again
    Then the journey should be displayed successfully in dark mode

  @VMACMVA10-T2765
  Scenario: Validate The Onboarding flow with T&C and ToBi without permissions Section
    Given Open the Onboarding app & Find CTA: "Minimal Setup Without Permission Section" text
    When click on 'Minimal Setup without Permission' CTA
    Then Mark on  'I Agree' check box
    And Click on continue button
    And Click on 'Let's go' button
    Then Go through Onboarding steps
    And user can find :"congratulations" text & also can Found "Get started" text
    Then Click on  'Get Started' button
    Then Set the App in dark mode
    Given Open the Onboarding app & Find CTA: "Minimal Setup Without Permission Section" text
    When click on 'Minimal Setup without Permission' CTA
    Then Mark on  'I Agree' check box
    And Click on continue button
    And Click on 'Let's go' button
    Then Go through Onboarding steps
    And user can find :"congratulations" text & also can Found "Get started" text
    Then Click on  'Get Started' button