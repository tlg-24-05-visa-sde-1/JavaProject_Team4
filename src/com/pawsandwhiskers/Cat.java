package com.pawsandwhiskers;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cat extends Pet {

   Cat(String name) {
        super(name);
    }

    Cat(String name, int energy, int life, int potty, int hungerThirst) {
        super(name, energy, life, potty, hungerThirst);
    }

    @Override
    public void eat() {
        setHungerThirst(Math.max(getHungerThirst() - 20, 0));
        try {
            for (String line : Files.readAllLines(Path.of("resources/cateating.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " is eating!");
        increaseLife();
    }

    @Override
    public void exercise() {
        setEnergy(Math.max(getEnergy() - 10, 0));
        try {
            for (String line : Files.readAllLines(Path.of("resources/catplay.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " is stretching and exercising.");
    }

    @Override
    public void play() {
        setEnergy(Math.max(getEnergy() - 15, 0));
        try {
            for (String line : Files.readAllLines(Path.of("resources/catplay.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " is playing with a toy.");
    }

    @Override
    public void love() {
        setEnergy(Math.min(getEnergy() + 5, 100));
        try {
            for (String line : Files.readAllLines(Path.of("resources/catlove.txt"))) {
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
            for (String line : Files.readAllLines(Path.of("resources/catlove.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " curls up and enjoys cuddling.");
    }

    @Override
    public void pet() {
        setEnergy(Math.min(getEnergy() + 5, 100));
        try {
            for (String line : Files.readAllLines(Path.of("resources/catlove.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " purrs as you pet it.");
        increaseLife();
    }

    @Override
    public String die() {
       String message= "";
        if (getLife() <= 0) {
            try {
                for (String line : Files.readAllLines(Path.of("resources/grave.txt"))) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
            }
            System.out.println(getName() + " passed away. Rest in peace. ﮩ٨ـﮩﮩ٨ـ♡ﮩ٨ـﮩﮩ٨ـ");
            message = getName() + " passed away. Rest in peace. ﮩ٨ـﮩﮩ٨ـ♡ﮩ٨ـﮩﮩ٨ـ";
        }
        return message;
    }

    @Override
    public void sleep() {
        setEnergy(Math.min(getEnergy() + 40, 100));
        try {
            for (String line : Files.readAllLines(Path.of("resources/catsleeping.txt"))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        System.out.println(getName() + " finds a cozy spot and goes to sleep.");
        increaseLife();
    }
}
