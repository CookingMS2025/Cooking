package stepDefinitions;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import io.cucumber.java.en.*;
import myCooking.Chef;
import myCooking.Customer;
public class DietaryPreferencesSteps {
	private Customer cu;
	private Chef ch;
	private String displayedPreferences;
    private String displayedAllergies;

	@Given("a customer wants to set dietary preferences and allergies")
	public void a_customer_wants_to_set_dietary_preferences_and_allergies() {
	    // Write code here that turns the phrase above into concrete actions
		cu=new Customer();
		;
	    //throw new io.cucumber.java.PendingException();
	}

	@When("the customer submits the preferences")
	public void the_customer_submits_the_preferences() {
	    // Write code here that turns the phrase above into concrete actions
		cu.addDietaryPreference("vegetarian");
		cu.addAllergies("peanuts");
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("The system should store the preferences correctly")
	public void the_system_should_store_the_preferences_correctly() {
	    // Write code here that turns the phrase above into concrete actions
		assertFalse(cu.getDietaryPreference().isEmpty());
        assertFalse(cu.getAllergies().isEmpty());
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("The system should prevent meals with allergens")
	public void the_system_should_prevent_meals_with_allergens() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(cu.getAllergies().contains("Peanuts"));
	   // throw new io.cucumber.java.PendingException();
	}

	@Given("A chef wants to view customer dietary preferences")
	public void a_chef_wants_to_view_customer_dietary_preferences() {
	    // Write code here that turns the phrase above into concrete actions
		ch=new Chef();
	    //throw new io.cucumber.java.PendingException();
	}

	@When("the chef selects a customer")
	public void the_chef_selects_a_customer() {
	    // Write code here that turns the phrase above into concrete actions
		displayedPreferences = ch.viewDietaryPreferences(cu);
        displayedAllergies = ch.viewAllergies(cu);
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("The system should display the customer's preferences")
	public void the_system_should_display_the_customer_s_preferences() {
	    // Write code here that turns the phrase above into concrete actions
		assertNotNull(displayedPreferences);
        System.out.println(displayedPreferences);
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("The system should display the customer's allergies")
	public void the_system_should_display_the_customer_s_allergies() {
	    // Write code here that turns the phrase above into concrete actions
		assertNotNull(displayedAllergies);
        System.out.println(displayedAllergies);
	   // throw new io.cucumber.java.PendingException();
	}
}
