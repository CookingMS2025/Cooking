package stepDefinitions;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import java.util.List;
import java .util.ArrayList;
import myCooking.Customer;
import myCooking.Meal;
import myCooking.OrderHistory;
import myCooking.Chef;
public class TrackOrdersSteps {
	private Customer customer;
	private OrderHistory oh;
	private List<Meal> retrievedOrders;
	private Chef chef;

	
	@Given("A customer has placed previous  meal orders")
	public void a_customer_has_placed_previous_meal_orders() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		 customer = new Customer("Asaad Daoud");
		 List <String> i1 =new ArrayList();
		 List <String> i2= new ArrayList();
		 List <String> i3= new ArrayList();
	     customer.addOrder(new Meal("Pasta",i1));
	     customer.addOrder(new Meal("Salad",i2));
	     customer.addOrder(new Meal("Grilled Chicken",i3));
	     oh = new OrderHistory();
	     oh.addCustomer(customer);
		
	}

	@When("The  customer  access thier order history")
	public void the_customer_access_thier_order_history() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		retrievedOrders=customer.getPastOrders();
	}

	@Then("The system should display past meal orders")
	public void the_system_should_display_past_meal_orders() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		assertNotNull("Order history is missing!", retrievedOrders);
        assertFalse("No orders found!", retrievedOrders.isEmpty());
        oh.displayOrders(customer);
	}

	@Given("A chef wants to access customer older history")
	public void a_chef_wants_to_access_customer_older_history() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		chef= new Chef();
	}

	@When("the chef chooses a customer from order history ")
	public void the_chef_selects_a_customer() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		retrievedOrders = customer.getPastOrders();
	}

	@Then("The system should display the customer is past orders")
	public void the_system_should_display_the_customer_is_past_orders() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		chef.viewCustomerOrders(customer);
	}

	@Then("The chef should be able to suggest personalized meal plans")
	public void the_chef_should_be_able_to_suggest_personalized_meal_plans() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		chef.suggestMealPlan();
	}

	@Given("the system administrator wants to store and retrieve order history")
	public void the_system_administrator_wants_to_store_and_retrieve_order_history() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		assertNotNull("System must have order storage!", oh);
	}

	@When("the adminstrator accesses the order history")
	public void the_adminstrator_accesses_the_order_history() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Administrator retrieving order history...");
	}

	@Then("The system should retrieve and store customer order history")
	public void the_system_should_retrieve_and_store_customer_order_history() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		oh.displayOrders(customer);
	}

	@Then("The system should allow trend analysis and service improvements")
	public void the_system_should_allow_trend_analysis_and_service_improvements() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Administrator analyzing order trends...");
	}
}
