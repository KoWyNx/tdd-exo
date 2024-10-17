package org.example.exercice5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopTest {
    private Shop shop;

    @BeforeEach
    public void setUp() {
        shop = new Shop(List.of());
    }

    @Test
    public void testUpdateNormalProduct() {
        Product product = new Product("normal", "Apple", 5, 10);
        shop.update(product);
        assertEquals(4, product.getSellIn());
        assertEquals(9, product.getQuality());
    }

    @Test
    public void testUpdateQualityNeverNegative() {
        Product product = new Product("normal", "Banana", 0, 0);
        shop.update(product);
        assertEquals(0, product.getQuality());
    }

    @Test
    public void testUpdateQualityMax50() {
        Product product = new Product("normal", "Cheese", 5, 50);
        shop.update(product);
        assertEquals(50, product.getQuality());
    }

    @Test
    public void testUpdateExpiredProduct() {
        Product product = new Product("normal", "Milk", 0, 10);
        shop.update(product);
        assertEquals(8, product.getQuality());
    }

    @Test
    public void testUpdateBrie() {
        Product product = new Product("brie", "Brie", 5, 10);
        shop.update(product);
        assertEquals(11, product.getQuality());
    }

    @Test
    public void testUpdateLaitier() {
        Product product = new Product("laitier", "Yogurt", 5, 10);
        shop.update(product);
        assertEquals(8, product.getQuality());
    }
}
