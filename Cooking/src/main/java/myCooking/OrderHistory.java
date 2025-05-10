package myCooking;
import java.util.ArrayList;
import java.util.List;
public class OrderHistory {
	private List<Customer> customers;

    public OrderHistory() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public void displayOrders(Customer customer) {
        System.out.println("Order History for " + customer.getName() + ":");
        for (Meal m : customer.getPastOrders()) {
            System.out.println("- " + m.getName());
        }
    }
    
}
