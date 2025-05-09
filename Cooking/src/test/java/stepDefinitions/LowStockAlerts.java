package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myCooking.Inventory;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class LowStockAlerts {
    private List<Inventory> inventoryList;
    private List<Inventory> lowStock=new ArrayList<>();


    private Inventory tomato,milk;

    @Given("the kitchen has a stock management system")
    public void theKitchenHasAStockManagementSystem() {
        inventoryList=new ArrayList<>();


    }

    @And("an ingredient has a defined low-stock threshold")
    public void anIngredientHasADefinedLowStockThreshold() {

        tomato=new Inventory("tomato",100,25);
        inventoryList.add(tomato);

    }

    @And("the ingredient has reached its low-stock threshold")
    public void theIngredientHasReachedItsLowStockThreshold() {
        lowStock.clear();
        tomato.useIngredient(75);
        assertEquals(25,tomato.getQuantity());


    }

    @When("the system checks the stock levels")
    public void theSystemChecksTheStockLevels() {
        lowStock=tomato.listNeedRestock(inventoryList);




    }

    @Then("the kitchen manager receives an alert indicating that the ingredient are low in stock")
    public void theKitchenManagerReceivesAnAlertIndicatingThatTheIngredientAreLowInStock() {
        assertFalse("at least one ingredient should be low in stock", lowStock.isEmpty());
        System.out.println("Low stock ingredients: ");
        for (Inventory ing : lowStock) {
            System.out.println(ing.getName());}
    }
    @And("stock levels are sufficient")
    public void stockLevelsAreSufficient() {
        lowStock.clear();
        tomato.restock(50);
    }

    @Then("no alert is sent to the kitchen manager should receive a reminder to start preparing the meal")
    public void noAlertIsSentToTheKitchenManagerShouldReceiveAReminderToStartPreparingTheMeal() {
        assertTrue("none of the ingredients should be low in stock", lowStock.isEmpty());
        System.out.println("Reminder to prepare the meal");
    }


}
