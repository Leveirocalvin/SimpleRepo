@tag
Feature: A set of scenarios to be run

Background: 
Given Open the browser and hit the URL

Scenario Outline: Testing of submitting the order
Given Login with username <uname> and password <pwd>
When I Add <productname> to cart
And View cart if item displayed
Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage 

Examples:
		| uname 						| pwd 				| productname |
		| anshika@gmail.com	| Iamking@000 | ZARA COAT 3 |
   #| rahushe@gmail.com | Iamking@000 | ZARA COAT 3 |