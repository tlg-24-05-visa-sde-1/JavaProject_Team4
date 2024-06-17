package com.pawsandwhiskers.client;

import com.pawsandwhiskers.Prompter;

import java.util.Scanner;

public class ConsolePrompter implements Prompter {
    private final Scanner scanner = new Scanner(System.in);
    /*
    *This is called when user gives the pet a name
    */
    @Override
    public String promptForString() {
        return scanner.nextLine();
    }
    /*
    * This prompt is used for the interaction with the Pet
    * When user clicks which ever number between 1-10
    * */
    @Override
    public int promptForInt() {
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        return choice;
    }
}
