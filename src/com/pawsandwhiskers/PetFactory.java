package com.pawsandwhiskers;

public class PetFactory {
    private PetFactory() {     //private ctor to prevent outside instantiation
    }
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
