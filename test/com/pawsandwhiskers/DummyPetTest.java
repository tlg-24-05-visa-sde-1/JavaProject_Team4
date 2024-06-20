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
    public void setEnergy_shouldSetEnergyToPassedInt_Int0to100Inclusive() {
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

    @Test
    public void setLife_shouldSetLifetoValuePassed_IntBetween0And3Inclusive() {
        pet.setLife(0);
        assertEquals(0,pet.getLife());
        pet.setLife(3);
        assertEquals(3,pet.getLife());
    }

    @Test
    public void setLife_shouldSetLifeto0_IntLessThan0() {
        pet.setLife(-1);
        assertEquals(0,pet.getLife());;
    }

    @Test
    public void setLife_shouldSetLifeto3_IntGreaterThan3() {
        pet.setLife(4);
        assertEquals(3,pet.getLife());;
    }

    @Test
    public void setPotty_shouldSetPottytoIntPAssed_IntBetween0And100Inclusive() {
        pet.setPotty(0);
        assertEquals(0,pet.getPotty());
        pet.setPotty(100);
        assertEquals(100, pet.getPotty());
    }

    @Test
    public void setPotty_shouldSetEnergyTo100_IntGreaterThan100() {
        pet.setPotty(101);
        assertEquals(100, pet.getPotty());
    }

    @Test
    public void setPotty_shouldSetEnergyTo0_IntLessThan0() {
        pet.setPotty(-1);
        assertEquals(0, pet.getPotty());
    }

    @Test
    public void setHungerThirst_shouldSetHungerThirstToIntPassed_IntBetween0And100Inclusive() {
        pet.setHungerThirst(100);
        assertEquals(100,pet.getHungerThirst());
        pet.setHungerThirst(0);
        assertEquals(0, pet.getHungerThirst());
    }

    @Test
    public void setHungerThirst_shouldSetHungerThirst0_IntLessThan0() {
        pet.setHungerThirst(-1);
        assertEquals(0,pet.getHungerThirst());
    }

    @Test
    public void setHungerThirst_shouldSetHungerThirst100_IntGreaterThan100() {
        pet.setHungerThirst(101);
        assertEquals(100,pet.getHungerThirst());
    }

    @Test
    public void increasePottyLevel_shouldIncreasePottyLevelBy10UpTo100_whenCalled() {
        pet.setPotty(10);
        pet.increasePottyLevel();
        assertEquals(20, pet.getPotty());
    }

    @Test
    public void increasePottyLevel_shouldSetPottyLevelToMaxOf100_whenCalled() {
        pet.setPotty(100);
        pet.increasePottyLevel();
        assertEquals(100, pet.getPotty());
    }

    @Test
    public void decreasePottyLevel_shouldDecreasePottyLevelBy40MinOf0_whenCalled() {
        pet.setPotty(50);
        pet.decreasePottyLevel();
        assertEquals(10, pet.getPotty());
    }

    @Test
    public void decreasePottyLevel_shouldDecreasePottyLevelToMinOf0_ifCalledAndPottyLevelIs0() {
        pet.setPotty(0);
        pet.decreasePottyLevel();
        assertEquals(0, pet.getPotty());
    }

    @Test
    public void decreaseEnergyLevel_shouldDecreaseEnergyLevelByIntPassed_Int() {
        pet.setEnergy(50);
        pet.decreaseEnergyLevel(40);
        assertEquals(10, pet.getEnergy());
    }

    @Test
    public void decreaseEnergyLevel_shouldDecreaseToMinOf0_Int() {
        pet.setEnergy(30);
        pet.decreaseEnergyLevel(40);
        assertEquals(0, pet.getEnergy());
    }

    @Test
    public void decreaseLife_shouldDecreaseLifeBy1_whenCalled() {
        pet.setLife(2);
        pet.decreaseLife();
        assertEquals(1, pet.getLife());
        pet.decreaseLife();
        assertEquals(0,pet.getLife());
    }

    @Test
    public void checkHungerThirst_shouldReduceLifeBy1IfHungerThirstEqualToOrGreaterThan100() {
        pet.setLife(2);
        pet.setHungerThirst(100);
        pet.checkHungerThirst();
        assertEquals(1,pet.getLife());
    }

    @Test
    public void checkHungerThirst_shouldNotReduceLifeBy1IfHungerThirstUnder100() {
        pet.setLife(2);
        pet.setHungerThirst(99);
        pet.checkHungerThirst();
        assertEquals(2,pet.getLife());
    }

    @Test
    public void checkHungerThirst_shouldSetHungerTo0IfCalledAndLifeIsDecreasedByOne() {
        pet.setHungerThirst(100);
        pet.checkHungerThirst();
        assertEquals(0,pet.getHungerThirst());
    }

    @Test
    public void checkNeeds_shouldReduceLifeBy1IfCalledAndEnergyLessThanEqualToZero() {
        pet.setLife(2);
        pet.setEnergy(0);
        pet.checkNeeds();
        assertEquals(1, pet.getLife());
    }

    @Test
    public void checkNeeds_shouldNotReduceLifeBy1IfCalledAndEnergyGreaterThan0() {
        pet.setLife(2);
        pet.setEnergy(1);
        pet.checkNeeds();
        assertEquals(2, pet.getLife());
    }

    @Test
    public void checkNeeds_shouldReduceLifeBy1IfCalledAndPottyGreaterThanEqualTo100() {
        pet.setLife(2);
        pet.setPotty(100);
        pet.checkNeeds();
        assertEquals(1, pet.getLife());
    }

    @Test
    public void checkNeeds_shouldNotReduceLifeBy1IfCalledAndPottyLessThan100() {
        pet.setLife(2);
        pet.setPotty(99);
        pet.checkNeeds();
        assertEquals(2, pet.getLife());
    }

    @Test
    public void checkNeeds_shouldReduceLifeBy1IfCalledAndHungerThirstGreaterThanEqualTo100() {
        pet.setLife(2);
        pet.setHungerThirst(100);
        pet.checkNeeds();
        assertEquals(1, pet.getLife());
    }

    @Test
    public void checkNeeds_shouldNotReduceLifeBy1IfCalledAndHungerThirstLessThan100() {
        pet.setLife(2);
        pet.setHungerThirst(99);
        pet.checkNeeds();
        assertEquals(2, pet.getLife());
    }

    @Test
    public void hasBeenWalkedExercisedOrPlayed_shouldReturnFalseIfEnergyPottyOrHungerThirstEqual100() {
        pet.setHungerThirst(100);
        assertFalse(pet.hasBeenWalkedExercisedOrPlayed());
    }

    @Test
    public void checkEnergyAndNeeds_shouldDecreaseLifeByOneIfCalledAndEnergyGreaterEqualTo100AndHasBeenWalkedExerciseOrPlayedIsFalse() {
        pet.setLife(2);
        pet.setEnergy(100);    //Setting Energy, HungerThirst, or Potty to 100 turns hasBeenWalkedExercisedOrPlayed to false
        pet.setPotty(100);
        pet.checkEnergyAndNeeds();
        assertEquals(1,pet.getLife());
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
