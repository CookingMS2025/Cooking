package myCooking;
import java.util.List;
import java.util.ArrayList;

public class Customer {
	private String Name;
	private List<String> dietaryPreferences;
	private List<String> allergies;
	private List<Meal> pastOrders;
	private List<Meal> customMeals;

	private String email;
	private boolean deliveryScheduled;
	public Customer() {
		this.dietaryPreferences=new ArrayList<String>();
		  this.allergies=new ArrayList<String>();
		  this.pastOrders=new ArrayList<Meal>();
		  this.customMeals = new ArrayList<Meal>();
	}


	public Customer(String name) {
	  this.Name=name;

	  this.dietaryPreferences=new ArrayList<String>();
	  this.allergies=new ArrayList<String>();
	  this.pastOrders=new ArrayList<Meal>();
	  this.customMeals = new ArrayList<Meal>();
	}

	public Customer(String name,String email) {
		this.Name=name;
		this.email=email;
		this.dietaryPreferences = new ArrayList<String>();
	    this.allergies = new ArrayList<String>();
	    this.pastOrders = new ArrayList<Meal>();
	    this.customMeals = new ArrayList<Meal>();}

	public Customer(String name,boolean deliveryScheduled) {
		this.Name=name;
		this.deliveryScheduled=deliveryScheduled;}
	
	public void addDietaryPreference(String preference) {
		dietaryPreferences.add(preference);
	}
	
	public void addAllergies(String Allergy) {
		allergies.add(Allergy);
	}
	public List<String> getDietaryPreference(){
		return dietaryPreferences;
	}
	public List<String> getAllergies(){
		return allergies;
	}
	public List<Meal> getPastOrders(){
		return pastOrders;
	}
	public String getName() {
		return Name;
	}
	public void addOrder(Meal meal) {
		pastOrders.add(meal);
	}
	public void addCustom(Meal meal) {
		customMeals.add(meal);
	}
	public List<Meal> getCustomMeals(){
		return customMeals;
	}
	public boolean isIngredientRestricted(String ingredient) {
	    return allergies.contains(ingredient) || dietaryPreferences.contains("No " + ingredient);
	}
	public String getEmail(){return email;}
	public boolean hasDeliveryScheduled(){
		return deliveryScheduled;
	}


}
