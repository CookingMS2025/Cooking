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
@restocking
Feature:Track available ingredients and suggest restocking

  @restocking
  Scenario:Track ingredient stock levels in real time
    Given the kitchen manager is logged into the inventory management system
    When an ingredient’s quantity is updated due to usage or delivery
    Then the updated quantity should be reflected immediately in the system
    And the kitchen manager should see the current stock levels in the dashboard

  @restocking
  Scenario: Automatically suggest restocking when ingredients are low
    Given the system monitors all ingredient stock levels continuously
    And a threshold level is defined for each ingredient
    When the quantity of an ingredient drops below its threshold
    Then the system should generate a restocking suggestion
    And notify the kitchen manager with a recommendation to reorder the ingredient