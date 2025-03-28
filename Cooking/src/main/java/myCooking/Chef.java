package myCooking;

import java.util.List;

public class Chef {
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
	            return "This meal contains meat, which doesn't align with the customer's preferences.";
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


}
