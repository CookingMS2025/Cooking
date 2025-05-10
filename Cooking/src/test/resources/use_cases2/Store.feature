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
Feature: Store dietary preferences and allergies


  @Store
  Scenario: Customer enteres dietary preferences and allergies
    Given a customer wants to set dietary preferences and allergies
    When the customer submits the preferences
    Then The system should store the preferences correctly
    And The system should prevent meals with allergens

  @Store
  Scenario: Chef views customer dietary preferences
    Given A chef wants to view customer dietary preferences
    When the chef selects a customer
    Then The system should display the customer's preferences
    And The system should display the customer's allergies