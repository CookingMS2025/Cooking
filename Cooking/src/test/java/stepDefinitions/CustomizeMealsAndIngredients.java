package stepDefinitions;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import io.cucumber.java.en.*;
import java.util.List;
import java .util.ArrayList;
import myCooking.Chef;
import myCooking.Customer;
import myCooking.Meal;
public class CustomizeMealsAndIngredients {
	private List<String> selectedIngredients;
	private String mealName;
	private Meal customMeal;
	private String validationMessage;
	
	@Given("a customer wants to customize a new meal")
	public void a_customer_wants_to_customize_a_new_meal() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		selectedIngredients=new ArrayList<>();
		
	}

	@When("the customer selects ingredients")
	public void the_customer_selects_ingredients() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		selectedIngredients.add("Eggs");
		selectedIngredients.add("wheat");
		selectedIngredients.add("Vanilla");
		selectedIngredients.add("Sugar");
		selectedIngredients.add("Milk");
	}

	@When("the customer names the meal")
	public void the_customer_names_the_meal() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		this.mealName="Cake";
	}

	@Then("the system should create and store the custom meal")
	public void the_system_should_create_and_store_the_custom_meal() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		customMeal=new Meal(mealName,selectedIngredients);
		assertNotNull("custom meal should be created",customMeal);
		assertEquals(mealName,customMeal.getName());
		assertFalse("custom meal should have ingredients",customMeal.getIngredients().isEmpty());
	}

	@Given("the customer chooses ingredients")
	public void the_customer_chooses_ingredients() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		selectedIngredients=new ArrayList<>();
		selectedIngredients.add("Eggs");
		selectedIngredients.add("wheat");
		selectedIngredients.add("Vanilla");
		selectedIngredients.add("Sugar");
		selectedIngredients.add("Milk");
	}

	@When("the system checks for incompatible ingredients")
	public void the_system_checks_for_incompatible_ingredients() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		if(selectedIngredients.contains("Fish")&& selectedIngredients.contains("Milk")) {
			validationMessage="Incompatible Ingredients";
		}
		else {
			validationMessage="valid ingredients";
		}
	}

	@Then("the system should reject the custom meal due to incompatibility")
	public void the_system_should_reject_the_custom_meal_due_to_incompatibility() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		assertEquals("valid ingredients",validationMessage);
	}

}
