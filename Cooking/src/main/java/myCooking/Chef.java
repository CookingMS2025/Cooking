package myCooking;

import java.util.List;
import java.util.ArrayList;

public class Chef {
	private String name;
	private List<String> expertise;
	private List<Task> assignedTasks=new ArrayList<>();
	private int workload;
	
	public Chef() {};
	
	public Chef(String name, List<String> expertise, int workload) {
	    this.name = name;
	    this.expertise = expertise;
	    this.workload = workload;
	}
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
        if (preferences.isEmpty()) {
            return "No dietary preferences set.";
        }
        return "Dietary Preferences: " + String.join(", ", preferences);
    }
	 public String viewAllergies(Customer customer) {
	        List<String> allergies = customer.getAllergies();
	        if (allergies.isEmpty()) {
	            return "No allergies set.";
	        }
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
	 public void viewCustomerOrders(Customer c) {
		 System.out.println("Chef viewing past orders for " + c.getName() + ":");
		 for(Meal m:c.getPastOrders()) {
			 System.out.println("- " + m.getName());
		 }
	 }
	 public void suggestMealPlan() {
		 System.out.println("Chef suggests a balanced meal plan based on customer history.");
	 }
	 public void notifyIngredientSubstitution(String oldIng, String newIng) {
		    System.out.println("Chef Alert: Ingredient '" + oldIng + "' was replaced with '" + newIng + "'.");
		}

}
