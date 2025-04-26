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
Feature: Assign tasks to chefs and kitchen staff
  I want to use this template for my feature file

  @assignTasks
  Scenario: Assign tasks based on workload and expertise
    Given a kitchen manager has a list of chefs with their current workloads and expertise
    When the manager assigns a new cooking task
    Then the system should assign the task to the most suitable chef
    And the chef is workload should be updated

  @assignTasks
  Scenario: Notify chef about assigned tasks
    Given a chef has been assigned a new cooking task
    When the system sends a notification
    Then the chef should receive the task details
    And be able to prepare the meal on time
  
