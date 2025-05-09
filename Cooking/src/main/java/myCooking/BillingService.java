package myCooking;

public class BillingService {
    private double totalSales;
    private double totalExpenses;
    private Customer customer;

    public BillingService( double totalSales,double totalExpenses){
        this.totalExpenses=totalExpenses;
        this.totalSales=totalSales;
    }

    public double getTotalSales(){
        return totalSales;
    }

    public void completePurchase(Customer customer,double amount){
        this.customer=customer;
        totalSales+=amount;
    }


    public boolean invoice(Customer customer,double amount){

        System.out.println("Invoice for "+amount+" was sent to "+customer.getEmail());
        return true;

    }

    public void recordExpanse(double amount){
        totalExpenses+=amount;

    }

    public String financialReport(){
        return " total revenue: "+totalSales+" total expanse: "+totalExpenses;
    }
}
