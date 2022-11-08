package com.korneeva.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class containerTest {

    container<Integer> container;

    @BeforeEach
    public void setUp() { container = new container<>(); }

    @Test
    void testIsEmptyTrue() {
        assertEquals(true, container.is_empty());
    }

    @Test
    void testIsEmptyFalse() {
        container.addElem(4);
        container.addElem(3);
        container.addElem(7);

        assertEquals(false, container.is_empty());
    }

    @Test
    void testGetElemSuccessful() {
        container.addElem(4);
        container.addElem(3);
        container.addElem(7);

        assertEquals(7, container.getElem(4).getValue());
    }

    @Test
    void testGetElemOutOfRange() {
        container.addElem(5);
        assertEquals(null, container.getElem(0));
    }

    @Test
    void testAddElemByValue() {
        assertEquals(true, container.addElem(7));
    }

    @Test
    void testAddElemByIndex() {
        container.addElem(4);
        container.addElem(5);
        container.addElem(6);
        container.addElem(7);

        assertEquals(8, container.getElem(3).getValue());
    }

    @Test
    void testDeleteElemSuccessful() {
        container.addElem(4);
        container.addElem(5);
        container.addElem(6);
        container.addElem(7);

        assertEquals(true, container.deleteElem(3));
    }

    @Test
    void testDeleteElemFromEmptyList() {
        assertEquals(false, container.deleteElem(4));
    }
}