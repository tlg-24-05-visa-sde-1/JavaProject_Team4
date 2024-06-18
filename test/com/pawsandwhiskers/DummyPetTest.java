package com.pawsandwhiskers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DummyPetTest {
    private DummyPet pet;

    // Dummy subclass of Pet to test abstract methods
    private static class DummyPet extends Pet {
        public DummyPet(String name) {
            super(name);
        }

        @Override
        public void eat() {
            setHungerThirst(getHungerThirst() - 20);
            increaseLife();
        }

        @Override
        public void exercise() {
            decreaseEnergyLevel(10);
        }

        @Override
        public void play() {
            decreaseEnergyLevel(15);
        }

        @Override
        public void love() {
            setEnergy(getEnergy() + 5);
        }

        @Override
        public void cuddle() {
            setEnergy(getEnergy() + 10);
        }

        @Override
        public void pet() {
            setEnergy(getEnergy() + 5);
        }

        @Override
        public String die() {
            return getName() + " died 🐾";
        }

        @Override
        public void sleep() {
            setEnergy(getEnergy() + 20);
        }
    }

    @Before
    public void setUp() {
        pet = new DummyPet("TestPet");
    }

    @Test
    public void testEat() {
        pet.setHungerThirst(40);
        pet.setLife(2);
        pet.eat();
        assertEquals(20, pet.getHungerThirst());
        assertEquals(3, pet.getLife());
    }

    @Test
    public void testEat_MinHungerThirst_MaxLife() {
        pet.setHungerThirst(40);
        pet.setLife(3);
        pet.eat();
        pet.eat();
        pet.eat();
        assertEquals(0, pet.getHungerThirst());
        assertEquals(3, pet.getLife());
    }

    @Test
    public void testExercise() {
        pet.setEnergy(50);
        pet.exercise();
        assertEquals(40, pet.getEnergy());
    }

    @Test
    public void testExercise_MinEnergy() {
        pet.setEnergy(50);
        for (int i = 0; i < 6; i++) {
            pet.exercise();
        }
        assertEquals(0, pet.getEnergy());
    }

    @Test
    public void testPlay() {
        pet.setEnergy(50);
        pet.play();
        assertEquals(35, pet.getEnergy());
    }

    @Test
    public void testPlay_MinEnergy() {
        pet.setEnergy(50);
        for (int i = 0; i < 4; i++) {
            pet.play();
        }
        assertEquals(0, pet.getEnergy());
    }

    @Test
    public void testLove() {
        pet.setEnergy(50);
        pet.love();
        assertEquals(55, pet.getEnergy());
    }

    @Test
    public void testLove_MaxEnergy() {
        pet.setEnergy(95);
        pet.love();
        pet.love();
        pet.love();
        assertEquals(100, pet.getEnergy());
    }

    @Test
    public void testCuddle() {
        pet.setEnergy(50);
        pet.cuddle();
        assertEquals(60, pet.getEnergy());
    }

    @Test
    public void testCuddle_MaxEnergy() {
        pet.setEnergy(95);
        pet.cuddle();
        pet.cuddle();
        pet.cuddle();
        assertEquals(100, pet.getEnergy());
    }

    @Test
    public void testPet() {
        pet.setEnergy(50);
        pet.pet();
        assertEquals(55, pet.getEnergy());
    }

    @Test
    public void testPet_MaxEnergy() {
        pet.setEnergy(95);
        pet.pet();
        pet.pet();
        assertEquals(100, pet.getEnergy());
    }

    @Test
    public void testDie() {
        pet.setLife(0);
        assertEquals("TestPet died 🐾", pet.die());
    }

    @Test
    public void testSleep() {
        pet.setEnergy(50);
        pet.sleep();
        assertEquals(70, pet.getEnergy());
    }

    @Test
    public void testSleep_MaxEnergy() {
        pet.setEnergy(85);
        pet.sleep();
        pet.sleep();
        assertEquals(100, pet.getEnergy());
    }
}
