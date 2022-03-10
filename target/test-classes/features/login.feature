Feature: Login into application

Scenario Outline: Test for validating login

Given Navigate to QAClickAcademy site
And click on login link on home page to land on sign in page
When User enters <username> and <password> and click on login
Then verify user is successfully logged in

Examples:
|username			|password	|
|test99@gmail.com	|123456		|
|xyz@gmail.com		|654331		|