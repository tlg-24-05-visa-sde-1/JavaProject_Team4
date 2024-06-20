package com.pawsandwhiskers;

public class PetFactory {
    private PetFactory() {     //private ctor to prevent outside instantiation
    }

    public static Pet createPet(Animal animal, String name) throws IllegalArgumentException {
        if (animal == null) {
            throw new IllegalArgumentException("Animal cannot be null");
        }

        Pet pet = switch (animal) {
            case DOG -> new Dog(name);
            case CAT -> new Cat(name);
            default ->
                    throw new IllegalArgumentException("Unknown animal type: " + animal + ", animal must be dog or cat.");
        };
        return pet;
    }
}
