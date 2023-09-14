// ShoppingCart.java
package shopping;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Double> items;
    private double discount;

    public ShoppingCart() {
        items = new HashMap<>();
        discount = 0.0;
    }

    public void addItem(String itemName, double price) {
        items.put(itemName, price);
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
   }

    public double calculateTotal() {
        double total = items.values().stream().mapToDouble(Double::doubleValue).sum();
        return total - (total * discount);
    }

    public void applyDiscount(double discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            discount = discountPercentage / 100;
        } else {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        }
    }

    public int getItemsCount() {
        return items.size();
    }
}
