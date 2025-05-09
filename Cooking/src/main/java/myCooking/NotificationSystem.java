package myCooking;

public class NotificationSystem {

    public boolean customerReminder(Customer customer){
        return customer.hasDeliveryScheduled();
    }

    public boolean chefReminder(Chef chef){
        return chef.hasScheduledMeal() && chef.mealIsConfirmed();
    }
}
