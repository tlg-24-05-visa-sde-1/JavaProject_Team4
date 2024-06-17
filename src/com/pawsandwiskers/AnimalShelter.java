package com.pawsandwiskers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalShelter {
    private List<Pet> pets = new ArrayList<>();

    public void welcome(){

        System.out.println("Welcome to Paws and Whiskers Animal Shelter!");

    }

    public Pet askForTypeOfPet(String name){
        String puppyArt = " / \\__\n(    @\\___\n /         O\n/   (_____/\n/_/_____/ ";
        String kittenArt = " /\\_/\\  \n( o.o ) \n > ^ < ";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to adopt a dog or a cat? ");

        System.out.println("\nArf Arf!\n" + puppyArt);
        System.out.println("\n Meow!\n" + kittenArt);

        String type = scanner.nextLine().toLowerCase();

        if(type.equals("cat")){
            return new Cat(name);
        } else if (type.equals("dog")) {
            return new Dog(name);
        } else {
            System.out.println("We currently only have Dogs and Cats for adoption at the moment.");
            return null;
        }
    }

    public String namePet(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to name your new pet");
        return scanner.nextLine();
    }

    public void addPet(Pet pet){
        pets.add(pet);
    }

    public List<Pet> getPets(){
        return pets;
    }
}
