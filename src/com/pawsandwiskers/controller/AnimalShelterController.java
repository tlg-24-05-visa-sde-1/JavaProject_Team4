package com.pawsandwiskers.controller;

import com.pawsandwiskers.AnimalShelter;
import com.pawsandwiskers.Pet;
import com.pawsandwiskers.client.ConsolePrompter;
import com.pawsandwiskers.Prompter;
import com.pawsandwiskers.Dog;
import com.pawsandwiskers.Cat;

public class AnimalShelterController {
    private final Prompter prompter = new ConsolePrompter();
    private final AnimalShelter shelter = new AnimalShelter();

    public void execute() {
        welcome();
        String petName = shelter.namePet(prompter);
        Pet newPet = shelter.askForTypeOfPet(prompter, petName);

        if (newPet != null) {
            shelter.addPet(newPet);
            System.out.printf("Congratulations on adopting %s! ", newPet.getName() + "!");
            interactWithPet(newPet);
        } else {
            System.out.println("Invalid choice! Please play again.");
        }
    }

    private void welcome() {
        System.out.println("Welcome to Paws and Whiskers Animal Shelter!");
    }

    private void interactWithPet(Pet newPet) {
        boolean running = true;

        while (running) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Feed your pet");
            if (newPet instanceof Dog) {
                System.out.println("2. Walk your dog");
            }
            System.out.println("3. Exercise your pet");
            System.out.println("4. Play with your pet");
            System.out.println("5. Love your pet");
            System.out.println("6. Cuddle your pet");
            System.out.println("7. Pet your pet");
            System.out.println("8. Put your pet to sleep");
            System.out.println("9. Check your pet's status");
            System.out.println("10. Exit");

            int choice = prompter.promptForInt();

            switch (choice) {
                case 1:
                    newPet.eat();
                    newPet.increasePottyLevel();
                    break;
                case 2:
                    if (newPet instanceof Dog) {
                        ((Dog) newPet).walk();
                        newPet.decreasePottyLevel();
                    } else {
                        System.out.println("Invalid choice! Only dogs can be walked.");
                    }
                    break;
                case 3:
                    newPet.exercise();
                    newPet.decreaseEnergyLevel(10);
                    break;
                case 4:
                    newPet.play();
                    newPet.decreaseEnergyLevel(15);
                    break;
                case 5:
                    newPet.love();
                    break;
                case 6:
                    newPet.cuddle();
                    break;
                case 7:
                    newPet.pet();
                    break;
                case 8:
                    newPet.sleep();
                    break;
                case 9:
                    newPet.displayStatus();
                    break;
                case 10:
                    running = false;
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            newPet.checkHungerThirst();
            newPet.checkEnergyAndNeeds(); // Check energy and if needs have been met

            if (newPet.getLife() <= 0) {
                System.out.println("Your pet has died. Game over.");
                running = false;
            }
        }
    }
}
