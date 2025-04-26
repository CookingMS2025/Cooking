package stepDefinitions;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import java.util.List;
import java .util.ArrayList;
import java.util.Arrays;
import myCooking.*;

public class AssignTasksSteps {
	KitchenManager manager;
    Chef selectedChef;
    Task assignedTask;
    String notification;
    
	@Given("a kitchen manager has a list of chefs with their current workloads and expertise")
	public void a_kitchen_manager_has_a_list_of_chefs_with_their_current_workloads_and_expertise() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		 manager = new KitchenManager();
	     manager.addChef(new Chef("Mary", Arrays.asList("Italian"), 2));
	     manager.addChef(new Chef("Tony", Arrays.asList("Desserts"), 1));
		
	}

	@When("the manager assigns a new cooking task")
	public void the_manager_assigns_a_new_cooking_task() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		assignedTask = new Task("Chocolate Waffles", "Desserts");
        selectedChef = manager.assignTaskToChef(assignedTask);
	}

	@Then("the system should assign the task to the most suitable chef")
	public void the_system_should_assign_the_task_to_the_most_suitable_chef() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		assertNotNull(selectedChef);
        assertTrue(selectedChef.getAssignedTasks().contains(assignedTask));
	}

	@Then("the chef is workload should be updated")
	public void the_chef_is_workload_should_be_updated() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		assertTrue(selectedChef.getWorkload() > 0);
	}

	@Given("a chef has been assigned a new cooking task")
	public void a_chef_has_been_assigned_a_new_cooking_task() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		assignedTask = new Task("Chocolate Waffles", "Desserts");
        selectedChef = new Chef("Tony", Arrays.asList("Desserts"), 1);
        selectedChef.assignTask(assignedTask);
	}

	@When("the system sends a notification")
	public void the_system_sends_a_notification() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		notification = selectedChef.notifyTask(assignedTask);
	}

	@Then("the chef should receive the task details")
	public void the_chef_should_receive_the_task_details() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		assertNotNull(notification);
        assertTrue(notification.contains("Chocolate Waffles"));
	}

	@Then("be able to prepare the meal on time")
	public void be_able_to_prepare_the_meal_on_time() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		 assertTrue(notification.contains("Prepare"));
	}
}
