package myCooking;

import java.util.HashMap;
import java.util.Map;

public class Supplier {
    private String name;
    private Map<String,Double> prices;

    public Supplier(String name){
        this.name=name;
        this.prices=new HashMap<>();

    }

    public void item(String ingredient,double price){
        prices.put(ingredient,price);
    }

    public double getPrice(String ingredient){
        return prices.get(ingredient);

    }
    @Override
    public String toString() {
        String result= "Supplier: "+ name+"\n";
        for (Map.Entry<String, Double> entry : prices.entrySet()) {
            result+= entry.getKey()+": " + entry.getValue()+"\n";
        }
        return result;
    }


}