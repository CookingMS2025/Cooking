@tag
Feature: Send reminders for upcoming orders and deliveries

  @tag1
  Scenario: Customer receives delivery reminder
  Given a customer has a meal scheduled for delivery tomorrow
  When the system checks for upcoming deliveries
  Then the customer should receive a reminder about the upcoming meal delivery

  @tag2
  Scenario: Chef receives cooking task reminder
  Given a chef has a scheduled meal to prepare
  And the meal is confirmed and listed in the chef's task queue
  When the system checks for scheduled cooking tasks
  Then the chef should receive a reminder to start preparing the meal