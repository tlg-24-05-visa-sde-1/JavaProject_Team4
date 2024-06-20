package com.pawsandwhiskers;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import static com.pawsandwhiskers.PetFactory.createPet;

public class CatTest {
    Pet cat;

    @Before
    public void setUp() {
        cat = createPet(Animal.CAT, "SnowBall");
    }


    @Test
    public void eat_shouldReduceHungerThirstBy20IncreaseLifeBy1_whenCalled() {
        cat.setHungerThirst(40);
        cat.setLife(2);
        cat.eat();
        assertEquals(20, cat.getHungerThirst());
        assertEquals(3,cat.getLife());  //life initially set to 2
    }

    @Test
    public void eat_shouldReduceHungerThirstToMinOf0AndLifeToMaxOf3() {
        cat.eat();  //HungerThirst initially set to 20 and Life to 2;
        cat.eat();
        cat.eat();
        assertEquals(0, cat.getHungerThirst());
        assertEquals(3,cat.getLife());
    }

    @Test
    public void exercise_shouldReduceEnergyBy10_whenCalled() {
        //Energy set to 50 at instantiation
        cat.exercise();
        assertEquals(40, cat.getEnergy());
    }

    @Test
    public void exercise_shouldReduceEnergyToMinOf0() {
        cat.exercise();  //Energy set to 50 at instantiation
        cat.exercise();
        cat.exercise();
        cat.exercise();
        cat.exercise();
        cat.exercise();
        assertEquals(0, cat.getEnergy());
    }

    @Test
    public void play_shouldReduceEnergyBy15_whenCalled() {
        cat.play();
        assertEquals(35, cat.getEnergy());
    }

    @Test
    public void play_shouldReduceEnergyToMinOf0() {
        cat.play();  //Energy set to 50 at instantiation
        cat.play();
        cat.play();
        cat.play();
        cat.play();
        cat.play();
        assertEquals(0, cat.getEnergy());
    }

    @Test
    public void love_shouldIncreaseEnergyBy5_whenCalled() {
        cat.love();  //Energy set to 50 at instantiation
        assertEquals(55, cat.getEnergy());
    }

    @Test
    public void love_shouldIncreaseEnergyToMaxOf100() {
        cat.setEnergy(90);
        cat.love();
        cat.love();
        cat.love();
        assertEquals(100, cat.getEnergy());
    }

    @Test
    public void cuddle_shouldIncreaseEnergyBy10_whenCalled() {
        cat.cuddle();
        assertEquals(60, cat.getEnergy());
    }

    @Test
    public void cuddle_shouldIncreaseEnergyToMaxOf100() {
        cat.setEnergy(90);
        cat.cuddle();
        cat.cuddle();
        assertEquals(100, cat.getEnergy());
    }

    @Test
    public void pet_shouldIncreaseEnergyBy5_whenCalled() {
        cat.pet();
        assertEquals(55, cat.getEnergy());
    }

    @Test
    public void pet_shouldIncreaseEnergyToMaxOf100() {
        cat.setEnergy(95);
        cat.pet();
        cat.pet();
        assertEquals(100, cat.getEnergy());
    }
    @Test
    public void sleep_shouldIncreaseEnergyBy40_whenCalled() {
        cat.sleep();
        assertEquals(90, cat.getEnergy());
    }

    @Test
    public void sleep_shouldIncreaseEnergyToMaxOf100() {
        cat.setEnergy(90);
        cat.sleep();
        assertEquals(100, cat.getEnergy());
    }

    //How do we test the print.ln?  should we have die() return the printed String?
    @Test
    public void die_shouldReturnDeathMessageString_whenCalledAndLifeIsLessThanEqualTo0() {
        cat.setLife(0);
        assertEquals( "SnowBall passed away. Rest in peace. ﮩ٨ـﮩﮩ٨ـ♡ﮩ٨ـﮩﮩ٨ـ", cat.die());
    }
}