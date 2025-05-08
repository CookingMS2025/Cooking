package stepDefinitions;
import static org.junit.Assert.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myCooking.Inventory;
import myCooking.KitchenManager;
import myCooking.Supplier;

public class PricingAndOrdering {
    private Supplier james,moe;
    private KitchenManager sam;
    private Supplier[] supplierList;
    private Inventory tomato;


    @Given("the kitchen manager is logged into the system")
    public void theKitchenManagerIsLoggedIntoTheSystem() {
        sam=new KitchenManager();
    }

    @And("the system is connected to the suppliers pricing APIs")
    public void theSystemIsConnectedToTheSuppliersPricingAPIs() {
        james=new Supplier("James");
        moe=new Supplier("Moe");

        supplierList=new Supplier[2];
        supplierList[0]=james;
        supplierList[1]=moe;

        System.out.println("Connected to Suppliers API");
    }

    @When("the kitchen manager requests the current price of an ingredient")
    public void theKitchenManagerRequestsTheCurrentPriceOfAnIngredient() {
        james.item("Tomato",50);
        moe.item("Tomato",60);

    }

    @Then("the system displays the real-time price from the supplier")
    public void theSystemFetchesAndDisplaysTheRealTimePriceFromTheSupplier() {
        assertNotNull(supplierList);
        System.out.println(james.getPrice("Tomato"));
        System.out.println(moe.getPrice("Tomato"));


    }

    @And("the kitchen manager can compare prices for cost-effective decisions")
    public void theKitchenManagerCanComparePricesForCostEffectiveDecisions() {
        Supplier cheap=sam.comparePrice(supplierList,"Tomato");
        assertEquals(james, cheap);

        System.out.println("Supplier that has the lowest price: "+cheap.toString());

    }

    @Given("the system is monitoring ingredient stock levels in real time")
    public void theSystemIsMonitoringIngredientStockLevelsInRealTime() {
        tomato =new Inventory("tomato",80,30);
    }

    @And("supplier information is configured and accessible")
    public void supplierInformationIsConfiguredAndAccessible() {

    }

    @When("the stock level of an ingredient drops below the critical threshold")
    public void theStockLevelOfAnIngredientDropsBelowTheCriticalThreshold() {
        tomato.useIngredient(60);
        assertEquals(tomato.getQuantity(),20);
    }

    @Then("the system automatically generates and sends a purchase order to the supplier")
    public void theSystemAutomaticallyGeneratesAndSendsAPurchaseOrderToTheSupplier() {
        assertTrue(tomato.needsRestocking());
        System.out.println("purchase order sent to the supplier");
    }

    @And("notifies the kitchen manager of the action taken")
    public void notifiesTheKitchenManagerOfTheActionTaken() {
        System.out.println("Notification: automatic purchase order sent to the supplier for: " + tomato.getName());

    }
}
