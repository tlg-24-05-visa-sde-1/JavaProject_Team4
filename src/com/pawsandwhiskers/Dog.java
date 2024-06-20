package com.pawsandwhiskers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Dog extends Pet {

    Dog(String name) {
        super(name);
    }


    @Override
    public void eat() {
        setHungerThirst(Math.max(getHungerThirst() - 10, 0));

        try {
            for (String line : Files.readAllLines(Path.of("resources/dogeating.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " is eating!");
        increaseLife();
    }

    public void walk() {
        setEnergy(Math.max(getEnergy() - 10, 0));
        setPotty(Math.min(getPotty() - 10, 0)); // Decrease potty level by 10
        setHungerThirst(Math.min(getHungerThirst() +10, 100));

        try {
            for (String line : Files.readAllLines(Path.of("resources/dogwalk.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " is walking.");
    }

    @Override
    public void exercise() {
        setEnergy(Math.max(getEnergy() - 10, 0));
        setHungerThirst(Math.min(getHungerThirst() +20, 100));

        try {
            for (String line : Files.readAllLines(Path.of("resources/dogexercising.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " is exercising.");
    }

    @Override
    public void play() {
        setEnergy(Math.max(getEnergy() - 20, 0));
        setHungerThirst(Math.min(getHungerThirst() +20, 100));

        try {
            for (String line : Files.readAllLines(Path.of("resources/dogplay.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " is playing.");
    }

    @Override
    public void love() {
        setEnergy(Math.min(getEnergy() + 5, 100));
        try {
            for (String line : Files.readAllLines(Path.of("resources/doglove.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " is being loved ❤ ");
        increaseLife();
    }

    @Override
    public void cuddle() {
        setEnergy(Math.min(100, getEnergy() + 10)); // Increase energy by 10, capped at 100
        try {
            for (String line : Files.readAllLines(Path.of("resources/doglove.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " is being cuddled.");
    }

    @Override
    public void pet() {
        setEnergy(Math.min(getEnergy() + 5, 100));
        try {
            for (String line : Files.readAllLines(Path.of("resources/doglove.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " is being petted.");
        increaseLife();
    }

    @Override
    public String die() {
        String message = "";
        if (getLife() <= 0) {
            try {
                for (String line : Files.readAllLines(Path.of("resources/grave.txt"))) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
            }
            //System.out.println(getName() + " died 🐾");
            message = getName() + " died";
        }
        return message;
    }

    @Override
    public void sleep() {
        setEnergy(Math.max(getEnergy() + 20, 100));
        try {
            for (String line : Files.readAllLines(Path.of("resources/dogsleeping.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " is sleeping");
        increaseLife();
        //checkForDeath(); // Check for death after updating energy
    }
}
