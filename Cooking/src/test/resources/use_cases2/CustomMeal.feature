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
Feature: Order and Menu Customization
  

  @tag1
  Scenario: Customer customizes a meal by selecting ingredients
    Given a customer wants to customize a new meal
    When the customer selects ingredients
    And  the customer names the meal
    Then the system should create and store the custom meal

 @tag2
  Scenario: System validates incompatible ingredients
    Given the customer chooses ingredients
    When the system checks for incompatible ingredients
    Then the system should reject the custom meal due to incompatibility