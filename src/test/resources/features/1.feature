Feature: 

	#As a user, I should be able to login to the app
	#
	#1. Verify users can login 
	#2. verify users can check "Remember me on this computer" option 
	#3. Verify users can access to "FORGOT YOUR PASSWORD?" link page
	#


	@G12-167
	Scenario: user should be able to login to the app
		Given user is on login page
		When user enter username, password and click to login button
		Then user see the Dashboard page



#	@G12-167
#	Scenario Outline: user should be able to login to the app
#		Given user is on login page
#		When user enter "<username>" and "<password>"
#		Then user click login button
#		Then user see the Dashboard page
#		Examples:
#		|           username           |password|
#		|hr22@cybertekschool.com       |UserUser|
#		|marketing22@cybertekschool.com|UserUser|
#		|helpdesk22@cybertekschool.com |UserUser|
		