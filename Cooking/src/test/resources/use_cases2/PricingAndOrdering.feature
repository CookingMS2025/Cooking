@tag
Feature: Integrate with suppliers for real-time pricing and ordering

  @tag1
  Scenario: Kitchen manager views real-time prices before ordering
Given the kitchen manager is logged into the system
And the system is connected to the suppliers pricing APIs
When the kitchen manager requests the current price of an ingredient
Then the system displays the real-time price from the supplier
And the kitchen manager can compare prices for cost-effective decisions

  @tag2
Scenario: System generates purchase order when stock is critically low
Given the system is monitoring ingredient stock levels in real time
And supplier information is configured and accessible
When the stock level of an ingredient drops below the critical threshold
Then the system automatically generates and sends a purchase order to the supplier
And notifies the kitchen manager of the action taken