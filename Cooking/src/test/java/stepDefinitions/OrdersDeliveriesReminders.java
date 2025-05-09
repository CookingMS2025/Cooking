package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myCooking.Chef;
import myCooking.Customer;
import myCooking.NotificationSystem;
import static org.junit.Assert.*;


public class OrdersDeliveriesReminders {
    private NotificationSystem nt=new NotificationSystem();
    private Customer customer;
    private Chef chef;
    private boolean customerReminder,chefReminder;


    @Given("a customer has a meal scheduled for delivery tomorrow")
    public void aCustomerHasAMealScheduledForDeliveryTomorrow() {
        customer=new Customer("Matt",true);

    }


    @When("the system checks for upcoming deliveries")
    public void theSystemChecksForUpcomingDeliveries() {
        customerReminder=nt.customerReminder(customer);


    }

    @Then("the customer should receive a reminder about the upcoming meal delivery")
    public void theCustomerShouldReceiveAReminderAboutTheUpcomingMealDelivery() {
        assertTrue(customerReminder);
    }

    @Given("a chef has a scheduled meal to prepare")
    public void aChefHasAScheduledMealToPrepare() {
        chef=new Chef("Sara",true,false);
    }

    @And("the meal is confirmed and listed in the chef's task queue")
    public void theMealIsConfirmedAndListedInTheChefSTaskQueue() {
        chef=new Chef("Sara",true,true);

    }

    @When("the system checks for scheduled cooking tasks")
    public void theSystemChecksForScheduledCookingTasks() {
        chefReminder=nt.chefReminder(chef);
    }

    @Then("the chef should receive a reminder to start preparing the meal")
    public void theChefShouldReceiveAReminderToStartPreparingTheMeal() {
        assertTrue(chefReminder);
    }
}
