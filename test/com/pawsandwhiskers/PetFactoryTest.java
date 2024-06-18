package com.pawsandwhiskers;

import org.junit.Test;
import static org.junit.Assert.*;

import static com.pawsandwhiskers.PetFactory.createPet;

public class PetFactoryTest{

    //add test(s) to check exception that createAnimal throws

    @Test(expected = IllegalArgumentException.class)
    public void createPet_shouldThrowException_NullAnimal() {
        createPet(null, "Unknown");
    }
    
    @Test
    public void createPet_shouldCreateDog_AnimalDogStringName() {
        Pet dog = createPet(Animal.DOG, "Fido");
        //check that dog has been created by getting their name
        assertEquals("Fido", dog.getName());
        //check exact class type too
        assertEquals(Dog.class, dog.getClass());
    }

    @Test
    public void createAnimal_shouldCreateCat_AnimalCatStringName() {
        Pet cat = createPet(Animal.CAT, "Boo");
        ///check that cat has been created by getting their name
        assertEquals("Boo", cat.getName());
        //check exact class type
        assertEquals(Cat.class, cat.getClass());
    }

}