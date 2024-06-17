package com.pawsandwhiskers;

public class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    public Dog(String name, int energy, int life, int potty, int hungerThirst) {
        super(name, energy, life, potty, hungerThirst);
    }

    @Override
    public void eat() {
        setHungerThirst(Math.max(getHungerThirst() - 10, 0));
        System.out.println(getName() + " is eating!");
        increaseLife();
    }

    @Override
    public void walk() {
        setEnergy(Math.max(getEnergy() - 10, 0));
        setPotty(Math.max(getPotty() - 10, 100));
        System.out.println(getName() + " is walking.");
        increaseLife();
    }

    @Override
    public void exercise() {
        setEnergy(Math.max(getEnergy() - 15, 0));
        System.out.println(getName() + " is exercising.");
    }

    @Override
    public void play() {
        setEnergy(Math.max(getEnergy() - 20, 0));
        System.out.println(getName() + " is playing.");
    }

    @Override
    public void love() {
        setEnergy(Math.max(getEnergy() + 5, 100));
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
        setEnergy(Math.max(getEnergy() + 5, 100));
        System.out.println(getName() + " is being petted.");
        increaseLife();
    }

    @Override
    public void die() {
        if (getLife() <= 0) {
            System.out.println(getName() + " died ﮩ٨ـﮩﮩ٨ـ♡ﮩ٨ـﮩﮩ٨ـ");
        }
    }

    @Override
    public void sleep() {
        setEnergy(Math.max(getEnergy() + 20, 100));
        System.out.println(getName() + " is sleeping.");
        increaseLife();
    }

    public void setEnergyLevel(int i) {
    }

    public int getEnergyLevel() {
        return 100;
    }
}

