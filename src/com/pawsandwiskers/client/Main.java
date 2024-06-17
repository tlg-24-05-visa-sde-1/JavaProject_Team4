package com.pawsandwiskers.client;

import com.pawsandwiskers.AnimalShelter;
import com.pawsandwiskers.Pet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.welcome();

        //Adopting the new pet
        String petName = shelter.namePet();
        Pet newPet = shelter.askForTypeOfPet(petName);

        if (newPet != null) {
            shelter.addPet(newPet);
            System.out.printf("Congratulations on adopting %s! ", newPet.getName() + "!");

            //Loop for the pet interaction
            boolean running = true;
            Scanner scanner = new Scanner(System.in);

            while (running) {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Feed your pet");
                System.out.println("2. Walk your pet");
                System.out.println("3. Exercise your pet");
                System.out.println("4. Play with your pet");
                System.out.println("5. Love your pet");
                System.out.println("6. Cuddle your pet");
                System.out.println("7. Pet your pet");
                System.out.println("8. Put your pet to sleep");
                System.out.println("9. Check your pet's status");
                System.out.println("10. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        newPet.eat();
                        newPet.increasePottyLevel();
                        break;
                    case 2:
                        newPet.walk();
                        newPet.decreasePottyLevel();
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
                // Periodically check the pet's hunger/thirst status
                newPet.checkHungerThirst();
                if (newPet.getLife() <= 0) {
                    System.out.println("Your pet has died. Game over.");
                    running = false;
                }
            }
            scanner.close();
        } else {
            System.out.println("Invalid choice! Please play again.");
        }
    }
}
