package com.pawsandwhiskers.client;

import com.pawsandwhiskers.Prompter;

import java.util.Scanner;

public class ConsolePrompter implements Prompter {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String promptForString() {
        return scanner.nextLine();
    }

    @Override
    public int promptForInt() {
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        return choice;
    }
}
