package myCooking;

public class Task {
   private String name;
   private String category;
   
   public Task(String Name, String Category) {
	   this.name=Name;
	   this.category=Category;
   }
   public String getName() {
	   return name;
   }
   public String getCategory() {
	   return category;
   }
   
}
