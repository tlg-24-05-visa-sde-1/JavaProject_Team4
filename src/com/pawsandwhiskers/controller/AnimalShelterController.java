package com.pawsandwhiskers.controller;

import com.pawsandwhiskers.*;
import com.pawsandwhiskers.client.ConsolePrompter;

import java.util.InputMismatchException;

public class AnimalShelterController {
    private final Prompter prompter = new ConsolePrompter();
    private final AnimalShelter shelter = new AnimalShelter();

    public void execute() {
        welcome();
        Pet newPet = askForTypeAndName();

        /*
         * Make sure a name is given for the pet
         * */
        if (newPet == null || newPet.getName().isEmpty()) {
            System.out.println("No name entered. Cannot continue.");
            return;
        }

        if (newPet != null) {
            shelter.addPet(newPet);
            System.out.printf("Congratulations on adopting %s! ", newPet.getName() + "!");
            interactWithPet(newPet);
        } else {
            System.out.println("Invalid choice! Please play again.");
        }
    }

    private void welcome() { //welcome banner
        System.out.println("Welcome to Paws and Whiskers Animal Shelter!");
    }

    /*
     * User is prompted what type of pet they would like to adopt
     * User will be prompted to name their pet
     *
     * case sensitive, .toLowerCase() which will make everything lowercase, so it can match.
     *
     * */

//    private Pet askForTypeAndName() {
//        String puppyArt = " / \\__\n(    @\\___\n /         O\n/   (_____/\n/_/_____/ ";
//        String kittenArt = " /\\_/\\  \n( o.o ) \n > ^ < ";
//
//        System.out.println("\nArf Arf!\n" + puppyArt);
//        System.out.println("\n Meow!\n" + kittenArt);
//
//        System.out.println("Would you like to adopt a dog or a cat? ");
//        String type = prompter.promptForString().toLowerCase();
//
//        if (type.equals("cat") || type.equals("dog")) {
//            System.out.println("What would you like to name your new pet?");
//            String name = prompter.promptForString();
//
//            if (type.equals("cat")) {
//                return
//                        PetFactory.createPet(Animal.CAT, name);
//            } else { // Assume type.equals("dog")
//                return
//                        PetFactory.createPet(Animal.DOG, name);
//            }
//        } else {
//            System.out.println("We currently only have Dogs and Cats for adoption at the moment.");
//            return null;
//        }
//    }
    /*
    * This will keep prompting the user to select type of pet (dog and cat only)
    * exception wss added to it to not allow anything other than cat/ dog
    * */

    private Pet askForTypeAndName() {
        String puppyArt =
                " ,'.-.'. \n" +
                "'\\~ o/` ,,\n" +
                " { @ } f\n" +
                " /`-'\\$ \n" +
                "(_/-\\_)  ";
        String kittenArt =
                "  /\\_/\\  (\n" +
                        " ( ^.^ ) _)\n" +
                        "   \\\"/  (\n" +
                        " ( | | )\n" +
                        "(__d b__) ";

        System.out.println("\nArf Arf!\n" + puppyArt);
        System.out.println("\n Meow!\n" + kittenArt);

        try {
            String type;
            while (true) {
                System.out.println("Would you like to adopt a dog or a cat? ");
                type = prompter.promptForString().toLowerCase();

                if (type.equals("cat") || type.equals("dog")) {
                    break;
                } else {
                    System.out.println("Invalid choice! Please choose 'dog' or 'cat'.");
                }
            }

            String name;
            while (true) {
                System.out.println("What would you like to name your new pet?");
                name = prompter.promptForString();

                if (!name.isEmpty()) {
                    break;
                } else {
                    System.out.println("No name entered. Please enter a name for your pet.");
                }
            }

            if (type.equals("cat")) {
                return PetFactory.createPet(Animal.CAT, name);
            } else { // Assume type.equals("dog")
                return PetFactory.createPet(Animal.DOG, name);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while asking for pet type and name: " + e.getMessage());
            return null;
        }
    }

    /*
     * Interaction with in the user and console
     * Cats do not go on walks, so walk is skipped on console, user does not see that is cat is selected
     */
    private void interactWithPet(Pet newPet) {
        boolean running = true;
        boolean isCat = newPet instanceof Cat; // Check if the pet is a cat

        while (running) {
            try {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Feed your pet");

                if (!isCat) {
                    System.out.println("2. Walk your dog");
                    System.out.println("3. Exercise your pet");
                } else {
                    System.out.println("2. Exercise your pet");
                }

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
                        if (!isCat) {
                            ((Dog) newPet).walk();
                            newPet.decreasePottyLevel();
                        } else {
                            newPet.exercise();
                            newPet.decreaseEnergyLevel(10);
                        }
                        break;
                    case 3:
                        if (!isCat) {
                            newPet.exercise();
                            newPet.decreaseEnergyLevel(10);
                        }
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
                        newPet.decreaseEnergyLevel(30);
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

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 10.");
                prompter.promptForString(); // Consume invalid input
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
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

