@tag
Feature:Notify users of low-stock ingredients


  @tag1
  Scenario:Low stock alert is triggered
    Given the kitchen has a stock management system
    And an ingredient has a defined low-stock threshold
    And the ingredient has reached its low-stock threshold
    When the system checks the stock levels
    Then the kitchen manager receives an alert indicating that the ingredient are low in stock
  @tag2
  Scenario:No alert when stock is sufficient
    Given the kitchen has a stock management system
    And an ingredient has a defined low-stock threshold
    And stock levels are sufficient
    When the system checks the stock levels
    Then no alert is sent to the kitchen manager should receive a reminder to start preparing the meal