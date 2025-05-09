package myCooking;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private String name;
    private int quantity;
    private int threshold;
    private List<Inventory> lowStock=new ArrayList<>();

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
        return quantity <= threshold;
    }
    public List<Inventory> listNeedRestock(List<Inventory> inv){
        for(Inventory ing : inv) {
            if(ing.needsRestocking())lowStock.add(ing);

        }
        return lowStock;
    }

    @Override
    public String toString() {
        return name + ": " + quantity + " units (Threshold: " + threshold + ")";
    }
}
