package myCooking;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class SystemMain {

	public static void main(String[] args) {
	// Customer
		Customer customer = new Customer("Alice", "alice@example.com");

       
        customer.addDietaryPreference("Vegetarian");
        customer.addDietaryPreference("No Meat");
        customer.addAllergies("Peanuts");

       
        Meal pasta = new Meal("Pasta", Arrays.asList("Tomato", "Basil", "Cheese"));
        customer.addOrder(pasta);

        
        Meal customSalad = new Meal("Custom Salad", Arrays.asList("Lettuce", "Cucumber", "Olives"), true, customer.getName());
        customer.addCustom(customSalad);

        
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Dietary Preferences: " + customer.getDietaryPreference());
        System.out.println("Allergies: " + customer.getAllergies());

        
        System.out.println("\nPast Orders:");
        for (Meal meal : customer.getPastOrders()) {
            System.out.println("- " + meal);
        }

        
        System.out.println("\nCustom Meals:");
        for (Meal meal : customer.getCustomMeals()) {
            System.out.println("- " + meal + " (Created by: " + meal.getCreatedBy() + ")");
        }

       
        String checkIngredient = "Peanuts";
        System.out.println("\nIs '" + checkIngredient + "' restricted? " + customer.isIngredientRestricted(checkIngredient));
        
     // Meal
        //regular meal
        List<String> ingredients = Arrays.asList("Chicken", "Rice", "Broccoli");
        Meal regularMeal = new Meal("Chicken Rice Bowl", ingredients);

        // Create a custom meal
        List<String> customIngredients = Arrays.asList("Tofu", "Quinoa", "Kale");
        Meal customMeal = new Meal("Vegan Power Bowl", customIngredients, true, "Alice");

        // Display meal information
        System.out.println("Regular Meal:");
        System.out.println("- Name: " + regularMeal.getName());
        System.out.println("- Ingredients: " + regularMeal.getIngredients());
        System.out.println("- Is Custom: " + regularMeal.isCustom());
        System.out.println("- Created By: " + regularMeal.getCreatedBy());

        System.out.println("\nCustom Meal:");
        System.out.println("- Name: " + customMeal.getName());
        System.out.println("- Ingredients: " + customMeal.getIngredients());
        System.out.println("- Is Custom: " + customMeal.isCustom());
        System.out.println("- Created By: " + customMeal.getCreatedBy());

        // Use toString() method
        System.out.println("\nMeal Descriptions:");
        System.out.println(regularMeal);
        System.out.println(customMeal);
       
     //Chef
        // Step 1: Create a chef
        List<String> expertise = Arrays.asList("Vegan", "Grilling", "Salads");
        Chef chef = new Chef("Chef Oliver", expertise, 2);

        // Step 2: Create a customer with dietary info
        Customer cu1 = new Customer("Emma", "emma@example.com");
        cu1.addDietaryPreference("Vegan");
        cu1.addAllergies("Peanuts");

        // Step 3: Create a meal
        Meal meal = new Meal("Vegan Delight", Arrays.asList("Tofu", "Spinach", "Peanuts"));

        // Step 4: Chef checks preferences and allergies
        System.out.println("Viewing Customer Info:");
        System.out.println(chef.viewDietaryPreferences(cu1));
        System.out.println(chef.viewAllergies(cu1));
        // Step 5: Try customizing the meal
        System.out.println("\nCustomizing Meal:");
        String customizationResult = chef.customizeMeal(cu1, meal, "Vegan", "Peanuts");
        System.out.println(customizationResult);

        // Step 6: Assign a task
        Task task = new Task("Prepare Vegan Delight", "High");
        chef.assignTask(task);
        System.out.println("\n" + chef.notifyTask(task));
        System.out.println("Total workload: " + chef.getWorkload());
        // Step 7: Simulate customer past order and use OrderHistory
        cu1.addOrder(meal); // Add order to customer's record
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.addCustomer(cu1); // Add customer to system

        System.out.println("\n== Viewing Customer Orders ==");
        chef.viewCustomerOrders(cu1, orderHistory);

        System.out.println("\n== Suggesting Meal Plan ==");
        chef.suggestMealPlan(cu1, orderHistory);

        // Step 8: Substitution notification
        chef.notifyIngredientSubstitution("Nuts", "Sunflower Seeds");
        
    //Task
       // Create a few tasks
        Task task1 = new Task("Prepare Vegan Meal", "Cooking");
        Task task2 = new Task("Clean Kitchen", "Maintenance");

        // Display task details
        System.out.println("Task 1:");
        System.out.println("- Name: " + task1.getName());
        System.out.println("- Category: " + task1.getCategory());

        System.out.println("\nTask 2:");
        System.out.println("- Name: " + task2.getName());
        System.out.println("- Category: " + task2.getCategory());

    //OrderHistory
        // Step 1: Create a customer and some meals
        Customer cu2 = new Customer("Liam");
        Meal meal1 = new Meal("Grilled Chicken", Arrays.asList("Chicken", "Spices", "Rice"));
        Meal meal2 = new Meal("Vegetable Stir Fry", Arrays.asList("Broccoli", "Carrots", "Soy Sauce"));

        // Step 2: Add meals to customer's order history
        cu2.addOrder(meal1);
        cu2.addOrder(meal2);

        // Step 3: Create OrderHistory and add the customer
        OrderHistory orderHistory2 = new OrderHistory();
        orderHistory2.addCustomer(cu2);

        // Step 4: Display the order history
        orderHistory2.displayOrders(cu2);
        
    //KitchenManager and Supplier
        // Step 1: Create KitchenManager
        KitchenManager manager = new KitchenManager();

        // Step 2: Create and add chefs
        Chef chef1 = new Chef("Kevin", Arrays.asList("Baking", "Salads"), 1);
        Chef chef2 = new Chef("Bob", Arrays.asList("Grilling", "Cooking"), 2);
        Chef chef3 = new Chef("Charlie", Arrays.asList("Salads", "Cooking"), 0);

        manager.addChef(chef1);
        manager.addChef(chef2);
        manager.addChef(chef3);

        // Step 3: Create a task to assign
        Task ta = new Task("Prepare Caesar Salad", "Salads");
        
        // Step 4: Assign the task to the most suitable chef
        Chef assignedChef = manager.assignTaskToChef(ta);
        if (assignedChef != null) {
            System.out.println("Task \"" + task.getName() + "\" was assigned to Chef " + assignedChef.getExpertise());
        } else {
            System.out.println("No suitable chef found for the task.");
        }
        // Step 5: Create and compare supplier prices for an ingredient
        Supplier s1 = new Supplier("FreshFarm");
        s1.item("Tomato", 1.5);
        s1.item("Lettuce", 0.8);

        Supplier s2 = new Supplier("OrganicSource");
        s2.item("Tomato", 1.3);
        s2.item("Lettuce", 1.0);

        Supplier s3 = new Supplier("BudgetFoods");
        s3.item("Tomato", 1.7);
        s3.item("Lettuce", 0.9);

        Supplier[] suppliers = {s1, s2, s3};

        String ingredient = "Tomato";
        Supplier cheapest = manager.comparePrice(suppliers, ingredient);
        System.out.println("\nCheapest supplier for " + ingredient + ": " + cheapest);
     //Inventory
        // Step 1: Create some inventory items
        Inventory tomato = new Inventory("Tomato", 10, 5);
        Inventory lettuce = new Inventory("Lettuce", 3, 5);
        Inventory cheese = new Inventory("Cheese", 0, 2);
        Inventory onion = new Inventory("Onion", 7, 3);

        // Step 2: Add to inventory list
        List<Inventory> stockList = new ArrayList<>();
        stockList.add(tomato);
        stockList.add(lettuce);
        stockList.add(cheese);
        stockList.add(onion);
        // Step 3: Use some ingredients
        tomato.useIngredient(4);
        lettuce.useIngredient(2);

        // Step 4: Check which ingredients need restocking
        Inventory dummy = new Inventory("Dummy", 0, 0); // for calling listNeedRestock
        List<Inventory> needRestock = dummy.listNeedRestock(stockList);

        // Step 5: Display current stock and restock list
        System.out.println("=== Inventory Status ===");
        for (Inventory item : stockList) {
            System.out.println(item);
        }

        System.out.println("\n=== Items Needing Restock ===");
        for (Inventory item : needRestock) {
            System.out.println("- " + item.getName() + " (" + item.getQuantity() + " units left)");
        }

        // Optional: Restock an item
        cheese.restock(5);
        System.out.println("\nAfter restocking Cheese:");
        System.out.println(cheese);
        
    //BillingService
        // Step 1: Create a customer
        Customer cu3 = new Customer("Mike", "mike@example.com");

        // Step 2: Initialize billing service
        BillingService billingService = new BillingService(1000.0, 500.0); // Starting with existing sales and expenses

        // Step 3: Complete a purchase
        double purchaseAmount = 150.0;
        billingService.completePurchase(cu3, purchaseAmount);
        System.out.println("Purchase completed. Amount: " + purchaseAmount);

        // Step 4: Send invoice
        billingService.invoice(cu3, purchaseAmount);

        // Step 5: Record an additional expense
        billingService.recordExpanse(80.0);
        System.out.println("Expense of 80.0 recorded.");

        // Step 6: Print financial report
        String report = billingService.financialReport();
        System.out.println("\n=== Financial Report ===");
        System.out.println(report);
        
    //NotificationSystem
        // Step 1: Create a customer with delivery scheduled
        Customer cu4 = new Customer("Sarah", "sarah@example.com");
        // Manually set delivery scheduled using constructor (or alternatively, setter if available)
        Customer scheduledCustomer = new Customer("Mark", true); // deliveryScheduled = true

        // Step 2: Create chefs with and without scheduled meals
        Chef ch1 = new Chef("John", true, true);   // scheduled meal and confirmed
        Chef ch2 = new Chef("Emily", true, false); // scheduled but not confirmed
        Chef ch3 = new Chef("Alex", false, false); // not scheduled

        // Step 3: Create NotificationSystem
        NotificationSystem notificationSystem = new NotificationSystem();
        // Step 4: Check and print notifications for customer
        System.out.println("Customer: " + scheduledCustomer.getName());
        if (notificationSystem.customerReminder(scheduledCustomer)) {
            System.out.println("Reminder: Your delivery is scheduled!");
        } else {
            System.out.println("No delivery scheduled.");
        }
        // Step 5: Check and print notifications for chefs
        System.out.println("\nChef: " + ch1.notifyTask(new Task("Prepare Salad", "Vegetarian")));
        System.out.println("Reminder for " + ch1.getName() + ": " + (notificationSystem.chefReminder(ch1) ? "You have a confirmed meal to prepare." : "No confirmed meal scheduled."));

        System.out.println("\nChef: " + ch2.notifyTask(new Task("Bake Cake", "Dessert")));
        System.out.println("Reminder for " + ch2.getName() + ": " + (notificationSystem.chefReminder(ch2) ? "You have a confirmed meal to prepare." : "No confirmed meal scheduled."));

        System.out.println("\nChef: " + ch3.getName());
        System.out.println("Reminder for " + ch3.getName() + ": " + (notificationSystem.chefReminder(ch3) ? "You have a confirmed meal to prepare." : "No confirmed meal scheduled."));
    }              
	
}
