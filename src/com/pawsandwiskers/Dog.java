package com.pawsandwiskers;

public class Dog implements Pet {
    private String name;
    private int energy;
    private int life;
    private int potty;
    private int hungerThirst;

    //constructors
    public Dog(String name) {
        setName(name);
    }

    public Dog(String name, int energy, int life, int potty, int hungerThirst) {
        setName(name);
        setEnergy(100);
        setLife(3);
        setPotty(0);
        setHungerThirst(0);
    }


    @Override
    public void eat() {
        System.out.println(getName() + " is eating.");
    }

    @Override
    public void walk() {
        System.out.println(getName() + " is walking.");
    }

    @Override
    public void exercise() {
        System.out.println(getName() + " is exercising.");
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing.");
    }

    @Override
    public void love() {
        System.out.println(getName() + " is being loved ❤ ");
    }

    @Override
    public void cuddle() {
        System.out.println(getName() + " is being cuddled.");
    }

    @Override
    public void pet() {
        System.out.println(getName() + " is being petted.");

    }

    @Override
    public void die() {
        System.out.println(getName() + " died ﮩ٨ـﮩﮩ٨ـ♡ﮩ٨ـﮩﮩ٨ـ");

    }

    @Override
    public void sleep() {
        System.out.println(getName() + " is sleeping.");

    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getEnergy() {
        return 0;
    }

    @Override
    public int getLife() {
        return 0;
    }

    @Override
    public int getPotty() {
        return 0;
    }

    @Override
    public int getHungerThirst() {
        return 0;
    }

    @Override
    public void displayStatus() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setPotty(int potty) {
        this.potty = potty;
    }

    public void setHungerThirst(int hungerThirst) {
        this.hungerThirst = hungerThirst;
    }
}
