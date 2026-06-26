package com.wenzhe.sdet.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest {

    @Test
    void shouldCreateProductWhenAllFieldsAreValid() {
        Product keyboard = new Product(
                "P001",
                "Keyboard",
                new BigDecimal("50.00"),
                10
        );

        assertEquals("P001", keyboard.getId());
        assertEquals("Keyboard", keyboard.getName());
        assertEquals(new BigDecimal("50.00"), keyboard.getPrice());
        assertEquals(10, keyboard.getStockQuantity());
    }

    @Test
    void shouldThrowExceptionWhenProductIdIsEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Product("", "Keyboard", new BigDecimal("50.00"), 10)
        );
    }

    @Test
    void shouldThrowExceptionWhenPriceIsNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                new Product("P001", "Keyboard", new BigDecimal("-1.00"), 10)
        );
    }

    @Test
    void shouldReturnTrueWhenStockIsEnough() {
        Product keyboard = new Product(
                "P001",
                "Keyboard",
                new BigDecimal("50.00"),
                10
        );

        assertTrue(keyboard.hasEnoughStock(5));
    }

    @Test
    void shouldReturnFalseWhenRequestedQuantityIsGreaterThanStock() {
        Product keyboard = new Product(
                "P001",
                "Keyboard",
                new BigDecimal("50.00"),
                10
        );

        assertFalse(keyboard.hasEnoughStock(11));
    }

    @Test
    void shouldReturnFalseWhenRequestedQuantityIsZero() {
        Product keyboard = new Product(
                "P001",
                "Keyboard",
                new BigDecimal("50.00"),
                10
        );

        assertFalse(keyboard.hasEnoughStock(0));
    }
}
