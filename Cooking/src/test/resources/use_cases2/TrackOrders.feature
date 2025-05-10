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
Feature: Track past orders and personalized meal plans
  
  @track
  Scenario: Customer views past meal orders
    Given A customer has placed previous  meal orders
    When The  customer  access thier order history
    Then The system should display past meal orders

  @track
  Scenario Outline: Chef suggests personalized meal plans
    Given A chef wants to access customer older history
    When the chef chooses a customer from order history
    Then The system should display the customer is past orders
    And The chef should be able to suggest personalized meal plans
    
 @track
  Scenario Outline: System administrator manages order history
    Given the system administrator wants to store and retrieve order history
    When the adminstrator accesses the order history
    Then The system should retrieve and store customer order history
    And The system should allow trend analysis and service improvements
   