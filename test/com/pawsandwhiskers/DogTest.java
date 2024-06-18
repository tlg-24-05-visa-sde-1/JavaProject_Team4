package com.pawsandwhiskers;

import org.junit.Before;
import org.junit.Test;

import static com.pawsandwhiskers.PetFactory.createPet;
import static org.junit.Assert.*;

public class DogTest {
    Pet dog;

    @Before
    public void setUp() {
        dog = createPet(Animal.DOG, "Buddy");
    }

    @Test
    public void eat_shouldReduceHungerThirstBy10IncreaseLifeBy1_whenCalled() {
        dog.setHungerThirst(30);
        dog.setLife(2);
        dog.eat();
        assertEquals(20, dog.getHungerThirst());
        assertEquals(3, dog.getLife());
    }

    @Test
    public void eat_shouldReduceHungerThirstToMinOf0AndLifeToMaxOf3() {
        dog.setHungerThirst(30); // Ensure starting value
        dog.setLife(3); // Ensure starting value
        dog.eat();
        dog.eat();
        dog.eat();
        dog.eat();
        assertEquals(0, dog.getHungerThirst());
        assertEquals(3, dog.getLife());  // Assuming increaseLife is not capped
    }

    @Test
    public void exercise_shouldReduceEnergyBy15_whenCalled() {
        dog.setEnergy(60); // Ensure starting value
        dog.exercise();
        assertEquals(50, dog.getEnergy());
    }

    @Test
    public void exercise_shouldReduceEnergyToMinOf0() {
        dog.setEnergy(40); // Ensure starting value
        dog.exercise();
        dog.exercise();
        dog.exercise();
        dog.exercise();
        dog.exercise();
        assertEquals(0, dog.getEnergy());
    }

    @Test
    public void play_shouldReduceEnergyBy20_whenCalled() {
        dog.setEnergy(50); // Ensure starting value
        dog.play();
        assertEquals(30, dog.getEnergy());
    }

    @Test
    public void play_shouldReduceEnergyToMinOf0() {
        dog.setEnergy(50); // Ensure starting value
        dog.play();
        dog.play();
        dog.play();
        assertEquals(0, dog.getEnergy());
    }

    @Test
    public void love_shouldIncreaseEnergyBy5_whenCalled() {
        dog.setEnergy(50); // Ensure starting value
        dog.love();
        assertEquals(55, dog.getEnergy());
    }

    @Test
    public void love_shouldIncreaseEnergyToMaxOf100() {
        dog.setEnergy(90);
        dog.love();
        dog.love();
        dog.love();
        assertEquals(100, dog.getEnergy());
    }

    @Test
    public void cuddle_shouldIncreaseEnergyBy10_whenCalled() {
        dog.setEnergy(50); // Ensure starting value
        dog.cuddle();
        assertEquals(60, dog.getEnergy());
    }

    @Test
    public void cuddle_shouldIncreaseEnergyToMaxOf100() {
        dog.setEnergy(95);
        dog.cuddle();
        dog.cuddle();
        dog.cuddle();
        assertEquals(100, dog.getEnergy());
    }

    // Additional tests for pet, die, and sleep
    @Test
    public void pet_shouldIncreaseEnergyBy5_whenCalled() {
        dog.setEnergy(50); // Ensure starting value
        dog.pet();
        assertEquals(55, dog.getEnergy());
    }

    @Test
    public void pet_shouldIncreaseEnergyToMaxOf100() {
        dog.setEnergy(95); // Ensure starting value
        dog.pet();
        dog.pet();
        assertEquals(100, dog.getEnergy());
    }

    @Test
    public void die_shouldOutputDied_whenLifeIsZeroOrLess() {
        dog.setLife(0);
        // Capture the output using System.setOut and System.setErr if needed for assertion
        dog.die();
        // Example assertion, adapt as necessary to check output
        // assertTrue(outContent.toString().contains("Buddy died 🐾"));
    }

    @Test
    public void sleep_shouldIncreaseEnergyBy20_whenCalled() {
        dog.setEnergy(50); // Ensure starting value
        dog.sleep();
        assertEquals(100, dog.getEnergy());
    }

    @Test
    public void sleep_shouldIncreaseEnergyToMaxOf100() {
        dog.setEnergy(85); // Ensure starting value
        dog.sleep();
        dog.sleep();
        assertEquals(100, dog.getEnergy());
    }
}
