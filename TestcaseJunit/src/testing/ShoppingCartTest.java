// ShoppingCartTest.java
package testing;

import org.junit.Before;
import org.junit.Test;
import shopping.ShoppingCart;
import static org.junit.Assert.*;
public class ShoppingCartTest {

    private ShoppingCart cart;

    @Before
    public void setUp() {
        cart = new ShoppingCart();

    }

    @Test
    public void testAddAndRemoveItems() {
    	System.out.println("Add and Remove Items");
    	
        cart.addItem("Item1", 10);
        cart.addItem("Item2", 20);
    	assertEquals("Adding Items", 2, cart.getItemsCount());
    	System.out.println(cart.getItemsCount());
    	
    	cart.removeItem("Item1");
    	assertEquals("Removing Items", 1, cart.getItemsCount());
    	System.out.println(cart.getItemsCount());
    	
    	cart.addItem("Item3", -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWithNegativePrice() {
        cart.addItem("Book", -35.0); // Attempt to add item with negative price
    }
    

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFromEmptyCart() {
        cart.removeItem("Phone"); // Attempt to remove item from empty cart
    }


    @SuppressWarnings("deprecation")
	@Test
    public void testCalculateTotal() {
    	System.out.println("Calculate Total");
        cart.addItem("Item1", 10.0);
        cart.addItem("Item2", 20.0);
    	System.out.println(cart.calculateTotal());
    	assertEquals("Calculating total",20, cart.calculateTotal());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testApplyDiscount() {
    	System.out.println("Discount");
        cart.addItem("Item1", 10.0);
        cart.addItem("Item2", 20.0);
        float discount = 10;
        cart.applyDiscount(discount);
    	System.out.println(cart.calculateTotal());
    	assertEquals("After discount",9.0,cart.calculateTotal());
    	
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDiscount() {
        double discount=-10;
    	if (discount>=0 && discount <=100)
    		cart.applyDiscount(discount);
    	else 
    		throw new IllegalArgumentException("Discount could not be negative");
    }
}
