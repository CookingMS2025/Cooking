package myCooking;
import java.util.*;
public class KitchenManager {
   private List<Chef> chefs=new ArrayList<>();
   
   public void addChef(Chef chef) {
	   chefs.add(chef);
   }
   
   public Chef assignTaskToChef(Task task) {
	   Chef mostSuitableChef = null;
	   int minWorkload = Integer.MAX_VALUE;
	   // Find the chef with matching expertise and lowest workload
	   for (Chef chef : chefs) {
	        if (chef.getExpertise().contains(task.getCategory())) {
	            if (chef.getWorkload() < minWorkload) {
	                minWorkload = chef.getWorkload();
	                mostSuitableChef = chef;
	            }
	        }
	   }
	// Assign task to the selected chef
	    if (mostSuitableChef != null) {
	        mostSuitableChef.assignTask(task);
	    }

	    return mostSuitableChef;
	     
   }
}
