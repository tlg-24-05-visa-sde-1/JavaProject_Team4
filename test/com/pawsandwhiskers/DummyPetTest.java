package com.pawsandwhiskers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DummyPetTest {
    private DummyPet pet;

    @Before
    public void setUp() {
        pet = new DummyPet ("Buddy");
    }

    @Test
    public void testDummyPet1ArgCtorInitialValues() {
        assertEquals("Buddy", pet.getName());
        assertEquals(2, pet.getLife());
        assertEquals(0, pet.getPotty());
        assertEquals(20, pet.getHungerThirst());
        assertEquals(50, pet.getEnergy());
    }

    @Test
    public void setEnergy_shouldSetEnergyToPassedInt_Int0to100() {
        pet.setEnergy(100);
        assertEquals(100, pet.getEnergy());
        pet.setEnergy(0);
        assertEquals(0, pet.getEnergy());
    }

    @Test
    public void setEnergy_shouldSetEnergyTo100_IntGreaterThan100() {
        pet.setEnergy(101);
        assertEquals(100, pet.getEnergy());
    }

    @Test
    public void setEnergy_shouldSetEnergyTo0_IntLessThan0() {
        pet.setEnergy(-1);
        assertEquals(0, pet.getEnergy());
    }

    //named member-level inner class - private b/c only DummyPetTest needs it
    private class DummyPet extends Pet{

        private DummyPet(String name) {
            super(name);
        }


        @Override
        public void eat() {
        }
        @Override
        public void exercise() {
        }

        @Override
        public void play() {

        }

        @Override
        public void love() {

        }

        @Override
        public void cuddle() {

        }

        @Override
        public void pet() {

        }

        @Override
        public String die() {
            return "";
        }


        @Override
        public void sleep() {

        }
    }

}
