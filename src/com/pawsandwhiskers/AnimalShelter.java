package com.pawsandwhiskers;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
    private final List<Pet> pets = new ArrayList<>();
    public void addPet(Pet pet) {
        pets.add(pet);
    }
    public List<Pet> getPets() {
        return pets;
    }
}
