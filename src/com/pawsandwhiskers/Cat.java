package com.pawsandwhiskers;

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
        System.out.println(getName() + " is eating!");
        increaseLife();
    }

    @Override
    public void exercise() {
        setEnergy(Math.max(getEnergy() - 10, 0));
        System.out.println(getName() + " is stretching and exercising.");
    }

    @Override
    public void play() {
        setEnergy(Math.max(getEnergy() - 15, 0));
        System.out.println(getName() + " is playing with a toy.");
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
        System.out.println(getName() + " curls up and enjoys cuddling.");
    }

    @Override
    public void pet() {
        setEnergy(Math.max(getEnergy() + 5, 100));
        System.out.println(getName() + " purrs as you pet it.");
        increaseLife();
    }

    @Override
    public void die() {
        if (getLife() <= 0) {
            System.out.println(getName() + " passed away. Rest in peace. ﮩ٨ـﮩﮩ٨ـ♡ﮩ٨ـﮩﮩ٨ـ");
        }
    }

    @Override
    public void sleep() {
        setEnergy(Math.max(getEnergy() + 40, 100));
        System.out.println(getName() + " finds a cozy spot and goes to sleep.");
        increaseLife();
    }
}
