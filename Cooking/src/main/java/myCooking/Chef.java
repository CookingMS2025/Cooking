package myCooking;

import java.util.List;
import java.util.ArrayList;

public class Chef {
	private String name;
	private List<String> expertise;
	private List<Task> assignedTasks=new ArrayList<>();
	private int workload;

	private boolean scheduledMeal,mealConfirmed;
	
	public Chef() {};
	
	public Chef(String name, List<String> expertise, int workload) {
	    this.name = name;
	    this.expertise = expertise;
	    this.workload = workload;
	}
	public Chef(String name,boolean scheduledMeal,boolean mealConfirmed) {
		this.name=name;
		this.mealConfirmed=mealConfirmed;
		this.scheduledMeal=scheduledMeal;

	};
	public List<String> getExpertise() { return expertise; }
	
	public int getWorkload() { return workload; }

	public List<Task> getAssignedTasks() {
	    return assignedTasks;
	}
	public void assignTask(Task task) {
	    assignedTasks.add(task);
	    workload++;
	}
	public String notifyTask(Task task) {
	    return "New Task Assigned: " + task.getName() + ". Prepare as per schedule.";
	}
	public String viewDietaryPreferences(Customer customer) {
        List<String> preferences = customer.getDietaryPreference();
        if (customer.getDietaryPreference() == null)
        	return "No preferences";
        return "Dietary Preferences: " + String.join(", ", preferences);
    }
	 public String viewAllergies(Customer customer) {
	        List<String> allergies = customer.getAllergies();
	        if (customer.getAllergies() == null) 
	        	return "No allergies";
	        return "Allergies: " + String.join(", ", allergies);
	    }
     
	 public String customizeMeal(Customer customer, Meal meal,String P, String I) {
	        StringBuilder customizationMessage = new StringBuilder();
	        
	        // Check dietary preferences
	        if (customer.getDietaryPreference().contains(P) && !meal.getIngredients().contains(I)) {
	            customizationMessage.append("Meal is friendly.\n");
	        } else if (customer.getDietaryPreference().contains(P) && meal.getIngredients().contains(I)) {
	            return "This meal contains unwanted ingredient which doesn't align with the customer's preferences.";
	        }
	     // Check allergies
	        for (String allergy : customer.getAllergies()) {
	            if (meal.getIngredients().contains(allergy)) {
	                return "This meal contains " + allergy + ", which is an allergen.";
	            }
	        }
	        
	        // Customize the meal based on preferences
	        customizationMessage.append("Meal customization completed based on preferences.");
	        return customizationMessage.toString();
	
    }
	 public void viewCustomerOrders(Customer customer, OrderHistory orderHistory) {
	        System.out.println("Chef is viewing the customer's order history...");
	        orderHistory.displayOrders(customer);
	 }
	public void suggestMealPlan(Customer customer, OrderHistory orderHistory) {
        System.out.println("Chef is suggesting a personalized meal plan based on order history...");

        // Simple logic: recommend most frequent meals or add new items
        System.out.println("Suggested Meal Plan for " + customer.getName() + ":");

        if (customer.getPastOrders().isEmpty()) {
            System.out.println("- No previous orders found. Suggesting standard healthy meal plan.");
            System.out.println("- Grilled Salmon");
            System.out.println("- Quinoa Salad");
            System.out.println("- Steamed Vegetables");
        } else {
            for (Meal meal : customer.getPastOrders()) {
                System.out.println("- " + meal.getName() + " (Customer favorite)");
            }
            System.out.println("- Chef’s Special Smoothie");
        }
	        
	 }
	 public void notifyIngredientSubstitution(String oldIng, String newIng) {
		    System.out.println("Chef Alert: Ingredient '" + oldIng + "' was replaced with '" + newIng + "'.");
		}

		public boolean hasScheduledMeal(){
		return scheduledMeal;
		}

		public boolean mealIsConfirmed(){return mealConfirmed;}
}
