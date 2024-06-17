package com.pawsandwiskers;

public interface Pet {
    void eat();
    void walk();
    void exercise();
    void play();
    void love();
    void cuddle();
    void pet();
    void die();
    void sleep();

    String getName();
    int getEnergy();
    int getLife();
    int getPotty();
    int getHungerThirst();
    void displayStatus();

    //methods to update pet attributes
    void setEnergy(int energy);
    void setLife(int life);
    void setPotty(int potty);
    void setHungerThirst(int hungerThirst);

//    // death related methods
//    boolean isAlive();
//    void markAsDeceased();
}
