package myCooking;

public class Inventory {
    private String name;
    private int quantity;
    private int threshold;

    public Inventory(String name,int quantity,int threshold ){
        this.name=name;
        this.quantity=quantity;
        this.threshold=threshold;

    }
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void useIngredient(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
        } else {
            throw new IllegalArgumentException("Not enough stock");
        }
    }

    public void restock(int amount) {
        quantity += amount;
    }

    public boolean needsRestocking() {
        return quantity < threshold;
    }

    @Override
    public String toString() {
        return name + ": " + quantity + " units (Threshold: " + threshold + ")";
    }
}
