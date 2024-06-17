package com.pawsandwhiskers;

public class PetFactory {
    private PetFactory() {     //private ctor to prevent outside instantiation
    }
    //do we need an exception here since we're dealing with Enums?  Maybe for String name?
    //may need to convert from String to Enum?
    public static Pet createPet(Animal animal, String name){
        Pet pet = null;
         if (animal.equals(Animal.DOG)){
             pet = new Dog(name);
         }
         else{
             pet = new Cat(name);
         }
         return pet;
    }
}
