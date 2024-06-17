package com.pawsandwhiskers;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
    private List<Pet> pets = new ArrayList<>();

    public Pet askForTypeOfPet(Prompter prompter, String name) {
        String puppyArt = " / \\__\n(    @\\___\n /         O\n/   (_____/\n/_/_____/ ";
        String kittenArt = " /\\_/\\  \n( o.o ) \n > ^ < ";

        System.out.println("Would you like to adopt a dog or a cat? ");
        System.out.println("\nArf Arf!\n" + puppyArt);
        System.out.println("\n Meow!\n" + kittenArt);

        String type = prompter.promptForString().toLowerCase();

        if(type.equals("cat")){
            return new Cat(name);
        } else if (type.equals("dog")) {
            return new Dog(name);
        } else {
            System.out.println("We currently only have Dogs and Cats for adoption at the moment.");
            return null;
        }
    }

    public String namePet(Prompter prompter) {
        System.out.println("What would you like to name your new pet?");
        return prompter.promptForString();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public List<Pet> getPets() {
        return pets;
    }
}
