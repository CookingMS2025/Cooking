package stepDefinitions;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import java.util.List;
import java .util.ArrayList;

import myCooking.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Restocking {
    private Inventory stock;
    private Inventory tomato;
    private Inventory milk;
    private List<Inventory> inventoryList=new ArrayList<>();

    @Given("the kitchen manager is logged into the inventory management system")
    public void theKitchenManagerIsLoggedIntoTheInventoryManagementSystem() {

    }



    @When("an ingredient’s quantity is updated due to usage or delivery")
    public void anIngredientSQuantityIsUpdatedDueToUsageOrDelivery() {
        tomato=new Inventory("tomato",80,30);
        tomato.useIngredient(15);
        tomato.restock(20);
        inventoryList.add(tomato);
        stock=tomato;
    }

    @Then("the updated quantity should be reflected immediately in the system")
    public void theUpdatedQuantityShouldBeReflectedImmediatelyInTheSystem() {
        assertEquals(85, stock.getQuantity());
        System.out.println("Stock Updated: " + stock);
    }

    @And("the kitchen manager should see the current stock levels in the dashboard")
    public void theKitchenManagerShouldSeeTheCurrentStockLevelsInTheDashboard() {
        for (Inventory inventory : inventoryList) {
            System.out.println("Dashboard: " + stock);
        }
    }

    @Given("the system monitors all ingredient stock levels continuously")
    public void theSystemMonitorsAllIngredientStockLevelsContinuously() {

        assertNotNull(null, inventoryList);


    }

    @And("a threshold level is defined for each ingredient")
    public void aThresholdLevelIsDefinedForEachIngredient() {
        milk=new Inventory("milk",50,20);
        inventoryList.add(milk);
        stock=milk;
    }

    @When("the quantity of an ingredient drops below its threshold")
    public void theQuantityOfAnIngredientDropsBelowItsThreshold() {
        stock.useIngredient(35);
    }

    @Then("the system should generate a restocking suggestion")
    public void theSystemShouldGenerateARestockingSuggestion() {
        assertTrue(stock.needsRestocking());
        System.out.println("Restocking needed for: " + stock.getName());
    }

    @And("notify the kitchen manager with a recommendation to reorder the ingredient")
    public void notifyTheKitchenManagerWithARecommendationToReorderTheIngredient() {
        System.out.println("Notification: Please reorder " + stock.getName());
    }
}
