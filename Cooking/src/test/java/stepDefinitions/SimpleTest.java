package stepDefinitions;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
public class SimpleTest {
	@Given("a simple precondition")
	public void a_simple_precondition() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Precondition passed.");
	}

	@When("a simple action is taken")
	public void a_simple_action_is_taken() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Action taken.");
	}

	@Then("a simple result should happen")
	public void a_simple_result_should_happen() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Result happened.");
	}

}
