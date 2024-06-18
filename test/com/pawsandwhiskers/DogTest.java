package com.pawsandwhiskers;

import com.pawsandwhiskers.Dog;

import org.junit.Before;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DogTest {

    private Dog dog;

    @Before

    public void setUp() {

        // Initialize a Dog object before each test

        dog = new Dog("Buddy", 86, 89, 55, 99);

    }

    @Test

    public void testEat() {

        // Save the initial values

        int initialHungerThirst = dog.getHungerThirst();

        int initialLife = dog.getLife();

        // Call the eat method

        dog.eat();

        // Verify the changes

        assertEquals(69, dog.getHungerThirst());

        assertEquals(initialLife + 1, dog.getLife());

    }

    @Test

    public void testWalk() {

        // Save the initial values

        int initialEnergy = dog.getEnergy();

        int initialPotty = dog.getPotty();

        int initialLife = dog.getLife();

        // Call the walk method

        dog.walk();

        // Verify the changes

        assertEquals(initialEnergy - 10, dog.getEnergy());

        assertEquals(initialPotty - 10, dog.getPotty());

        assertEquals(initialLife + 1, dog.getLife());

    }

    @Test

    public void testExercise() {

        // Save the initial values

        int initialEnergy = dog.getEnergy();

        // Call the exercise method

        dog.exercise();

        // Verify the changes

        assertEquals(initialEnergy - 10, dog.getEnergy());

    }

    @Test

    public void testPlay() {

        // Save the initial values

        int initialEnergy = dog.getEnergy();

        // Call the play method

        dog.play();

        // Verify the changes

        assertEquals(initialEnergy - 10, dog.getEnergy());

    }

    @Test

    public void testLove() {

        // Save the initial values

        int initialEnergy = dog.getEnergy();

        int initialLife = dog.getLife();

        // Call the love method

        dog.love();

        // Verify the changes

        assertEquals(Math.min(100, initialEnergy + 5), dog.getEnergy());

        assertEquals(initialLife + 1, dog.getLife());

    }

    @Test

    public void testCuddle() {

        // Save the initial values

        int initialEnergy = dog.getEnergy();

        // Call the cuddle method

        dog.cuddle();

        // Verify the changes

        assertEquals(Math.min(100, initialEnergy + 10), dog.getEnergy());

    }

    @Test

    public void testPet() {

        // Save the initial values

        int initialEnergy = dog.getEnergy();

        int initialLife = dog.getLife();

        // Call the pet method

        dog.pet();

        // Verify the changes

        assertEquals(Math.min(100, initialEnergy + 5), dog.getEnergy());

        assertEquals(initialLife + 1, dog.getLife());

    }

    @Test

    public void testDie() {

        // Test the die method

        // Ensure that the "died" message is printed when life is 0 or less

    }

    @Test

    public void testSleep() {

        // Save the initial values

        int initialEnergy = dog.getEnergy();

        int initialLife = dog.getLife();

        // Call the sleep method

        dog.sleep();

        // Verify the changes

        assertEquals(initialEnergy - 10, dog.getEnergy());

        assertEquals(initialLife + 1, dog.getLife());

    }

    @Test

    public void testGetEnergyLevel() {

        // Test the getEnergyLevel method

        // Ensure that it returns 100

        assertEquals(100, dog.getEnergyLevel());

    }

}
