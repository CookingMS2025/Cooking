package myCooking;
import java.util.*;
import myCooking.Supplier;
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
	        if (chef.getExpertise().contains(task.getCategory()) && chef.getWorkload() < minWorkload) {
                   minWorkload = chef.getWorkload();
                    mostSuitableChef = chef;
                 }
	   }
	// Assign task to the selected chef
	    if (mostSuitableChef != null) {
	        mostSuitableChef.assignTask(task);
	    }

	    return mostSuitableChef;
	     
   }

   public Supplier comparePrice(Supplier[] supplierList,String ingredient){
	   if (supplierList==null || supplierList.length==0) {
		   throw new IllegalArgumentException("Array is null or empty");
	   }

	   double min = supplierList[0].getPrice(ingredient);
	   int mini=0;
	   for ( int i=1; i<supplierList.length;i++) {
		   if (supplierList[i].getPrice(ingredient) < min) {
			   min = supplierList[i].getPrice(ingredient);
			   mini=i;
		   }
	   }
	   return supplierList[mini];
   }



   }

