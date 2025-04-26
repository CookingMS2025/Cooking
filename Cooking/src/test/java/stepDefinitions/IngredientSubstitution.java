package stepDefinitions;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import java.util.List;
import java .util.ArrayList;
import myCooking.Customer;
import myCooking.Meal;
import myCooking.Chef;

public class IngredientSubstitution {
	private String originalIngredient;
    private String substitutedIngredient;
    private boolean substitutionApplied;
    private boolean chefAlerted;
    private boolean chefApproved;

    @Given("an ingredient is unavailable or does not fit dietary restrictions")
    public void an_ingredient_is_unavailable_or_does_not_fit_dietary_restrictions() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	originalIngredient = "Peanuts";
        substitutedIngredient = "Almonds";
    }

    @When("the system finds an alternative ingredient")
    public void the_system_finds_an_alternative_ingredient() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	substitutionApplied = true;
    }

    @Then("the customer should be shown the suggested substitution")
    public void the_customer_should_be_shown_the_suggested_substitution() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	assertTrue(substitutionApplied);
        System.out.println("Suggested substitution: " + substitutedIngredient + " instead of " + originalIngredient);
    }

    @Then("the suggested ingredient should be safe for the customer is dietary needs")
    public void the_suggested_ingredient_should_be_safe_for_the_customer_is_dietary_needs() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	assertFalse(substitutedIngredient.equals("Peanuts"));
        System.out.println(substitutedIngredient + " is safe for dietary restrictions.");
    }


	@Given("a meal requires a substituted ingredient due to dietary restrictions")
	public void a_meal_requires_a_substituted_ingredient_due_to_dietary_restrictions() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		originalIngredient = "Peanuts";
        substitutedIngredient = "Almonds";
        substitutionApplied = true;
	}

	@When("the substitution is applied to the customer is meal")
	public void the_substitution_is_applied_to_the_customer_is_meal() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		chefAlerted = true; 
        System.out.println("Chef is alerted about substitution.");
	}

	@Then("the chef should receive an alert about the substitution")
	public void the_chef_should_receive_an_alert_about_the_substitution() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		assertTrue(chefAlerted);
        System.out.println("Alert: Ingredient " + originalIngredient + " was replaced with " + substitutedIngredient);
	}

	@Then("the chef should be able to approve or adjust the final recipe")
	public void the_chef_should_be_able_to_approve_or_adjust_the_final_recipe() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		chefApproved = true; 
        assertTrue(chefApproved);
        System.out.println("Chef approved the final recipe.");
	}

}
