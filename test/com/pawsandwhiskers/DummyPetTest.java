package com.pawsandwhiskers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DummyPetTest {
    private Pet testPet;

    @Before
    public void setUp() {
    testPet = new DummyPet("Buddy");
    }

    @Test
    public void testInitialValues() {
        assertEquals("Buddy", testPet.getName());
    }

    //NAMED MEMBER-LEVEL INNER CLASSES - make it private b/c only DummyPetTest needs it
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
