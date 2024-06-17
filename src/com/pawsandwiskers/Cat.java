package com.pawsandwiskers;

public class Cat implements Pet {
    private String name;
    private int energy;
    private int life;
    private int potty;
    private int hungerThirst;

    //constructors
    public Cat(String name) {
        setName(name);
    }

    public Cat(String name, int energy, int life, int potty) {
        setName(name);
        setEnergy(energy);
        setLife(life);
        setPotty(potty);
    }

    @Override
    public void eat() {


    }

    @Override
    public void walk() {

    }

    @Override
    public void exercise() {

    }

    @Override
    public void play() {

    }

    @Override
    public void love() {

    }

    @Override
    public void cuddle() {

    }

    @Override
    public void pet() {

    }

    @Override
    public void die() {

    }

    @Override
    public void sleep() {

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

