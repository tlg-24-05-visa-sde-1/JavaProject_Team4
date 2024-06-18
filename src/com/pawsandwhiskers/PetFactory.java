package com.pawsandwhiskers;

public class PetFactory {
    private PetFactory() {     //private ctor to prevent outside instantiation
    }

    //make this throw an illegal argument exception- to cover a case in which we expand the Animal enum class and
    //refactor createPet to handle any new cases.  If this throws, where do we catch?  In AnimalShelterController
    //where the pets are created?
    public static Pet createPet(Animal animal, String name) throws IllegalArgumentException {
        if (animal == null) {
            throw new IllegalArgumentException("Animal cannot be null");
        }

        Pet pet = switch (animal) {
            case DOG -> new Dog(name);
            case CAT -> new Cat(name);
            default -> throw new IllegalArgumentException("Unknown animal type: " + animal);
        };
        return pet;
    }
}
