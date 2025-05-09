@tag
Feature: Generate invoices and track financial reports

  @tag1
  Scenario: Customer receives an invoice
    Given a customer has completed a purchase
    When the transaction is confirmed by the system
    Then the system should generate an invoice
    And send it to the customer's email address

  @tag2
  Scenario: Administrator generates financial reports
    Given the system has recorded sales and expense data for the current month
    When the administrator requests a monthly financial report
    Then the system should generate a report summarizing revenue and expenses
    And the system should display the report