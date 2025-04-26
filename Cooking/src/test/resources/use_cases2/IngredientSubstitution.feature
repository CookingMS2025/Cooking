#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Suggest alternative ingredients for unavailable or restricted items
    Given an ingredient is unavailable or does not fit dietary restrictions
    When the system finds an alternative ingredient
    Then the customer should be shown the suggested substitution
    And the suggested ingredient should be safe for the customer is dietary needs

 @tag2
  Scenario: Chef receives an alert when an ingredient is substituted
    Given a meal requires a substituted ingredient due to dietary restrictions
    When the substitution is applied to the customer is meal 
    Then the chef should receive an alert about the substitution
    And the chef should be able to approve or adjust the final recipe
 
