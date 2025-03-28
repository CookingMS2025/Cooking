package myCooking;

import java.util.List;

public class RecommendationSystem {
	public static boolean isMealSafe(Customer customer, Meal meal) {
        for (String ingredient : meal.getIngredients()) {
            if (customer.getAllergies().contains(ingredient)) {
                return false; // Meal contains an allergen
            }
        }
        return true; // Meal is safe
    }

    public static void recommendMeals(Customer customer, List<Meal> meals) {
        System.out.println("Recommended meals for " + customer.getName() + ":");
        for (Meal meal : meals) {
            if (isMealSafe(customer, meal)) {
                System.out.println("- " + meal.getName());
            }
        }
    }
}
