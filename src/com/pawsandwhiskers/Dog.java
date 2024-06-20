package com.pawsandwhiskers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Dog extends Pet {

    Dog(String name) {
        super(name);
    }

    Dog(String name, int energy, int life, int potty, int hungerThirst) {
        super(name, energy, life, potty, hungerThirst);
    }

    @Override
    public void eat(){
        setHungerThirst(Math.max(getHungerThirst() - 10, 0));
        System.out.println(getName() + " is eating!");
        increaseLife();
    }

    public void walk() {
        setEnergy(Math.max(getEnergy() - 10, 0));
        setPotty(Math.min(getPotty() - 10, 0)); // Decrease potty level by 10
        System.out.println(getName() + " is walking.");
        System.out.println(" " +
                "/ \\__\n" +
                "(    @\\___\n" +
                " /         O\n" +
                "/   (_____/\n" +
                "/_/_____/ \n");
        increaseLife();
    }

    @Override
    public void exercise() {
        setEnergy(Math.max(getEnergy() - 10, 0));
        System.out.println(getName() + " is exercising.");
    }

    @Override
    public void play() {
        setEnergy(Math.max(getEnergy() - 20, 0));
        System.out.println(getName() + " is playing.");
    }

    @Override
    public void love() {
        setEnergy(Math.min(getEnergy() + 5, 100));
        System.out.println(getName() + " is being loved ❤ ");
        increaseLife();
    }

    @Override
    public void cuddle() {
        setEnergy(Math.min(100, getEnergy() + 10)); // Increase energy by 10, capped at 100
        System.out.println(getName() + " is being cuddled.");
    }

    @Override
    public void pet() {
        setEnergy(Math.min(getEnergy() + 5, 100));
        System.out.println(getName() + " is being petted.");
        increaseLife();
    }

    @Override
    public String die() {
        String message="";
        if (getLife() <= 0) {
            System.out.println(getName() + " died 🐾");
            message = getName() + " died 🐾";
        }
        return message;
    }

    @Override
    public void sleep() {
        setEnergy(Math.max(getEnergy() + 20, 100));
        System.out.println(getName() + " is sleeping");
        increaseLife();
    }

    public void setEnergyLevel(int i) {
    }

    public int getEnergyLevel() {
        return 100;
    }
}

