Feature: DrySign Cases

@Yes
Scenario: Group SignIN Menu Validation
Given navigate to given URL "https://drysign.exelatech.com/signDocument?key=XwXk1GhUmFdT4VTJZA980qZwY&locale=en"
Then select agree check box
Then click on accept button
Then click on OK button
Then click on signature option
Then click on type option and select the sign
Then save it
Then system should display download, reject and finish options


 @Yes
  Scenario: To Verify the UI elements present on the View Plan button pop-up present on the Dashboard
	Given navigate to given URL "https://drysign-qa.exela.global/#/"
    When enter the user name as "sid12@mailinator.com"
    When enter the password as"Malin@555"
    And user click on the sign in button
    And dashboard window get display
    #And individual plan get display
    Then View Plan buttons should be present
    Then user click on View Plan button
    Then Pop Up get displayed with elements
	

  @Yes
  Scenario: To Verify the Close icon functionality present on the View Plan pop-up screen present on the Dashboard
    Given navigate to given URL "https://drysign-qa.exela.global/#/"
    When enter the user name as "sid12@mailinator.com"
    When enter the password as"Malin@555"
    And user click on the sign in button
    Then user click on View Plan button
    Then Pop Up get displayed with elements
    Then existing plan details of the user should get displayed with Upgrade Plan button
    Then user verify that close icon is present on the pop up
	

  @Yes
  Scenario: To Verify register user is able to view only the Higher Plan details than the exisiting plan through Upgrade Plan button present on the View Plan pop-up screen
    Hirarchy of plans:free trial<individual monthly <premium monthly<individual annual<premium annual<professional
	Given navigate to given URL "https://drysign-qa.exela.global/#/"
    When enter the user name as "sid12@mailinator.com"
    When enter the password as"Malin@555"
    And user click on the sign in button
    Then user click on View Plan button
    Then Pop Up get displayed with elements
    Then existing plan details of the user should get displayed with Upgrade Plan button
    And user click on Upgrade Plan button
    Then pop up should display only the higher plan than the exisiting
	

