package com.pawsandwhiskers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DogTest {

    private Dog dog;

    @Before
    public void setUp() throws Exception {
        dog = new Dog("Buddy");
    }

    @Test
    public void testDogCreation() {
        assertNotNull(dog);
    }

    @Test
    public void testGetName() {
        assertEquals("Buddy", dog.getName());
    }

    @Test
    public void testGetEnergyLevel() {
        assertEquals(100, dog.getEnergyLevel());
    }

    @Test
    public void testSetEnergyLevel() {
        dog.setEnergyLevel(120);
        assertEquals(100, dog.getEnergyLevel()); // Energy level should not exceed 100

        dog.setEnergyLevel(80);
        assertEquals(80, dog.getEnergyLevel()); // Energy level should be set to 80

        dog.setEnergyLevel(-10);
        assertEquals(0, dog.getEnergyLevel()); // Energy level should not be below 0
    }
}
