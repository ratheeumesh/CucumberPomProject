Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "The Internet"

Scenario: Login with correct credentials
Given user is on login page
When user enters username "tomsmith"
And user enters password "SuperSecretPassword!"
And user clicks on Login button
When user gets the title of the page
Then page title should be "The Internet"