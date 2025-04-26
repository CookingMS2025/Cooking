package myCooking;

import java.util.List;

public class Meal {
	private String name;
    private List<String> ingredients;
    private boolean isCustom;
    private String createdBy;
    
    public Meal(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
        this.isCustom= false;
        this.createdBy=null;
        
    }
    public Meal(String name, List<String> ingredients,boolean isCreated,String createdBy) {
        this.name = name;
        this.ingredients = ingredients;
        this.isCustom=isCustom;
        this.createdBy= createdBy;
        
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
    
    public boolean isCustom() {
    	return isCustom;
    }
    
    public String getCreatedBy() {
    	return createdBy;
    }
    @Override
    public String toString() {
        return name + " with ingredients: " + ingredients;
    }

    

}
