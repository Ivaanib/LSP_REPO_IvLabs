package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for ShoppingCart.
 */
public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test for adding valid item")
    void testAddValidItem() {
        cart.addItem("Book", 29.99);
        assertEquals(1, cart.getCartSize(), "Cart should contain one item");
        assertEquals(29.99, cart.getTotalCost(), "Total cost should be 29.99");
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    void testAddItemZeroPrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Pen", 0.0);
        });
        assertEquals("Price must be positive.", exception.getMessage());
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    void testAddItemNegativePrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Pen", -5.0);
        });
        assertEquals("Price must be positive.", exception.getMessage());
    }
    @Test
    @DisplayName("Test for removing existing item")
    void testRemoveExistingItem() {
        cart.addItem("Book", 29.99);
        cart.removeItem("Book");
        assertEquals(0, cart.getCartSize(), "Cart should be empty after removal");
        assertEquals(0.0, cart.getTotalCost(), "Total cost should be 0.0");
    }

    @Test
    @DisplayName("Test for removing non-existent item (expect exception)")
    void testRemoveNonExistentItem() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.removeItem("Book");
        });
        assertEquals("Item does not exist in the cart.", exception.getMessage());
    }

    @Test
    @DisplayName("Test for applying SAVE10")
    void testApplySave10Discount() {
        cart.addItem("Book", 100.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), "Discount should be 10%");
        assertEquals(90.0, cart.getTotalCost(), "Total cost should be 90.0 after 10% discount");
    }

    @Test
    @DisplayName("Test for applying SAVE20")
    void testApplySave20Discount() {
        cart.addItem("Book", 100.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), "Discount should be 20%");
        assertEquals(80.0, cart.getTotalCost(), "Total cost should be 80.0 after 20% discount");
    }

    @Test
    @DisplayName("Test for applying invalid code (expect exception)")
    void testApplyInvalidDiscountCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
        assertEquals("Invalid discount code.", exception.getMessage());
    }

    @Test
    @DisplayName("Test total cost without discount")
    void testTotalCostWithoutDiscount() {
        cart.addItem("Book", 50.0);
        cart.addItem("Pen", 10.0);
        assertEquals(60.0, cart.getTotalCost(), "Total cost should be 60.0 without discount");
    }

    @Test
    @DisplayName("Test total cost with discount")
    void testTotalCostWithDiscount() {
        cart.addItem("Book", 50.0);
        cart.addItem("Pen", 50.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(80.0, cart.getTotalCost(), "Total cost should be 80.0 after 20% discount");
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    void testTotalCostEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), "Total cost should be 0.0 for empty cart");
    }

    @Test
    @DisplayName("Test cart size updates after adding and removing")
    void testCartSizeUpdates() {
        assertEquals(0, cart.getCartSize(), "Initial cart size should be 0");
        cart.addItem("Book", 29.99);
        assertEquals(1, cart.getCartSize(), "Cart size should be 1 after adding");
        cart.addItem("Pen", 5.0);
        assertEquals(2, cart.getCartSize(), "Cart size should be 2 after adding another item");
        cart.removeItem("Book");
        assertEquals(1, cart.getCartSize(), "Cart size should be 1 after removing");
    }
}